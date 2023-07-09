pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'
            }
        }

        stage('Build') {
            environment {
                DOCKER_USERNAME = credentials('akramulislam-dockerhub-usr')
                DOCKER_PASSWORD = credentials('akramulislam-dockerhub-psw')
            }
            steps {
                withCredentials([usernamePassword(credentialsId: DOCKER_USERNAME, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh '''
                        docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
                        docker build -t akramulislam/python-docker-cicd .
                    '''
                }
            }
        }

        stage('Push') {
            steps {
                sh 'docker push akramulislam/python-docker-cicd'
            }
        }
    }
}
