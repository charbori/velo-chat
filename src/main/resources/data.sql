
drop table if exists member;
CREATE TABLE `member`(
    `id` int(11) not null,
    `name` char(20) default null,
    primary key(`id`)
) engine=innodb default charset=utf8;