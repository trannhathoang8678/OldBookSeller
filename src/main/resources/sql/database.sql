-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bookdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bookdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookdb` DEFAULT CHARACTER SET utf8 ;
USE `bookdb` ;

-- -----------------------------------------------------
-- Table `bookdb`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookdb`.`USER` (
  `id` INT NOT NULL,
  `phonenumber` CHAR(10) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phonenumber_UNIQUE` (`phonenumber` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookdb`.`TYPE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookdb`.`TYPE` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookdb`.`BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookdb`.`BOOK` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `TYPE_id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `year_published` INT NULL,
  `author` VARCHAR(45) NULL,
  `prize` DECIMAL NULL,
  `contact_info` VARCHAR(45) NULL,
  `day_posted` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_BOOK_TYPE_idx` (`TYPE_id` ASC),
  CONSTRAINT `fk_BOOK_TYPE`
    FOREIGN KEY (`TYPE_id`)
    REFERENCES `bookdb`.`TYPE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookdb`.`FAVORITE_BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookdb`.`FAVORITE_BOOK` (
  `BOOK_id` INT NOT NULL,
  `USER_id` INT NOT NULL,
  INDEX `fk_FAVORITE_BOOK_BOOK1_idx` (`BOOK_id` ASC),
  INDEX `fk_FAVORITE_BOOK_USER1_idx` (`USER_id` ASC),
  CONSTRAINT `fk_FAVORITE_BOOK_BOOK1`
    FOREIGN KEY (`BOOK_id`)
    REFERENCES `bookdb`.`BOOK` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FAVORITE_BOOK_USER1`
    FOREIGN KEY (`USER_id`)
    REFERENCES `bookdb`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
