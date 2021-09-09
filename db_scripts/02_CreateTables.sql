#Date: September 8 2021
#Author: Carlos Marin T
#Description: Script to store all Table structures and creation order

#Sentence to create CellPhone table
CREATE TABLE `cellphone_app`.`CellPhone` (
  `EmployeeId` INT NOT NULL COMMENT 'Identity field for CellPhone table.',
  `EmployeeName` VARCHAR(50) NOT NULL COMMENT 'Stores the employee name that owns the cellphone.',
  `PurchaseDate` DATE NOT NULL COMMENT 'Stores the date the cellphone was purchased/given to the employee.',
  `Model` VARCHAR(50) NULL COMMENT 'Stores cellphone model.',
  PRIMARY KEY (`EmployeeId`))
ENGINE = InnoDB
COMMENT = 'Stores employees cellphone details.';

# Sentence to create CellPhoneUsage table
CREATE TABLE `cellphone_app`.`CellPhoneUsage` (
  `EmployeeId` INT NOT NULL COMMENT 'Stores the reference to the CellPhone table.',
  `Date` DATE NOT NULL COMMENT 'Stores the date related to the usage.',
  `TotalMinutes` INT NOT NULL COMMENT 'Total minutes used on the specified date.',
  `TotalData` DECIMAL(15,3) NOT NULL COMMENT 'Total data consume on the specified date',
  INDEX `fk_CellPhoneUsage_CellPhone_idx` (`EmployeeId` ASC) VISIBLE,
  CONSTRAINT `fk_CellPhoneUsage_CellPhone`
    FOREIGN KEY (`EmployeeId`)
    REFERENCES `cellphone_app`.`CellPhone` (`EmployeeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Stores details related to cellphone usage for each employee on different dates.';

#Sentence to add Identity column to avoid duplicates
ALTER TABLE `cellphone_app`.`CellPhoneUsage` 
ADD COLUMN `Id` INT NOT NULL AUTO_INCREMENT COMMENT 'Identity field for CellPhoneUsage table.' FIRST,
ADD PRIMARY KEY (`Id`);

