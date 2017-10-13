@Library('my-shared-library') _


node { 
    
    echo 'Hello World' 
    
    stage ('Checkout scm') {
        checkout scm
    }
    
    stage ('build') {
              
        echo "PATH = ${PATH}"
        echo "JAVA_HOME = ${JAVA_HOME}"
        echo "M2_HOME = ${M2_HOME}"
        // echo "${BAR}"
        
	    buildModule{
		path = ['micro-serices-sample-parent','registry']
		buildProfile = 'prod'
	    }
    }
    
    /*
    stage ('Tests Unitaires Backend') {                         
       junitTest{                                                          
           path = ['registry']                                     
           ignoreFailure = true                                     
       }                                            
    }
    */

     stage ('build docker') {  
         docker.build("ms-app:1.0")
     }
}


