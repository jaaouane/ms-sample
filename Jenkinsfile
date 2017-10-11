def pipeline


node { 
    
    echo 'Hello World' 
    
    stage ('Checkout scm') {
        checkout scm
	pipeline = load 'pipeline.groovy'
    }
    
    stage ('Initialize') {
              
        echo "PATH = ${PATH}"
        echo "JAVA_HOME = ${JAVA_HOME}"
        echo "M2_HOME = ${M2_HOME}"
          
        pipeline.buildMvn('micro-serices-sample-parent')
        pipeline.buildMvn('registry')
    }
}


