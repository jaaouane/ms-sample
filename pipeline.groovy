def buildMvn(path) {
    
       withMaven(maven: 'maven3') {
            sh "cd ./${path} && mvn -Dmaven.test.skip=true clean install"
        }
}

return this;
