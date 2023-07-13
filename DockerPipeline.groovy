def call(String imageTag) {
    pipeline {
        agent any

        stages {
            stage('Docker Build') {
                steps {
                    script {
                        // Docker build step
                        docker.build(imageTag)
                    }
                }
            }

            // Additional stages...
        }
    }
}
