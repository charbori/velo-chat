FROM mysql:5.7

CMD ["mysql -uroot -p"]
CMD ["root"]

#CMD ["create database test_db;"]
CMD ["use test_db;"]

CMD ["drop table if exists member;"]

CMD ["CREATE TABLE `member`("]
CMD ["`id` int(11) not null,"]
CMD ["`name` char(20) default null,"]
CMD ["primary key(`id`)"]
CMD [") engine=innodb default charset=utf8;"]
CMD ["exit"]