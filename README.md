# ms-sample en locale

* demarrer config-server

* demarrer registry

* demarrer products-ms et appeler http://localhost:8080/products

* demarrer shop-ms et appeler: http://localhost:8081/references


# Préparer les images docker
  
     * se connecter sur http://localhost:9080 et lancer un build, le build va creer tous mes images docker de tous les ms.

# préparation de la VM

     * Manuellement: Lancer les commandes suivantes sur la machine hote :

	 1) groupadd -g 2005 -r ms-sample && useradd -u 2005 -g ms-sample -c 'ms-sample' ms-sample

         2) sudo mkdir -p  /applis/ms-sample/logs/config-server && sudo chown ms-sample:ms-sample -R /applis/ms-sample/logs/config-server

	 3) sudo mkdir -p  /applis/ms-sample/logs/registry && sudo chown ms-sample:ms-sample -R /applis/ms-sample/logs/registry

	 4) sudo mkdir -p  /applis/ms-sample/logs/products-ms &&  sudo chown ms-sample:ms-sample -R /applis/ms-sample/logs/products-ms

 	 5) sudo mkdir -p  /applis/ms-sample/logs/shop-ms &&  sudo chown ms-sample:ms-sample -R /applis/ms-sample/logs/shop-ms

#        6) creer un lien symbolique  ln -s /home/thales/dev/ms-sample/livraison/environment/dev /home/thales/dev/ms-sample/livraison/env

         * systemctl is-enabled ms-sample.service && systemctl stop ms-sample.service ; systemctl daemon-reload && systemctl enable ms-sample.service && systemctl restart ms-sample.service
         * journalctl -u ms-sample.service: pour voir les logs du service

OU

     * Ansible va faire automatiquement les taches listes ci-dessus: voire repertoire livraison/installation


# Tester l'appliction

      * lancer docker-compose up depuis le répértoire jenkins
   
      * se connecter sur http://localhost:9080 et lancer un build, le build lancera tous les services via docker-compose

      * pour tester le serveur de configuration, tapez http://localhost:8888/registry/default : il va afficher la config du micro-service registry
      
      * http://localhost:8761/ est l'URL d'EUREKA
    
      * http://localhost:8080/products  est l'URL du micro-service products
  
      * http://localhost:8081/references  est l'URL du micro-service references












