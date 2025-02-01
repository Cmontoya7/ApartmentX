-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema apartmentx
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema apartmentx
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apartmentx` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `apartmentx` ;

-- -----------------------------------------------------
-- Table `apartmentx`.`apartments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apartmentx`.`apartments` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `NUMBER_BEDS` INT(11) NOT NULL,
  `NUMBER_BATHS` INT(11) NOT NULL,
  `FLOOR_SPACE` INT(11) NOT NULL,
  `PRICE` FLOAT NOT NULL,
  `QUANTITY` INT(11) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `apartmentx`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apartmentx`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `TYPE` VARCHAR(45) NOT NULL,
  `USERNAME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `FIRST_NAME` VARCHAR(45) NOT NULL,
  `LAST_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
