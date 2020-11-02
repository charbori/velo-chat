FROM redis:latest as builder
MAINTAINER charbori

ARG FILE=docker/redis/redis.conf

ADD ${FILE} /docker-entrypoint-initdb.d

CMD ["redis-server"]

#
#FROM openjdk:11
#
#LABEL maintainer="binstar13@gmail.com"
#
#VOLUME /tmp
#
#EXPOSE 8080
#
##상대경로 사용
#ARG JAR_FILE=build/libs/*.jar
#
##상대경로로 가져온 파일 실행
#ADD ${JAR_FILE} springboot-chat.jar
#
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-chat.jar"]

# 기본 빌드
# ./gradlew build && java -jar build/libs/helloworld-0.1.0.jar
# 도커파일 있는 위치에서 실행
# java -Djava.security.edg=file:/dev/./urandom -jar /to-do-springboot.jar

# 그냥 콘솔에서 해당 경로로 이동 후 "docker build -t app ."
# 실행하는 게 편하다.   (. 중요하다)