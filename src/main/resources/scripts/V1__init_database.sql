
-- =========================
-- GLOBAL SEQUENCE
-- =========================
CREATE SEQUENCE IF NOT EXISTS payment.GLOBAL_SEQUENCE
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    CACHE 1;

CREATE SCHEMA IF NOT EXISTS payment;

-- =========================
-- CAISSE
-- =========================
CREATE TABLE payment.caisse (
                                id BIGINT PRIMARY KEY,
                                created_date TIMESTAMP,
                                updated_date TIMESTAMP,
                                is_closed BOOLEAN,
                                montant_depart NUMERIC(19,2),
                                solde NUMERIC(19,2),
                                pdv_id BIGINT
);

-- =========================
-- TRANSACTION
-- =========================
CREATE TABLE payment.transaction (
                                     id BIGINT PRIMARY KEY,
                                     created_date TIMESTAMP,
                                     updated_date TIMESTAMP,
                                     date TIMESTAMP,
                                     montant NUMERIC(19,2),
                                     operation_type VARCHAR(50),

                                     caisse_id BIGINT,

                                     CONSTRAINT fk_transaction_caisse
                                         FOREIGN KEY (caisse_id)
                                             REFERENCES payment.caisse(id)
);

CREATE INDEX idx_transaction_caisse_id
    ON payment.transaction(caisse_id);

-- =========================
-- RECONCILIATION
-- =========================
CREATE TABLE payment.reconciliation (
                                        id BIGINT PRIMARY KEY,
                                        created_date TIMESTAMP,
                                        updated_date TIMESTAMP,

                                        total_credit NUMERIC(19,2),
                                        total_debit NUMERIC(19,2),
                                        is_correct BOOLEAN,

                                        caisse_id BIGINT,

                                        CONSTRAINT fk_reconciliation_caisse
                                            FOREIGN KEY (caisse_id)
                                                REFERENCES payment.caisse(id)
);