-- -----------------------------------------------------
-- schema cruncher-dev-v001
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `cruncher-dev-v001`;

CREATE SCHEMA `cruncher-dev-v001`;
USE `cruncher-dev-v001`;

-- -----------------------------------------------------
-- table `cruncher-dev-v001`.`tbl_movie`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `cruncher-dev-v001`.`tbl_movie` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(50) NOT NULL,
    `imdb_rating` DECIMAL(2 , 1 ) NOT NULL,
    `year_of_release` YEAR NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`title`)
)  ENGINE=INNODB AUTO_INCREMENT=1;

select  * from tbl_movie;