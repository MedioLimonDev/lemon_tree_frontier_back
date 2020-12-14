CREATE DATABASE lemontree2;

CREATE TABLE `lemontree2`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(150) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`));


  CREATE TABLE `lemontree2`.`record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_employee` INT NOT NULL,
  `done` ENUM('1', '0') NOT NULL DEFAULT '0',
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `id_employee_idx` (`id_employee` ASC) VISIBLE,
  CONSTRAINT `id_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `lemontree2`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `lemontree2`.`step` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `agent_activity` VARCHAR(500) NULL,
  `customer_activity` VARCHAR(500) NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`));


CREATE TABLE `lemontree2`.`response` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `id_original_step` INT NOT NULL,
  `id_next_step` INT NULL,
  `response_type` ENUM('MULTIPLE', 'STATIC') NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `fk_id_step2_idx` (`id_next_step` ASC) VISIBLE,
  INDEX `fk_id_step3_idx` (`id_original_step` ASC) VISIBLE,
  CONSTRAINT `fk_id_step2`
    FOREIGN KEY (`id_next_step`)
    REFERENCES `lemontree2`.`step` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_step3`
    FOREIGN KEY (`id_original_step`)
    REFERENCES `lemontree2`.`step` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


  CREATE TABLE `lemontree2`.`flow_record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_record` INT NOT NULL,
  `id_step` INT NOT NULL,
  `id_response` INT NOT NULL,
  `respuesta_escrita` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  INDEX `id_step2_fk_idx` (`id_step` ASC) VISIBLE,
  INDEX `id_record3_fk_idx` (`id_record` ASC) VISIBLE,
  INDEX `id_response3_fk_idx` (`id_response` ASC) VISIBLE,
  CONSTRAINT `id_step2_fk`
    FOREIGN KEY (`id_step`)
    REFERENCES `lemontree2`.`step` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_record3_fk`
    FOREIGN KEY (`id_record`)
    REFERENCES `lemontree2`.`record` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_response3_fk`
    FOREIGN KEY (`id_response`)
    REFERENCES `lemontree2`.`response` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `lemontree2`.`notes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `id_flow_record` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_flow_record_fk_idx` (`id_flow_record` ASC) VISIBLE,
  CONSTRAINT `id_flow_record_fk`
    FOREIGN KEY (`id_flow_record`)
    REFERENCES `lemontree2`.`flow_record` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);