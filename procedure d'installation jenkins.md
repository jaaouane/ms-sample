# jenkins pipeline


	*  configure git

	*  configure library in configure system

        *  installer Git Parameter Plugin


*  maven

	*  add Pipeline Maven Integration Plugin

	*  configure maven in tool configuration



# sonar

	*  install sonar qube plugin

	*  download sonar qube and run the server 

	*  download sonar scanner 

	*  configure tool configuration

	*  replace use_embedded_jre=true by false in sonar-scanner.sh


*  see this https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach

*  => configure server in system configuration (take host ipnot localhost)




*  install Pipeline Utility Steps plugin to have readMavenPom in pipeline


# docker-compose

* se connecter au container via docker exec -u root -ti jenkins_blueocean bash  et installer manuellement docker-compose(voir lien)

*  https://wiki.alpinelinux.org/wiki/Docker#Docker_Compose



