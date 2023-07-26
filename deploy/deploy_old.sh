# Build N Run DB Container
docker_username=""
db_image_name=""
db_container_name=""
db_password=""
version=""
port=8085 # Default Port: 8085

echo "## Automation docker-database build and run ##"

# remove container
echo "=> Remove previous container..."
docker rm -f ${db_container_name}

# remove image
echo "=> Remove previous image..."
docker rmi -f ${docker_username}/${db_image_name}:${version}

# new-build/re-build docker image
echo "=> Build new image..."
docker build --tag ${docker_username}/${db_image_name}:${version} .

# Run container
echo "=> Run container..."
docker run -d -p ${port}:${port} -e --name ${db_container_name} ${docker_username}/${db_image_name}:${version}
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
