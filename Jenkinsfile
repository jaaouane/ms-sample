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

        echo "imgVersion = ${imgVersion}"
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
        echo "purge docker imags"
	// sh "docker ps| grep ms-sample | awk '{print $1}' | uniq | xargs -L1 docker rm -f"
   
        // sh "docker images| grep ms-sample | awk '{print $1}' | uniq | xargs -L1 docker rmi -f"
    }
    
    stage ('build docker') {  
        dockerBuild {
	     projectName = 'ms-sample'
	     path = ['config-server','registry','shop-ms','products-ms']
             //imgVersion = imgVersion
	}
    }
     

     /*
     stage('SonarQube analysis') {
	 // requires SonarQube Scanner 2.8+
	 def scannerHome = tool 'sonar';
	 withSonarQubeEnv('My SonarQube Server') {
	    sh "${scannerHome}/bin/sonar-scanner"
	 }
     }
    */
}


