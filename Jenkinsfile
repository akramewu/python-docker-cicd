pipeline {
    agent any

    environment {
        DOCKERHUB_USERNAME = credentials('dockerhub-credentials').username
        DOCKERHUB_PASSWORD = credentials('dockerhub-credentials').password
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/akramewu/python-docker-cicd.git'
            }
        }

        stage('Build') {
            steps {
                sh 'docker build -t akramulislam/python-docker-cicd .'
            }
        }

        stage('Push') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-credentials', variable: 'DOCKERHUB_PASSWORD')]) {
                    sh 'docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD'
                    sh 'docker push akramulislam/python-docker-cicd'
                }
            }
        }
    }
}
