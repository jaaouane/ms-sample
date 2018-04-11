# construire l'image jenkins

- se placer dans repertoire jenkins

- docker build -t coreal/jenkins .

- docker-compose up

- l'installation d'Ansible a echoué dans le dockerFile: on l'installe manuellement dans l'image

- docker exec -it jenkins_blueocean bash

- apk update && apk add --no-cache ansible && rm -rf /tmp/* && rm -rf /var/cache/apk/*


# configuration de jenkins 


*  ajouter credentials de mon compte github a travers Credentials

*  configure library in Manage Jenkins -> configure system -> Global Pipeline Libraries avec le nom my-shared-library

*  Global Tool Configuration: ajouter Maven installation avec le nom maven3 

*  dans la configuration du projet: ajouter un git parameter: GIT_BRANCH dans : This project is parameterized


# sonar

	*  install sonar qube plugin

	*  download sonar qube and run the server 

	*  download sonar scanner 

	*  configure tool configuration

	*  replace use_embedded_jre=true by false in sonar-scanner.sh


*  see this https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach

*  => configure server in system configuration (take host ipnot localhost)



# docker-compose

* se connecter au container via docker exec -u root -ti jenkins_blueocean bash  et installer manuellement docker-compose(voir lien)

*  https://wiki.alpinelinux.org/wiki/Docker#Docker_Compose



