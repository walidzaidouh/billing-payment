-- Create schema
CREATE SCHEMA IF NOT EXISTS payment;

-- =========================================
-- GLOBAL SEQUENCE
-- =========================================
CREATE SEQUENCE IF NOT EXISTS payment.GLOBAL_SEQUENCE
    START WITH 1
    INCREMENT BY 1;

-- =========================================
-- TABLE: CAISSE
-- =========================================
CREATE TABLE payment.CAISSE (
                                ID BIGINT PRIMARY KEY DEFAULT nextval('payment.GLOBAL_SEQUENCE'),

                                CREATED_DATE DATE,
                                UPDATED_DATE TIMESTAMP,

                                MONTANT_DEPART NUMERIC(19,2),
                                SOLDE NUMERIC(19,2),
                                PDV_ID BIGINT,
                                IS_CLOSED BOOLEAN
);

-- =========================================
-- TABLE: RECONCILIATION
-- =========================================
CREATE TABLE payment.RECONCILIATION (
                                        ID BIGINT PRIMARY KEY DEFAULT nextval('payment.GLOBAL_SEQUENCE'),

                                        CREATED_DATE DATE,
                                        UPDATED_DATE TIMESTAMP,

                                        TOTAL_DEBIT NUMERIC(19,2),
                                        TOTAL_CREDIT NUMERIC(19,2),
                                        IS_CORRECT BOOLEAN,

                                        CAISSE_ID BIGINT,

                                        CONSTRAINT FK_RECONCILIATION_CAISSE
                                            FOREIGN KEY (CAISSE_ID)
                                                REFERENCES payment.CAISSE(ID)
);

-- =========================================
-- TABLE: TRANSACTION
-- =========================================
-- WARNING: TRANSACTION is a reserved keyword → quoted
CREATE TABLE payment."TRANSACTION" (
                                       ID BIGINT PRIMARY KEY DEFAULT nextval('payment.GLOBAL_SEQUENCE'),

                                       CREATED_DATE DATE,
                                       UPDATED_DATE TIMESTAMP,

                                       DATE TIMESTAMP,
                                       MONTANT NUMERIC(19,2),
                                       OPERATION_TYPE VARCHAR(50),

                                       CAISSE_ID BIGINT,
                                       CUSTOMER_ID BIGINT,

                                       CONSTRAINT FK_TRANSACTION_CAISSE
                                           FOREIGN KEY (CAISSE_ID)
                                               REFERENCES payment.CAISSE(ID)
);

-- =========================================
-- INDEXES (recommended)
-- =========================================
CREATE INDEX IDX_TRANSACTION_CAISSE_ID
    ON payment."TRANSACTION"(CAISSE_ID);

CREATE INDEX IDX_RECONCILIATION_CAISSE_ID
    ON payment.RECONCILIATION(CAISSE_ID);