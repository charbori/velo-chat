FROM charbori/docker-repo:mysql_spring_image
MAINTAINER charbori

#RUN ["sed", "-i", "s/exec \"$@\"/echo \"not running $@\"/", "/usr/local/bin/docker-entrypoint.sh"]

ENV MYSQL_ROOT_PASSWORD=root
ADD ./setup.sql /docker-entrypoint-initdb.d

CMD ["mysqld"]

# RUN ["/usr/local/bin/docker-entrypoint.sh", "mysqld", "--datadir", "/initialized-db"]


# docker-entrypoint-initdb.d 시작할때 "./mysql" 있는 모든 .sql .sh 파일 실행하라는 뜻

# CMD ["mysqld --character-set-server=utf8 --collation-server=utf8_general_ci"]

#FROM mysql:latest

#COPY --from=builder /initialized-db /var/lib/mysql
#setup.sql을 활용하자
#CMD ["mysql -uroot -p"]
#CMD ["root"]
#CMD ["create database test_db;"]
#CMD ["use test_db;"]
#CMD ["drop table if exists member;"]
#CMD ["CREATE TABLE `member`("]
#CMD ["`id` int(11) not null,"]
#CMD ["`name` char(20) default null,"]
#CMD ["primary key(`id`)"]
#CMD [") engine=innodb default charset=utf8;"]

#https://qastack.kr/server/796762/creating-a-docker-mysql-container-with-a-prepared-database-scheme
