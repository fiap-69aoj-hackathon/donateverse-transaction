CREATE TABLE `transaction` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `id_user` BIGINT(20) NOT NULL,
    `status` TINYINT(1) NOT NULL,
    `creation_date` DATE NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;