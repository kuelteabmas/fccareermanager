pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'gradle build'
            }
        }
        stage('Publish to Docker Hub') {
            steps {
                // Set up credentials for Docker Hub
                withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}'
                    sh 'docker tag ${projectName}:${version} ${DOCKER_USERNAME}/${projectName}:${version}'
                }
            }
        }
    }
}