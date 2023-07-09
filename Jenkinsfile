pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_CREDENTIALS = credentials('akramulislam-dockerhub')
    }    

    stages {
        stage('Install Docker') {
            steps {
                sh 'curl -fsSL https://get.docker.com -o get-docker.sh'
                sh 'sh get-docker.sh'
                sh 'usermod -aG docker jenkins'
                sh 'service docker restart'
                sh 'docker version'
            }
        }
        
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'
            }
        }

    post {
        always {
            sh 'docker logout'
        }
    }
 }
}