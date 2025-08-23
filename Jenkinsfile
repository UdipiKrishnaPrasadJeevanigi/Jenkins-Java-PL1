pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps{
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Post Build Notification') {
                    steps {
                        script {
                            if (currentBuild.currentResult == 'SUCCESS') {
                                emailext(
                                    subject: "SUCCESS: Jenkins Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
                                    body: """
                                        The Jenkins job '${env.JOB_NAME}' has completed successfully.

                                        Build Number: ${env.BUILD_NUMBER}
                                        Status: SUCCESS
                                        Build URL: ${env.BUILD_URL}
                                    """,
                                    to: 'udipikrishnaprasad@gmail.com'
                                )
                            } else if (currentBuild.currentResult == 'FAILURE') {
                                emailext(
                                    subject: "FAILURE: Jenkins Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
                                    body: """
                                        The Jenkins job '${env.JOB_NAME}' has FAILED.

                                        Build Number: ${env.BUILD_NUMBER}
                                        Status: FAILURE
                                        Check logs here: ${env.BUILD_URL}
                                    """,
                                    to: 'udipikrishnaprasad@gmail.com'
                                )
                            }
                        }
                    }
        }
    }
}
