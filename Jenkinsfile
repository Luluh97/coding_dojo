pipeline {
  environment {
    registry = "luluhalsalamah/docker-test"
    registryCredential = 'dockerhub'
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/LuluhAdel/coding_dojo.git'
      }
}
    stage('Building image') {
      steps{
        script {
          docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
  }
}
