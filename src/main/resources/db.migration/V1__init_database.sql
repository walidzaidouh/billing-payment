CREATE TABLE point_de_vente (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    adresse VARCHAR(255)
);

CREATE TABLE caisse (
    id BIGSERIAL PRIMARY KEY,
    date TIMESTAMP,
    montant_depart NUMERIC(19,2),
    solde NUMERIC(19,2),

    pdv_id BIGINT,

    CONSTRAINT fk_caisse_pdv
        FOREIGN KEY (pdv_id)
        REFERENCES point_de_vente(id)
);

CREATE TABLE reconciliation (
    id BIGSERIAL PRIMARY KEY,

    caisse_id BIGINT UNIQUE,

    total_debit NUMERIC(19,2),
    total_credit NUMERIC(19,2),
    is_correct BOOLEAN,

    CONSTRAINT fk_reconciliation_caisse
        FOREIGN KEY (caisse_id)
        REFERENCES caisse(id)
        ON DELETE CASCADE
);

CREATE TYPE operation_type AS ENUM ('DEBIT', 'CREDIT');

CREATE TABLE transaction (
    id BIGSERIAL PRIMARY KEY,
    date TIMESTAMP,
    montant DOUBLE PRECISION,

    operation_type operation_type,

    caisse_id BIGINT UNIQUE,

    CONSTRAINT fk_transaction_caisse
        FOREIGN KEY (caisse_id)
        REFERENCES caisse(id)
        ON DELETE CASCADE
);

CREATE TABLE caisse_transactions (
    caisse_id BIGINT NOT NULL,
    transaction_id BIGINT NOT NULL,

    PRIMARY KEY (caisse_id, transaction_id),

    CONSTRAINT fk_ct_caisse
        FOREIGN KEY (caisse_id)
        REFERENCES caisse(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_ct_transaction
        FOREIGN KEY (transaction_id)
        REFERENCES transaction(id)
        ON DELETE CASCADE
);