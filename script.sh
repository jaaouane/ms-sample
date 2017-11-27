docker rm -f $(docker ps -a -q)

docker rmi ms-sample/config-server

docker rmi ms-sample/registry

docker rmi ms-sample/products-ms

docker rmi ms-sample/shop-ms


docker build -t ms-sample/config-server  ./

docker build -t ms-sample/registry  ./

docker build -t ms-sample/products-ms  ./

docker build -t ms-sample/shop-ms  ./



docker exec -it ms-sample-config-server /bin/bash

docker exec -it ms-sample-registry /bin/bash


