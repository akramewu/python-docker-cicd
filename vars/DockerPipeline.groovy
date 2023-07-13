def call(String imageName, String tag) {
    pipeline {
        agent any
        
        stages {
            stage('Checkout') {
                steps {
                    git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'

                }
            }
            
            stage('Docker Build') {
                steps {
                    script {
                        def dockerImage = docker.build("${imageName}:${tag}")
                        dockerImage.push()
                    }
                }
            }
            
            // Additional stages...
        }
    }
}
