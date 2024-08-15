CREATE TABLE `current_account`
(
    `active`    bit(1)         DEFAULT NULL,
    `balance`   decimal(38, 2) DEFAULT NULL,
    `holder_id` bigint         DEFAULT NULL,
    `id`        bigint NOT NULL AUTO_INCREMENT,
    `agency`    varchar(255)   DEFAULT NULL,
    `number`    varchar(255)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY         `FKjapxjfm3qo7hyid3igcd5stm3` (`holder_id`),
    CONSTRAINT `FKjapxjfm3qo7hyid3igcd5stm3` FOREIGN KEY (`holder_id`) REFERENCES `holder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;