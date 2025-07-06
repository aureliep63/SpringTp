pipeline {
   agent {
      docker {
         image 'maven:3.9.6-eclipse-temurin-21'
         // IMPORTANT: Mount the Docker socket and binary from the host
         // This allows the Docker client inside the Jenkins agent to communicate with the host's Docker daemon
         args '-v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker'
      }
    }

  environment {
    // These environment variables are more relevant for the 'app' service in docker-compose.yml
    // You typically don't need them directly in the Jenkinsfile environment block for Maven build/test.
    // However, if you have other Jenkins steps that use them, you can keep them.
    SPRING_DATASOURCE_URL = "jdbc:mysql://mysql:3309/SpringTp"
    SPRING_DATASOURCE_USERNAME = "root"
    SPRING_DATASOURCE_PASSWORD = "" // Ensure this matches your no-password setup
  }

  stages {

    stage('Build') {
      steps {
        // Maven build is done by the Maven Docker agent
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Test') {
      steps {
        // Make sure you have JUnit tests for this stage
        sh 'mvn test'
      }
    }

    stage('Docker Build') {
      steps {
        // Build the Spring Boot application image
        sh 'docker build -t springtp-app .'
      }
    }

    stage('Docker Compose Up') {
      steps {
        // Start the services defined in docker-compose.yml
        // NOTE: docker-compose must be installed on the Jenkins host machine,
        // or you'd need to add it to your agent image and mount its binary too.
        // For simplicity, it's assumed docker-compose is on the host.
        sh 'docker-compose up -d'
      }
    }
  }
}