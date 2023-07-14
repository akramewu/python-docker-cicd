#!/usr/bin/env groovy

@Library(['piper-lib', 'piper-lib-os']) _

pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_CREDENTIALS = credentials('internalsapartifactory')
    }

    stages {
        stage('Checkout') {
            steps {
                deleteDir()
                git branch: 'main', credentialsId: '308e2027-1806-4707-8315-370d442691f9', url: 'https://github.com/akramewu/python-docker-cicd.git'
                setupPipelineEnvironment script: this
            }
        }

        stage('Build') {
            steps {
                kanikoExecute(
                    script: this,
                    buildOptions: ['--destination=slvtestdemo.int.repositories.cloud.sap/imgFolder/testImg:v1'],
                    containerImageNameAndTag: 'slvtestdemo.int.repositories.cloud.sap/imgFolder/testImg:v1',
                    dockerConfigJsonCredentialsId: 'internalsapartifactory'
                )
                // sh 'docker build -t akramulislam/python-docker-cicd .'
            }
        }
    }
}