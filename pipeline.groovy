def buildMvn(path) {
       sh "cd ./${path} && ${M2_HOME}/bin/mvn -Dmaven.test.skip=true clean install"
}
