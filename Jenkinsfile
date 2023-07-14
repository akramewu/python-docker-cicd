pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_CREDENTIALS = credentials('internalsapartifactory')
    }    

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'
            }
        }

        stage('Build') {
            steps {
                kanikoExecute(
                    script:this,
                    buildOptions: ['--destination=slvtestdemo.int.repositories.cloud.sap/imgFolder/testImg:v1'],
                    containerImageNameAndTag: 'slvtestdemo.int.repositories.cloud.sap/imgFolder/testImg:v1',
                    dockerConfigJsonCredentialsId: 'internalsapartifactory'
                )
                //sh 'docker build -t akramulislam/python-docker-cicd .'
            }
        }
    
    /*
        stage('Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKER_REGISTRY_CREDENTIALS}", usernameVariable: 'DOCKERHUB_CREDENTIALS_US', passwordVariable: 'DOCKERHUB_CREDENTIALS_PSW')]) {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_US --password-stdin'
                }
            }
        }

        stage('Push') {
            steps {
                sh 'docker push akramulislam/python-docker-cicd'
            }
        }
        */
    }

    post {
        always {
            node(env.NODE_NAME) {
                // Your post-build code here
                sh 'docker logout'
            }
        }
    }

}
