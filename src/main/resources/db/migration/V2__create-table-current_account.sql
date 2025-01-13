CREATE TABLE current_account
(
    active    bit(1)         DEFAULT NULL,
    balance   decimal(38, 2) DEFAULT NULL,
    holder_id bigint         DEFAULT NULL,
    id        bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    agency    varchar(255)   DEFAULT NULL,
    number    varchar(255)   DEFAULT NULL UNIQUE,
    FOREIGN KEY (holder_id) REFERENCES holder (id)
)
