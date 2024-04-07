-- liquibase formatted sql

-- changeset Muzaffar-Ashurov:create-bad_product-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'bad_product_db' AND TABLE_NAME='bad_product';
CREATE TABLE `bad_product_db`.`bad_product` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(255) NOT NULL,
   `defect_type` VARCHAR(255) NOT NULL,
   `quantity` INT NOT NULL,
   `date_field` datetime NOT NULL,
   CONSTRAINT pk_bad_product PRIMARY KEY (`id`));

-- changeset Muzaffar-Ashurov:create-role-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'bad_product_db' AND TABLE_NAME='role';
CREATE TABLE `bad_product_db`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Muzaffar-Ashurov:create-user-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'bad_product_db' AND TABLE_NAME='user';
CREATE TABLE `bad_product_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) UNIQUE NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Muzaffar-Ashurov:create-user_roles-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'bad_product_db' AND TABLE_NAME='user_roles';
 CREATE TABLE `bad_product_db`.`user_roles` (
      `user_id` INT NOT NULL,
      `role_id` INT NOT NULL,
      PRIMARY KEY (`user_id`, `role_id`),
      INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
      CONSTRAINT `user_id`
        FOREIGN KEY (`user_id`)
        REFERENCES `bad_product_db`.`user` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT `role_id`
        FOREIGN KEY (`role_id`)
        REFERENCES `bad_product_db`.`role` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);