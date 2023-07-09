pipeline {
    agent any

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
    }
}
