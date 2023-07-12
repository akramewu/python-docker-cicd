pipeline {
    agent {
        kubernetes {
            defaultContainer 'docker'
        }
    }
    stages {
        stage('Build & Check Docker Version') {
            steps {
                sh 'docker -version'
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'
            }
        }

        stage('Build') {
            steps {
                sh 'docker build -t akramulislam/python-docker-cicd .'
            }
        }

    }
}
