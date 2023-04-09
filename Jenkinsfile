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

    stage('Package') {
      steps {
        echo 'Starting packaging...'
        sh 'mvn jar:jar'
        echo 'Packaging finished'
        echo 'Archive the artifacts'
        archiveArtifacts 'target/*.jar'
      }
    }

    stage('Deploy in Prod') {
      steps {
        echo 'Simulating deployment in prod'
      }
    }

  }
}