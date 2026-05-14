-- =========================
-- SCHEMA
-- =========================
CREATE SCHEMA IF NOT EXISTS payment;

-- =========================
-- GLOBAL SEQUENCE
-- =========================
CREATE SEQUENCE IF NOT EXISTS GLOBAL_SEQUENCE
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    CACHE 1;

-- =========================
-- POINT DE VENTE
-- =========================
CREATE TABLE payment.point_de_vente (
                                        id BIGINT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQUENCE'),
                                        created_date TIMESTAMP,
                                        updated_date TIMESTAMP,
                                        name VARCHAR(255),
                                        adresse VARCHAR(255)
);

-- =========================
-- CUSTOMER
-- =========================
CREATE TABLE customer (
                          id BIGINT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQUENCE'),
                          created_date TIMESTAMP,
                          updated_date TIMESTAMP,
                          prenom VARCHAR(255),
                          nom VARCHAR(255),
                          adresse VARCHAR(255),
                          payment_type VARCHAR(50)
);

-- =========================
-- TRANSACTION
-- =========================
CREATE TABLE transaction (
                             id BIGINT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQUENCE'),
                             created_date TIMESTAMP,
                             updated_date TIMESTAMP,
                             date TIMESTAMP,
                             montant DOUBLE PRECISION,
                             operation_type VARCHAR(50),
                             customer_id BIGINT,

                             CONSTRAINT fk_transaction_customer
                                 FOREIGN KEY (customer_id)
                                     REFERENCES customer(id)
);

-- =========================
-- CAISSE
-- =========================
CREATE TABLE caisse (
                        id BIGINT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQUENCE'),
                        created_date TIMESTAMP,
                        updated_date TIMESTAMP,
                        date TIMESTAMP,
                        montant_depart NUMERIC(19,2),
                        solde NUMERIC(19,2),
                        pdv_id BIGINT,

                        CONSTRAINT fk_caisse_pdv
                            FOREIGN KEY (pdv_id)
                                REFERENCES payment.point_de_vente(id)
);

-- =========================
-- CAISSE - TRANSACTIONS
-- =========================
CREATE TABLE caisse_transactions (
                                     caisse_id BIGINT NOT NULL,
                                     transaction_id BIGINT NOT NULL,

                                     PRIMARY KEY (caisse_id, transaction_id),

                                     CONSTRAINT fk_ct_caisse
                                         FOREIGN KEY (caisse_id)
                                             REFERENCES caisse(id),

                                     CONSTRAINT fk_ct_transaction
                                         FOREIGN KEY (transaction_id)
                                             REFERENCES transaction(id)
);

-- =========================
-- RECONCILIATION
-- =========================
CREATE TABLE reconciliation (
                                id BIGINT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQUENCE'),
                                created_date TIMESTAMP,
                                updated_date TIMESTAMP,
                                total_debit NUMERIC(19,2),
                                total_credit NUMERIC(19,2),
                                is_correct BOOLEAN,
                                caisse_id BIGINT UNIQUE,

                                CONSTRAINT fk_reconciliation_caisse
                                    FOREIGN KEY (caisse_id)
                                        REFERENCES caisse(id)
);

-- =========================
-- INDEXES
-- =========================
CREATE INDEX idx_transaction_customer ON transaction(customer_id);
CREATE INDEX idx_caisse_pdv ON caisse(pdv_id);
CREATE INDEX idx_reconciliation_caisse ON reconciliation(caisse_id);