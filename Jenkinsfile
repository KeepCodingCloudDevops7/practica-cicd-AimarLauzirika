pipeline {
  agent any
  stages {
    stage('Clean') {
      agent any
      steps {
        echo 'Cleaning...'
        sh 'make clean'
        echo 'Cleaning finished.'
      }
    }

  }
}