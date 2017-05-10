-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lpg_monitoring
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lpg_monitoring` ;

-- -----------------------------------------------------
-- Schema lpg_monitoring
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lpg_monitoring` DEFAULT CHARACTER SET utf8 ;
USE `lpg_monitoring` ;

-- -----------------------------------------------------
-- Table `lpg_monitoring`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lpg_monitoring`.`company` ;

CREATE TABLE IF NOT EXISTS `lpg_monitoring`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `info` VARCHAR(45) NULL,
  `tax` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lpg_monitoring`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lpg_monitoring`.`user` ;

CREATE TABLE IF NOT EXISTS `lpg_monitoring`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`id`, `company_id`),
  INDEX `fk_user_company_idx` (`company_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_user_company`
  FOREIGN KEY (`company_id`)
  REFERENCES `lpg_monitoring`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lpg_monitoring`.`measure_system`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lpg_monitoring`.`measure_system` ;

CREATE TABLE IF NOT EXISTS `lpg_monitoring`.`measure_system` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `serialnumber` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `placement` VARCHAR(45) NULL,
  `inspection` DATE NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_measure_system_company1_idx` (`company_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_measure_system_company1`
  FOREIGN KEY (`company_id`)
  REFERENCES `lpg_monitoring`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lpg_monitoring`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lpg_monitoring`.`event` ;

CREATE TABLE IF NOT EXISTS `lpg_monitoring`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NULL,
  `type` VARCHAR(10) NULL,
  `value` VARCHAR(10) NULL,
  `temperature` VARCHAR(10) NULL,
  `location` VARCHAR(100) NULL,
  `measure_system_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_measure_system1_idx` (`measure_system_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_event_measure_system1`
  FOREIGN KEY (`measure_system_id`)
  REFERENCES `lpg_monitoring`.`measure_system` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
