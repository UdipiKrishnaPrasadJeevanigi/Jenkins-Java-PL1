pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git checkout: 'main', 'https://github.com/UdipiKrishnaPrasadJeevanigi/Jenkins-Java-PL1.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Run Application') {
            // write your logic here
        }
        stage('Test') {
            steps{
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
