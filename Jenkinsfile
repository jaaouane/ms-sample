@Library('my-shared-library') _


node { 
    
    echo 'Hello World' 
    
    stage ('Checkout scm') {
        checkout scm

	// lecture du pom
	pom = readMavenPom file: "micro-serices-sample-parent/pom.xml"
	versionApp = pom.version
	echo "VERSION=${versionApp}"

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
    

    stage ('Tests Unitaires Backend') {                         
       junitTest{                                                          
           path = ['config-server','registry','shop-ms','products-ms']                                     
           ignoreFailure = true                                     
       }                                            
    }

    stage ('purge docker imags') {  
        echo "purge docker imags";
	sh "./purgeImages.sh";
    }
    
    stage ('build docker') { 
        dockerBuild {
	     projectName = 'ms-sample'
	     path = ['config-server','registry','shop-ms','products-ms']
             imgVersion = imgVersion
	}
    }

    /*
    stage ('update compose') {  
       updateCompose {
	     projectName = 'ms-sample'
	     path = ['config-server','registry','shop-ms','products-ms']
             imgVersion = imgVersion
	}

       sh "git config user.email 'jenkins@ajconsulting.com' "
       sh "git config user.name 'jenkins' "
       sh "git commit -am 'update compose version to ${imgVersion}' ";
       sh "git push origin HEAD:master";
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
     }
    */
}


