create database test_db CHARACTER SET utf8 COLLATE utf8_general_ci;

USE test_db;

CREATE TABLE `member`(
   `id` int(11) not null,
   `name` char(20) default null,
   primary key(`id`)
) engine=innodb default charset=utf8;