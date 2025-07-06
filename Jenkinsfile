pipeline {
   agent {
      docker {
         image 'maven:3.9.6-eclipse-temurin-17'
         // Ajoute le montage du socket Docker de l'hôte
         args '-v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker' // Assurez-vous que le binaire docker est aussi disponible
      }
    }

  environment {
    // Les variables d'environnement pour l'application Spring Boot sont mieux gérées dans le docker-compose.yml
    // et transmises au conteneur 'app' par docker-compose.
    // Vous n'avez pas besoin de les définir ici pour le build Maven.
    // Cependant, si vous voulez les utiliser pour d'autres étapes Jenkins non liées à Docker Compose, vous pouvez les garder.
    SPRING_DATASOURCE_URL = "jdbc:mysql://mysql:3309/SpringTp"
    SPRING_DATASOURCE_USERNAME = "root"
    SPRING_DATASOURCE_PASSWORD = "root"
  }

  stages {

    stage('Build') {
      steps {
        // Le build Maven est fait par l'agent Docker Maven
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Test') {
      steps {
        // Assurez-vous d'avoir des tests JUnit pour cette étape
        sh 'mvn test'
      }
    }

    stage('Docker Build') {
      steps {
        // Construit l'image de l'application Spring Boot
        sh 'docker build -t springtp-app .'
      }
    }

    stage('Docker Compose Up') {
      steps {
        // Lance les services définis dans docker-compose.yml
        // Assurez-vous d'avoir Docker Compose installé sur la machine hôte,
        // ou ajoutez-le à l'image de l'agent si vous voulez qu'il soit exécuté depuis le conteneur.
        // Si vous utilisez un agent Docker pour Jenkins, il faut aussi monter le binaire docker-compose.
        sh 'docker-compose up -d'
      }
    }
  }
}