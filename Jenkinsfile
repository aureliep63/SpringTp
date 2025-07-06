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
    stage('Debug Compose') {
      steps {
        sh '''
          echo "Répertoire actuel : $(pwd)"
          echo "Contenu :"
          ls -la
        '''
      }
    }

    stage('Docker Compose Up') {
      steps {
        sh 'cd $WORKSPACE && docker-compose up -d'
      }
    }
  }
}