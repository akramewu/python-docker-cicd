@Library(['piper-lib-os', 'piper-lib']) _
pipeline {
  agent any
	environment {
        DOCKER_REGISTRY_CREDENTIALS = credentials('internalsapartifactory')
    }
	stages{
		stage('prepare') {
			steps{
				checkout scm
				setupCommonPipelineEnvironment script:this
			}
		}
    stage('Docker Build') {
			steps{
                kanikoExecute(
                    script: this,
                    buildOptions: ['--destination=slvtestdemo.int.repositories.cloud.sap/imgFolder/testImg:v1'],
                    containerImageNameAndTag: 'slvtestdemo.int.repositories.cloud.sap/imgFolder/testImg:v1',
                    dockerConfigJsonCredentialsId: 'internalsapartifactory'
                )
			}
		}
	}
}