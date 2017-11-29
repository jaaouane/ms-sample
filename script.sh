docker rm -f $(docker ps -a -q)

docker rmi ms-sample/config-server

docker rmi ms-sample/registry

docker rmi ms-sample/products-ms

docker rmi ms-sample/shop-ms

docker rm -f ms-sample-config-server

docker rm -f ms-sample-registry

docker rm -f ms-sample-products-ms

docker rm -f ms-sample-shop-ms



docker exec -it ms-sample-config-server /bin/bash

docker exec -it ms-sample-registry /bin/bash

docker exec -it ms-sample-products-ms /bin/bash

docker exec -it ms-sample-shop-ms /bin/bash


