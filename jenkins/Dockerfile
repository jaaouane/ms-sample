FROM jenkinsci/blueocean

USER root



RUN apk add py-pip \
&& pip install docker-compose

RUN pip install --upgrade pip


RUN /usr/local/bin/install-plugins.sh \
  pipeline-maven \
  git-parameter \
  maven-plugin \
  pipeline-utility-steps \
  ansible \
  sonar



# RUN apk update && \
# apk add --no-cache ansible && \
# rm -rf /tmp/* && \
# rm -rf /var/cache/apk/*
