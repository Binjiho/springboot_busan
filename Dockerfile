FROM openjdk:11
#상대경로
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ./app.jar
#ENTRYPOINT : 이미지가 컨테이너화 되며 실행될 명령을 입력한다
ENTRYPOINT ["java","-jar","/app.jar"]