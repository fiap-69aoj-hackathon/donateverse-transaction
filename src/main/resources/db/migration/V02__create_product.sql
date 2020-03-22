CREATE TABLE `product` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `id_transaction` BIGINT(20) NOT NULL,
    `description` VARCHAR(150) NOT NULL,
    `amount` INTEGER NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`id_transaction`) REFERENCES `transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;