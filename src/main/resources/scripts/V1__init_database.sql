


-- =========================================
-- GLOBAL SEQUENCE
-- =========================================
CREATE SEQUENCE payment.global_sequence
    START WITH 1
    INCREMENT BY 1;

-- =========================================
-- TABLE: CAISSE
-- =========================================
CREATE TABLE payment.caisse (
                                id BIGINT PRIMARY KEY DEFAULT nextval('payment.global_sequence'),

                                created_date TIMESTAMP,
                                updated_date TIMESTAMP,

                                montant_depart NUMERIC(19,2),
                                solde NUMERIC(19,2),
                                pdv_id BIGINT,
                                is_closed BOOLEAN
);

-- =========================================
-- TABLE: RECONCILIATION
-- =========================================
CREATE TABLE payment.reconciliation (
                                        id BIGINT PRIMARY KEY DEFAULT nextval('payment.global_sequence'),

                                        created_date TIMESTAMP,
                                        updated_date TIMESTAMP,

                                        total_debit NUMERIC(19,2),
                                        total_credit NUMERIC(19,2),
                                        is_correct BOOLEAN,

                                        caisse_id BIGINT,

                                        CONSTRAINT fk_reconciliation_caisse
                                            FOREIGN KEY (caisse_id)
                                                REFERENCES payment.caisse(id)
);

-- =========================================
-- TABLE: TRANSACTIONS ✅ (FIXED NAME)
-- =========================================
CREATE TABLE payment.transactions (
                                      id BIGINT PRIMARY KEY DEFAULT nextval('payment.global_sequence'),

                                      created_date TIMESTAMP,
                                      updated_date TIMESTAMP,

                                      montant NUMERIC(19,2),
                                      operation_type VARCHAR(50),

                                      caisse_id BIGINT,
                                      customer_id BIGINT,

                                      pv_id BIGINT,
                                      creancier_id BIGINT,

                                      CONSTRAINT fk_transactions_caisse
                                          FOREIGN KEY (caisse_id)
                                              REFERENCES payment.caisse(id)
);

-- =========================================
-- INDEXES
-- =========================================
CREATE INDEX idx_transactions_caisse_id
    ON payment.transactions(caisse_id);

CREATE INDEX idx_transactions_pv_id
    ON payment.transactions(pv_id);

CREATE INDEX idx_transactions_creancier_id
    ON payment.transactions(creancier_id);

CREATE INDEX idx_reconciliation_caisse_id
    ON payment.reconciliation(caisse_id);