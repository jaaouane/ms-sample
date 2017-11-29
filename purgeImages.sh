#!/bin/bash

if [[ $(docker ps| grep ms-sample | awk '{print $1}' | uniq) ]]; then
    docker ps| grep ms-sample | awk '{print $1}' | uniq | xargs -L1 docker rm -f
else
    echo "no containers to remove found"
fi

if [[ $(docker images| grep ms-sample | awk '{print $1}' | uniq) ]]; then
    docker images| grep ms-sample | awk '{print $1}' | uniq | xargs -L1 docker rmi -f
else
    echo "no images to remove found"
fi

exit 0
