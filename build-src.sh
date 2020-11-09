#!/bin/sh

# gradle jar 파일 생성
./gradlew build

APP_NAME=velo-chat

echo "Running Gradle build in continer..."

docker run \
    --rm \
    --workdir /home/gradle/project \
    gradle:6.6.1-jdk11 gradle clean build

echo "Build output:"

ls -l .
BUILD_OUTPUT=src/build_file_copy/libs/${APP_NAME}-0.0.1-snapshot.jar
ls -l $BUILD_OUTPUT

cp -r build/libs/ src/build_file_copy/

# docker build -t "mysql_spring_image:0.0.2_snapshot" . -f docker/mysql/Dockerfile
# docker build -t "redis_spring_image:0.0.2_snapshot" . -f docker/redis/Dockerfile

# docker run --name mysql-spring-image docker/mysql/:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -v volumes/mysql -d
# docker run --name redis-spring-image docker/redis/:/var/lib/redis -v volumes/redis -d


# ./build-src.sh

#echo 'param:' $0
pwd_val=$(dirname "$0")
pwd_val="${pwd_val}/docker/mysql/setup.sql"
#echo "${pwd_val}"

# docker-compose 실행
docker-compose up -d

docker exec -i spring_mysql mysql -uroot -p"root" mysql < pwd_val
