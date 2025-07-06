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
        stage('Docker Compose Up') {
            steps {
                dir("${WORKSPACE}") {
                    sh 'docker-compose up -d'
                }
            }
        }
        stage('Docker Compose Down') {
            steps {
                dir("${WORKSPACE}") {
                    sh 'docker-compose down'
                }
            }
        }
    }
}
