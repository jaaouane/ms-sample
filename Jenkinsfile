@Library('my-shared-library') _


node { 
    
    echo 'Hello World' 
    
    stage ('Checkout scm') {
        //checkout scm 
        //elle marche mais l'etat dans jenkins est dans DETACHED_HEAD, jenkins n'est pas dans le master

	git credentialsId: 'git-credentials', url: 'https://github.com/jaaouane/ms-sample', branch: 'master'


	// lecture du pom
	pom = readMavenPom file: "micro-serices-sample-parent/pom.xml"
        def versionApp = pom.version
	echo "VERSION=${versionApp}"
	//echo "branch-name=${BRANCH}" : marche pas
	//echo "git-name=${env.GIT_USERNAME}" : marche pas


        indexOf= versionApp.indexOf('.RELEASE')

        imgVersion = versionApp.substring(0,indexOf)
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

	def imgVersion = "01.00.02"
	echo "imgVersion before call= ${imgVersion}" 

        dockerBuild {
	     projectName = 'ms-sample'
	     path = ['config-server','registry','shop-ms','products-ms']
             imgVersion = "${imgVersion}"
	}
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
       	   //sh "git push origin HEAD:master";
          
           withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'git-credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {

		    sh("git push https://${env.GIT_USERNAME}:${env.GIT_PASSWORD}@https://github.com/jaaouane/ms-sample.git")
	   }
          
       }
    }

    /*
    stage ('docker compose') {  
       sh "docker-compose up -d";
    }
     

     
     stage('SonarQube analysis') {
	 // requires SonarQube Scanner 2.8+
	 def scannerHome = tool 'sonar';
	 withSonarQubeEnv('My SonarQube Server') {
	    sh "${scannerHome}/bin/sonar-scanner"
	 }
     }
    */
}


