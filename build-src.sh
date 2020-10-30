#!/bin/sh

# gradle jar 파일 생성
./gradlew build

APP_NAME=velo-chat

echo "Running Gradle build in continer..."

docker run \
    --rm \
    --workdir /home/gradle/project \
    gradle:6.6.1-jdk11 gradle clean build

echo
echo "Build output:"

ls -l .
BUILD_OUTPUT=src/build_file_copy/libs/${APP_NAME}-0.0.1-snapshot.jar
ls -l $BUILD_OUTPUT

cp -r build/libs/ src/build_file_copy/

# ./build-src.sh

# docker-compose 실행
docker-compose up -d