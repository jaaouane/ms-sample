@Library('my-shared-library') _

def imgVersion = 'latest'

node { 
    
    echo 'Hello World' 
    
    stage ('Checkout scm') {
        def result = checkout scm
        
        // Additional Behaviours Check out to specific local branch
        // disable lightweight checkout to work this
	echo "branche = ${result['GIT_BRANCH']}"

	// lecture du pom
	pom = readMavenPom file: "micro-serices-sample-parent/pom.xml"
        def versionApp = pom.version
	echo "VERSION=${versionApp}"

        indexOf= versionApp.indexOf('.RELEASE')
        imgVersion = versionApp.substring(0,indexOf)
	echo "imgVersion=${imgVersion}"
    }
    
    
    stage ('build') {
              
        echo "PATH = ${PATH}"
        echo "JAVA_HOME = ${JAVA_HOME}"
        echo "M2_HOME = ${M2_HOME}"
        
	buildModule{
	     // path = ['micro-serices-sample-parent','registry']
             // buildProfile = 'prod'
	}

    }
    
    /*
    stage ('Tests Unitaires Backend') {                         
       junitTest{                                                          
           path = ['config-server','registry','shop-ms','products-ms']                                     
           ignoreFailure = true                                     
       }                                            
    }
     */

    stage ('purge docker imags') {  
        echo "purge docker imags";
	sh "./purgeImages.sh";
    }
    
    stage ('build docker') { 
	// lecture du pom
        /*
        dockerBuild {
	     projectName = 'ms-sample'
	     path = ['config-server','registry','shop-ms','products-ms']
	     imgVersion = 'latest'
	}
        */
        echo "imgVersion=${imgVersion}"
	dockerBuild2('ms-sample',['config-server','registry','shop-ms','products-ms'], imgVersion)
    }

   
    stage ('update compose') {  
       updateCompose {
	     projectName = 'ms-sample'
	     path = ['config-server','registry','shop-ms','products-ms']
             imgVersion = imgVersion
	}

       sh "git config user.email 'jenkins@ajconsulting.com' "
       sh "git config user.name 'jenkins' "
       
       def change = sh returnStdout: true, script: 'git status --short | wc -l'
       echo "change= ${change}" 
       
       if (change.toInteger() >0) {
           echo "commiter docker compose" 
           sh "git commit -am 'update compose version to ${imgVersion}' ";
       	   sh "git push origin HEAD:master";
           
          //withCredentials ne marche pas c pourquioi c'est commité
          // pour contourner le probléme , j'ai fait docker exec sur le conteneur jenkins pour se connecter au conteneur et j'ai lancé la commande git config credential.helper store
          // le login et mot de passe sont enregistrés dans le conteneur, ils seront plus demandés 
          /*
           withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'git-credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {

		    sh("git push https://${env.GIT_USERNAME}:${env.GIT_PASSWORD}@https://github.com/jaaouane/ms-sample.git --all")
	   }
          

	   withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'git-credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) { 
                  
                    sh('URL=`git config --get remote.origin.url | sed \"s;://;://${GIT_USERNAME}:${GIT_PASSWORD}@;g\"` && git push --set-upstream ${URL} --all' )    
           }
           */
          
       }
    }

   
    stage ('docker compose') {  
       sh "docker-compose up -d";
    }
     

    stage('SonarQube analysis') {
	 // requires SonarQube Scanner 2.8+
	 def scannerHome = tool 'sonar';
	 withSonarQubeEnv('My SonarQube Server') {
	    sh "${scannerHome}/bin/sonar-scanner"
	 }

	sh "rm -rf .scannerwork/"
    }
    /* */
}




def dockerBuild2(projectName, pathList, imgVersion){
	echo "dockerBuild2"
	echo "imgVersion=${imgVersion}"

	for(int i = 0; i < pathList.size(); i++){
		def targetPath = pathList[i]
                docker.build("${projectName}/${targetPath}:${imgVersion}","./${targetPath}")
        }
}
