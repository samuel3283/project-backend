#!groovy?
node {
deleteDir()
stage('Descargar Fuentes') {
checkout scm
}
stage('Compilando con maven')
{	
def mvnHome = tool 'jenkinsmvn';
sh "${mvnHome}/bin/mvn clean package"
}
stage('Construyendo Docker ') {
script{
//bat "docker stop container-repobackend"
//bat "docker rm -f container-repobackend"
//bat "docker image rm -f repobackend"
//bat "docker rmi repobackend"
sh "docker build -t projectbackend ."
}
}
stage('Iniciando Docker ') {
script{
sh "docker run -d --name container-projectbackend -p 8085:8080 projectbackend:latest"
}
}
}
