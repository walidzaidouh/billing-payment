ALTER TABLE payment.transaction
    ADD COLUMN caisse_id BIGINT;

ALTER TABLE payment.transaction
    ADD CONSTRAINT fk_transaction_caisse
        FOREIGN KEY (caisse_id)
            REFERENCES payment.caisse(id);

DROP TABLE IF EXISTS payment.caisse_transactions;