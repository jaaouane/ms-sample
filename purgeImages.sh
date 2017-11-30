#!/bin/bash

if [[ $(docker ps -a| grep ms-sample | awk '{print $1}' | uniq) ]]; then
    docker ps -a| grep ms-sample | awk '{print $1}' | uniq | xargs docker rm -f
else
    echo "no containers to remove found"
fi

if [[ $(docker images| grep ms-sample | awk '{print $1}' | uniq) ]]; then
    docker images| grep ms-sample | awk '{print $1}' | uniq | xargs docker rmi -f
else
    echo "no images to remove found"
fi

exit 0
