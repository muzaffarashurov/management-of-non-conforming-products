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
   CONSTRAINT pk_bad_product PRIMARY KEY (`id`)
);