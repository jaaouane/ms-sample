// Pipeline qui va deployer une version sur la DEV

@Library('my-shared-library') _

def imageVersion = 'latest'

// ## PARAMETRAGE JENKINS
def env = params.ENVIRONNEMENT

def isDev = params.IS_DEV

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
	echo "env=${env}"

        indexOf= versionApp.indexOf('-SNAPSHOT')
        imageVersion = versionApp.substring(0,indexOf)
	echo "imageVersion=${imageVersion}"
     
        if(isDev){
          echo "dev"
        }
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
	     imgVersion = 'latest'
	}
    }

    /* 
    stage ('update compose') {  

       updateCompose {
	     projectName = 'ms-sample'
	     path = ['config-server','registry','shop-ms','products-ms']
             imgVersion = imageVersion
	}

       
       def change = sh returnStdout: true, script: 'git status --short | wc -l'
       echo "change= ${change}" 
       
       if (change.toInteger() >0) {

           def message = "update compose version to ${imageVersion}"
           gitCommit {
	     commitMessage = message
	   }
       	   
           gitPush {
	     gitCredentialsId = 'git-credentials'
	   }
          
       }
    }


     
    stage ('docker push') {  

       dockerLogin {
	     credentialsId = 'docker-registry-credentials'
	}

        dockerPush {
	     dockerHubId = ajConsultingDockerHubId
             projectName = 'ms-sample'
	     path = ['config-server','registry']
             tag = 'latest'
	}

    }


    stage ('deploy') {
        def inventory = "livraison/installation/inventory/${env}"
        deploy {
	     inventoryFile = inventory
             playbookFile = 'livraison/installation/site.yml'
	     extraVars = [  version: '01.00.00',  env:env ]
	}

    }

   
    
    demarrer sonarQube sur la machine
    stage('SonarQube analysis') {
	 // requires SonarQube Scanner 2.8+
	 def scannerHome = tool 'sonar';
	 withSonarQubeEnv('My SonarQube Server') {
	    sh "${scannerHome}/bin/sonar-scanner"
	 }

	sh "rm -rf .scannerwork/"
    }
    */
}

	
