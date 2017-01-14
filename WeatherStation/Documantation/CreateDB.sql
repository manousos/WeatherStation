-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema iot
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema iot
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `iot` DEFAULT CHARACTER SET greek ;
USE `iot` ;

-- -----------------------------------------------------
-- Table `iot`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot`.`location` (
  `id` BIGINT(20) NOT NULL,
  `last_modified` DATETIME NULL DEFAULT NULL,
  `version` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = greek;


-- -----------------------------------------------------
-- Table `iot`.`humidity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot`.`humidity` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `last_modified` DATETIME NULL DEFAULT NULL,
  `version` BIGINT(20) NOT NULL,
  `humidity` FLOAT NOT NULL,
  `sample_date` DATETIME NULL DEFAULT NULL,
  `location_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKb18h5chg8p33xgholnwmr54k` (`location_id` ASC),
  CONSTRAINT `FKb18h5chg8p33xgholnwmr54k`
    FOREIGN KEY (`location_id`)
    REFERENCES `iot`.`location` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = greek;


-- -----------------------------------------------------
-- Table `iot`.`temperature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot`.`temperature` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `last_modified` DATETIME NULL DEFAULT NULL,
  `version` BIGINT(20) NOT NULL,
  `sample_date` DATETIME NULL DEFAULT NULL,
  `temperature` FLOAT NOT NULL,
  `location_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK5s813qp9htr5ferdo702kak32` (`location_id` ASC),
  CONSTRAINT `FK5s813qp9htr5ferdo702kak32`
    FOREIGN KEY (`location_id`)
    REFERENCES `iot`.`location` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = greek;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
