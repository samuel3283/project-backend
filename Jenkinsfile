#!groovy?
node {
deleteDir()
stage('Descargar Fuentes') {
checkout scm
}
stage('Compilando con maven')
{	
def mvnHome = tool 'jenkinsmvn';
sh "${mvnHome}/bin/mvn clean install"
}
stage('Desplegando') {
script{
sh "java -jar target/micrsoervice-backend-0.0.1-SNAPSHOT.jar --server.port=8085"
}
}
}
