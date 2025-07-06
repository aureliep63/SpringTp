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

        stage('Health Check API') {
            steps {
                // Change 8086 if your exposed app port is different
                sh '''
                    echo "Test d’accessibilité de l’API..."
                    sleep 10  # laisser un peu de temps à l’app pour démarrer
                    curl --fail http://localhost:8086 || (echo "API KO" && exit 1)
                '''
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
