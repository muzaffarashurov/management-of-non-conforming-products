-- liquibase formatted sql

-- changeset Muzaffar-Ashurov:create-bad_products-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'bad_products_db' AND TABLE_NAME='bad_products';
CREATE TABLE `bad_products_db`.`bad_products` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(255) NOT NULL,
   `defect_type` VARCHAR(255) NOT NULL,
   `quantity` INT NOT NULL,
   `date_field` date NOT NULL,
   CONSTRAINT pk_bad_products PRIMARY KEY (`id`)
);