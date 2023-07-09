pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_CREDENTIALS = credentials('dockerhub-credentials')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'
            }
        }

        stage('Build') {
            steps {

                withCredentials([usernamePassword(credentialsId: "${DOCKER_REGISTRY_CREDENTIALS}", usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh '''
                        docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}
                        sh 'docker build -t akramulislam/python-docker-cicd .'
                    '''
                
            }
        }
    }
 }
}
