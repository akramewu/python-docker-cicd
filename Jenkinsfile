@Library(['piper-lib']) _

pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_CREDENTIALS = credentials('docker-registry-credentials')
    }

    stages {
        stage('Checkout') {
            steps {
                // Your code to checkout the source code repository goes here
                // For example: git branch: 'main', credentialsId: 'your-git-credentials', url: 'https://github.com/your/repository.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def dockerfilePath = './path/to/Dockerfile'
                    def imageName = 'your-docker-registry/your-image-name'
                    def imageTag = 'your-image-tag'
                    def dockerConfigJsonCredentialsId = 'docker-registry-credentials'

                    kanikoExecute(
                        script: this,
                        dockerfilePath: dockerfilePath,
                        buildArgs: '--build-arg KEY=VALUE', // Optional, if you have build arguments
                        buildOptions: ['--destination=' + imageName + ':' + imageTag],
                        containerImageNameAndTag: imageName + ':' + imageTag,
                        dockerConfigJsonCredentialsId: dockerConfigJsonCredentialsId
                    )
                }
            }
        }
    }
}
