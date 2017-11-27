# ms-sample en locale

* demarrer config-server

* demarrer registry

* demarrer products-ms et appeler http://localhost:8080/products

* demarrer shop-ms et appeler: http://localhost:8081/references


# docker

     * Lancer les commandes suivantes sur la machine hote :

	 1) groupadd -g 2005 -r ms-sample && useradd -u 2005 -g ms-sample -c 'ms-sample' ms-sample

         2) sudo mkdir -p  /applis/ms-sample/logs/config-server && sudo chown ms-sample:ms-sample -R /applis/ms-sample/logs/config-server

	 3) sudo mkdir -p  /applis/ms-sample/logs/registry && sudo chown ms-sample:ms-sample -R /applis/ms-sample/logs/registry

	 4) sudo mkdir -p  /applis/ms-sample/logs/products-ms &&  sudo chown ms-sample:ms-sample -R /applis/ms-sample/logs/products-ms




























# jenkins pipeline


	*  configure git

	*  configure library in configure system


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


