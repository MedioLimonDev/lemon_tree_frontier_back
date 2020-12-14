CREATE TABLE `lemontree`.`channel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`));

CREATE TABLE `lemontree`.`profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`));

CREATE TABLE `lemontree`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(30) NOT NULL,
  `name` VARCHAR(150) NOT NULL,
  `id_profile` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `id_profile_fk_idx` (`id_profile` ASC) VISIBLE,
  CONSTRAINT `id_profile_fk`
    FOREIGN KEY (`id_profile`)
    REFERENCES `lemontree`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_employee` INT NOT NULL,
  `issue` VARCHAR(400) NOT NULL,
  `id_client` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `id_employee_idx` (`id_employee` ASC) VISIBLE,
  INDEX `id_client2_fk_idx` (`id_client` ASC) VISIBLE,
  CONSTRAINT `id_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `lemontree`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION),
  CONSTRAINT `id_client2_fk`
    FOREIGN KEY (`id_client`)
    REFERENCES `lemontree`.`client_information` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE TABLE `lemontree`.`employee_access_channel` (
  `id_employee` INT NOT NULL,
  `id_channel` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_employee`, `id_channel`));

CREATE TABLE `lemontree`.`tecnical_information` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NOT NULL,
  `id_record` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `fk_id_record_idx` (`id_record` ASC) VISIBLE,
  CONSTRAINT `fk_id_record`
    FOREIGN KEY (`id_record`)
    REFERENCES `lemontree`.`record` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`item_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`));

CREATE TABLE `lemontree`.`client_information` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NULL,
  `n_cuenta` VARCHAR(45) NULL,
  `usi` VARCHAR(45) NULL,
  `wtn` VARCHAR(45) NULL,
  `validated` ENUM('1', '0') NOT NULL DEFAULT '0',
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`));

CREATE TABLE `lemontree`.`flow` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_channel` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `id_channel1_fk_idx` (`id_channel` ASC) VISIBLE,
  CONSTRAINT `id_channel1_fk`
    FOREIGN KEY (`id_channel`)
    REFERENCES `lemontree`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`step` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) NULL,
  `n_order` INT NOT NULL,
  `id_flow` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `id_flow_fk_idx` (`id_flow` ASC) VISIBLE,
  CONSTRAINT `id_flow_fk`
    FOREIGN KEY (`id_flow`)
    REFERENCES `lemontree`.`flow` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `n_order` INT NOT NULL,
  `id_step` INT NOT NULL,
  `id_item_type` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `id_item_type_fk_idx` (`id_item_type` ASC) VISIBLE,
  INDEX `id_step_fk_idx` (`id_step` ASC) VISIBLE,
  CONSTRAINT `id_item_type_fk`
    FOREIGN KEY (`id_item_type`)
    REFERENCES `lemontree`.`item_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_step_fk`
    FOREIGN KEY (`id_step`)
    REFERENCES `lemontree`.`step` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`subtopic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `n_order` INT NOT NULL,
  `id_item` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `fk_id_item1_idx` (`id_item` ASC) VISIBLE,
  CONSTRAINT `fk_id_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `lemontree`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`response_question` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `id_item` INT NOT NULL,
  `id_step_to_go` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `fg_active` ENUM('1', '0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `fk_id_step2_idx` (`id_step_to_go` ASC) VISIBLE,
  INDEX `fk_id_item3_idx` (`id_item` ASC) VISIBLE,
  CONSTRAINT `fk_id_step2`
    FOREIGN KEY (`id_step_to_go`)
    REFERENCES `lemontree`.`step` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_item3`
    FOREIGN KEY (`id_item`)
    REFERENCES `lemontree`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`notes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `id_record` INT NOT NULL,
  `id_response_question` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_record2_fk_idx` (`id_record` ASC) VISIBLE,
  INDEX `id_response_question1_fk_idx` (`id_response_question` ASC) VISIBLE,
  CONSTRAINT `id_record2_fk`
    FOREIGN KEY (`id_record`)
    REFERENCES `lemontree`.`record` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_response_question1_fk`
    FOREIGN KEY (`id_response_question`)
    REFERENCES `lemontree`.`response_question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `lemontree`.`flow_record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_item` INT NOT NULL,
  `id_response_question` INT NOT NULL,
  `id_step` INT NOT NULL,
  `id_record` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_item2_fk_idx` (`id_item` ASC) VISIBLE,
  INDEX `id_step2_fk_idx` (`id_step` ASC) VISIBLE,
  INDEX `id_record3_fk_idx` (`id_record` ASC) VISIBLE,
  INDEX `id_response_question3_fk_idx` (`id_response_question` ASC) VISIBLE,
  CONSTRAINT `id_item2_fk`
    FOREIGN KEY (`id_item`)
    REFERENCES `lemontree`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_step2_fk`
    FOREIGN KEY (`id_step`)
    REFERENCES `lemontree`.`step` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_record3_fk`
    FOREIGN KEY (`id_record`)
    REFERENCES `lemontree`.`record` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_response_question3_fk`
    FOREIGN KEY (`id_response_question`)
    REFERENCES `lemontree`.`response_question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);