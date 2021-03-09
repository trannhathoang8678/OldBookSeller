-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nhathoang
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nhathoang
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nhathoang` DEFAULT CHARACTER SET utf8 ;
USE `nhathoang` ;

-- -----------------------------------------------------
-- Table `nhathoang`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nhathoang`.`USER` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `phonenumber` CHAR(10) NULL,
  `token` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nhathoang`.`TYPE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nhathoang`.`TYPE` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nhathoang`.`BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nhathoang`.`BOOK` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `TYPE_id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `url_image` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `year_published` INT NULL,
  `author` VARCHAR(45) NULL,
  `price` DECIMAL NULL,
  `contact_info` VARCHAR(45) NULL,
  `day_posted` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_BOOK_TYPE_idx` (`TYPE_id` ASC),
  CONSTRAINT `fk_BOOK_TYPE`
    FOREIGN KEY (`TYPE_id`)
    REFERENCES `nhathoang`.`TYPE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nhathoang`.`USER_BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nhathoang`.`USER_BOOK` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `BOOK_id` INT NOT NULL,
  `USER_id` INT NOT NULL,
  `relationship` VARCHAR(45) NULL,
  INDEX `fk_FAVORITE_BOOK_BOOK1_idx` (`BOOK_id` ASC),
  INDEX `fk_FAVORITE_BOOK_USER1_idx` (`USER_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_FAVORITE_BOOK_BOOK1`
    FOREIGN KEY (`BOOK_id`)
    REFERENCES `nhathoang`.`BOOK` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FAVORITE_BOOK_USER1`
    FOREIGN KEY (`USER_id`)
    REFERENCES `nhathoang`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
