CREATE TABLE `springboot_demo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `springboot_demo`.`addemployee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `empid` varchar(50) DEFAULT NULL,
  `empname` varchar(40) DEFAULT NULL,
  `empsalary` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `springboot_demo`.`user`
(`id`,
`username`,
`password`)
VALUES
('1','admin','admin');