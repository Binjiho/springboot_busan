# !/bin/sh
echo ">> deploy Dir 이동"
cd /home/ec2-user/deploy/deploy

echo ">> 변수 설정"
DOCKERHUB_USERNAME = jiyu1948
DOCKERHUB_IMAGE = busan_moon
IS_RUN_BLUE = $(docker ps --format "{{.Names}}" --filter expose=8081/tcp)
echo ">> IS_RUN_BLUE : ${IS_RUN_BLUE}"

if [ -n "$IS_RUN_BLUE" ]
then
        PRE_CONTAINER_NAME= "blue"
        CONTAINER_NAME= "green"
        CONTAINER_PORT= 8082
else
        PRE_CONTAINER_NAME= "green"
        CONTAINER_NAME= "blue"
        CONTAINER_PORT= 8081
fi

echo ">> Run container"
docker run -d -i -p ${CONTAINER_PORT}:${CONTAINER_PORT} -e --name ${CONTAINER_NAME} ${DOCKERHUB_USERNAME}/${DOCKERHUB_IMAGE}:latest
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

echo ">> nginx conf fix AND nginx reload"
echo "set \$service_url http://127.0.0.1:${CONTAINER_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc
sudo service nginx reload

echo ">> Remove previous container"
#docker stop ${PRE_CONTAINER_NAME}
docker container prune -f

echo ">> Remove previous image"
docker image prune -a -f