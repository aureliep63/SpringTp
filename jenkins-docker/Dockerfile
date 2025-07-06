FROM jenkins/jenkins:lts

USER root

# Installer Docker CLI
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://download.docker.com/linux/static/stable/x86_64/docker-20.10.24.tgz | tar xz && \
    mv docker/docker /usr/local/bin/ && \
    rm -rf docker

# Installer Maven
RUN apt-get update && \
    apt-get install -y maven

# Ajouter l'utilisateur Jenkins au groupe docker
RUN groupadd -f docker && usermod -aG docker jenkins

USER jenkins
