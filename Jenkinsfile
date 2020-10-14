pipeline {
  environment {
    registry = "luluhalsalamah/docker-test"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
 agent {
        docker {
            image 'ubuntu'
            args '-u root:sudo -v /var/jenkins_home/workspace/docker-test '
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
