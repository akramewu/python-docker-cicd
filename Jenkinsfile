pipeline {
    agent {
        kubernetes {
            defaultContainer 'jdk'
            yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: jdk
    image: openjdk:8
    command:
    - cat
    tty: true
'''
        }
    }
    stages {
        stage('Build & Check') {
            steps {
                sh 'java -version'
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'
            }
        }
    }
}
