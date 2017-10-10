def buildMvn(path) {
       sh "cd ./${path} && ${M2_HOME}/bin/mvn -Dmaven.test.skip=true clean install"
}


node { 
    
    echo 'Hello World' 
    
    stage ('Checkout scm') {
        checkout scm
    }
    
    stage ('Initialize') {
              
        echo "PATH = ${PATH}"
        echo "JAVA_HOME = ${JAVA_HOME}"
        echo "M2_HOME = ${M2_HOME}"
          
        buildMvn('micro-serices-sample-parent')
        buildMvn('registry')
    }
}


