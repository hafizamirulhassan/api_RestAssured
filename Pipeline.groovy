pipeline {
    agent any

    stages {
        stage('Git Source Code') {
            steps {
                git branch: 'main', credentialsId: '694af5ce-66ad-4622-9749-21514b01a6c4', url: 'https://github.com/hafizamirulhassan/api_RestAssured.git'
                echo 'Git cloned successfully.'
            }
        }
        stage('Build Code'){
            steps{
                bat script: 'mvn compile'
            }
        }
        stage('Run Test'){
            steps{
                bat script: 'mvn clean test'
            }
        }
        stage('Publish Report'){
            steps{
                testNG()
            }
        }
    }
}
