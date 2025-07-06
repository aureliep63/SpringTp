FROM jenkins/jenkins:lts

USER root

# Installer Docker CLI
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://download.docker.com/linux/static/stable/x86_64/docker-20.10.24.tgz | tar xz && \
    mv docker/docker /usr/local/bin/ && \
    rm -rf docker

# Installer Docker Compose (v2 style, compatible avec Docker CLI)
RUN curl -SL https://github.com/docker/compose/releases/download/v2.38.1/docker-compose-linux-x86_64 -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose

# Installer Maven
RUN apt-get update && apt-get install -y maven

# Ajouter Jenkins au groupe docker
RUN groupadd -f docker && usermod -aG docker jenkins

USER jenkins
