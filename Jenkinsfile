pipeline {
  agent any
  stages {
    stage('Clean') {
      agent any
      steps {
        echo 'Start cleaning...'
        sh 'mvn clean'
        echo 'Finished cleaning.'
      }
    }

    stage('Build') {
      agent {
        node {
          label 'jdk11'
        }

      }
      steps {
        echo 'Building...'
        sh 'mvn compile'
        echo 'Finished building.'
      }
    }

    stage('Test') {
      agent {
        node {
          label 'jdk17'
        }

      }
      steps {
        echo 'Testing...'
        sh 'mvn test'
        echo 'Test finished.'
      }
    }

  }
}