pipeline {
  environment {
    registry = "luluhalsalamah/docker-test"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent {
        docker {
                image 'maven'
                args '--privileged -v $HOME/.m2:/home/jenkins/.m2 -ti -u 496 -e MAVEN_CONFIG=/home/jenkins/.m2 -e MAVEN_OPTS=-Xmx2048m'
            }
  }
  
  stages {
    stage('Cloning Git') {
      steps {
        echo 'one'
        git 'https://github.com/LuluhAdel/coding_dojo.git'
      }
    }
    stage('Building image') {
      steps{
        script {
           echo 'two'
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }

    stage('Test Mkdocs' ) {
                agent {
                docker { image 'luluhalsalamah/docker-test:$BUILD_NUMBER' }
            }
            steps {
               echo 'three'
                sh 'mkdocs --version'
            }
        }


    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
  }
}
