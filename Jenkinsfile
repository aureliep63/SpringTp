pipeline {
   agent any

  environment {
    SPRING_DATASOURCE_URL = "jdbc:mysql://mysql:3306/SpringTp"
    SPRING_DATASOURCE_USERNAME = "root"
    SPRING_DATASOURCE_PASSWORD = ""
  }

  stages {

    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Docker Build') {
      steps {
        sh 'docker build -t springtp-app .'
      }
    }

    stage('Docker Compose Up') {
      steps {
        sh 'docker-compose up -d'
      }
    }
  }
}