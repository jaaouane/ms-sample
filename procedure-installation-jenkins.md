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

*  configuration du job

	*  onglet GENERAL: dans la configuration du projet: ajouter un git parameter: GIT_BRANCH dans : This project is parameterized

	*  onglet pipeline: Branches to build:$GIT_BRANCH

	*  onglet pipeline: Pipeline: Additional Behaviours: ajouter checkout to specific local branch: sinon jenkins sera en DEATCHED HEAD, comme ca jenkins sera sur la branche séléctionné.

*  ajouter dans Ansible installations avec le nom ansible

*  se connecter dans le conatiner via docker exec -it jenkins_blueocean bash

	- ssh-keygen

        - ssh-copy-id -i ~/.ssh/id_rsa.pub thales@172.28.0.1 et saisir le mot de passe

# sonar

*  install sonar qube plugin

*  download sonar qube and run the server 

*  download sonar scanner 

*  configure tool configuration

*  replace use_embedded_jre=true by false in sonar-scanner.sh

*  see this https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach

*  => configure server in system configuration (take host ipnot localhost)





