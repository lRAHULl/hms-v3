-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospital` DEFAULT CHARACTER SET utf8 ;
USE `hospital` ;

-- -----------------------------------------------------
-- Table `hospital`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`flyway_schema_history` (
  `installed_rank` INT(11) NOT NULL,
  `version` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `script` VARCHAR(1000) NOT NULL,
  `checksum` INT(11) NULL DEFAULT NULL,
  `installed_by` VARCHAR(100) NOT NULL,
  `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` INT(11) NOT NULL,
  `success` TINYINT(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  INDEX `flyway_schema_history_s_idx` (`success` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`sampleee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`sampleee` (
  `id` INT(11) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_admin` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` TINYINT(4) NULL DEFAULT '0',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pk_admin_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pk_admin_id`),
  UNIQUE INDEX `pk_admin_id_UNIQUE` (`pk_admin_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_hospital` (
  `pk_hospital_id` INT(11) NOT NULL AUTO_INCREMENT,
  `hospital_name` VARCHAR(45) NOT NULL,
  `is_deleted` TINYINT(4) NOT NULL DEFAULT '0',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_hospital_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_branch` (
  `pk_branch_id` INT(11) NOT NULL AUTO_INCREMENT,
  `branch_location` VARCHAR(45) NOT NULL,
  `fk_hospital_id` INT(11) NOT NULL,
  `is_deleted` TINYINT(4) NOT NULL DEFAULT '0',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_branch_id`),
  INDEX `fk_Branch_Hospital_idx` (`fk_hospital_id` ASC) VISIBLE,
  CONSTRAINT `fk_Branch_Hospital`
    FOREIGN KEY (`fk_hospital_id`)
    REFERENCES `hospital`.`t_hospital` (`pk_hospital_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_branch_admin_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_branch_admin_mapping` (
  `fk_branch_id` INT(11) NOT NULL,
  `fk_admin_id` INT(11) NOT NULL,
  `is_deleted` TINYINT(4) NULL DEFAULT '0',
  `create_time` DATETIME NULL DEFAULT NULL,
  `update_time` TIMESTAMP(2) NULL DEFAULT NULL,
  INDEX `branch id_idx` (`fk_branch_id` ASC) VISIBLE,
  INDEX `admin id_idx` (`fk_admin_id` ASC) VISIBLE,
  CONSTRAINT `admin id`
    FOREIGN KEY (`fk_admin_id`)
    REFERENCES `hospital`.`t_admin` (`pk_admin_id`),
  CONSTRAINT `branch id`
    FOREIGN KEY (`fk_branch_id`)
    REFERENCES `hospital`.`t_branch` (`pk_branch_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_role` (
  `pk_role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_desc` VARCHAR(45) NOT NULL,
  `is_deleted` TINYINT(4) NOT NULL DEFAULT '0',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_user` (
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `pk_user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_role_id` INT(11) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `is_deleted` TINYINT(4) NOT NULL DEFAULT '0',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  INDEX `fk_role_id_idx` (`fk_role_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_id`
    FOREIGN KEY (`fk_role_id`)
    REFERENCES `hospital`.`t_role` (`pk_role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 109
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_branch_user_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_branch_user_mapping` (
  `fk_branch_id` INT(11) NOT NULL,
  `fk_user_id` INT(11) NOT NULL,
  `is_deleted` TINYINT(4) NOT NULL DEFAULT '0',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `branch_user_map_idx` (`fk_branch_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`fk_user_id` ASC) VISIBLE,
  CONSTRAINT `branch_id`
    FOREIGN KEY (`fk_branch_id`)
    REFERENCES `hospital`.`t_branch` (`pk_branch_id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`fk_user_id`)
    REFERENCES `hospital`.`t_user` (`pk_user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_doctor` (
  `pk_doctor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `doctor_specialisation` VARCHAR(45) NULL DEFAULT NULL,
  `fk_user_id` INT(11) NOT NULL,
  `is_deleted` TINYINT(4) NULL DEFAULT '0',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `experience` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_doctor_id`),
  INDEX `fk_doctor_user1_idx` (`fk_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_doctor_user1`
    FOREIGN KEY (`fk_user_id`)
    REFERENCES `hospital`.`t_user` (`pk_user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_patient` (
  `pk_patient_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_user_id` INT(11) NOT NULL,
  `patient_height` INT(11) NULL DEFAULT NULL,
  `patient_weight` INT(11) NULL DEFAULT NULL,
  `is_deleted` TINYINT(4) NULL DEFAULT '0',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `door_no` VARCHAR(45) NULL DEFAULT NULL,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `blood_group` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_patient_id`),
  INDEX `fk_patient_user1_idx` (`fk_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient_user1`
    FOREIGN KEY (`fk_user_id`)
    REFERENCES `hospital`.`t_user` (`pk_user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hospital`.`t_patient_doctor_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`t_patient_doctor_mapping` (
  `disease` VARCHAR(45) NULL DEFAULT NULL,
  `fk_patient_id` INT(11) NOT NULL,
  `fk_doctor_id` INT(11) NOT NULL,
  `is_deleted` TINYINT(4) NULL DEFAULT '0',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `id_idx` (`fk_patient_id` ASC) VISIBLE,
  INDEX `doctor id_idx` (`fk_doctor_id` ASC) VISIBLE,
  CONSTRAINT `doctor id`
    FOREIGN KEY (`fk_doctor_id`)
    REFERENCES `hospital`.`t_user` (`pk_user_id`),
  CONSTRAINT `patient id`
    FOREIGN KEY (`fk_patient_id`)
    REFERENCES `hospital`.`t_user` (`pk_user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
