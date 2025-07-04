pipeline {
    agent any

    environment {
        BROWSERSTACK_USERNAME = credentials('browserstack-username')
        BROWSERSTACK_ACCESS_KEY = credentials('browserstack-accesskey')
        BROWSERSTACK_ANDROID_APP_URL = credentials('browserstack-android-app-url')
        BROWSERSTACK_IOS_APP_URL = credentials('browserstack-ios-app-url')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Android Tests') {
            steps {
                sh 'mvn test -DsuiteXmlFile=testng.xml -Dplatform=android'
            }
        }
        stage('Run iOS Tests') {
            steps {
                sh 'mvn test -DsuiteXmlFile=testng.xml -Dplatform=ios'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/cucumber-html-report/**', allowEmptyArchive: true
            junit 'target/surefire-reports/**/*.xml'
        }
    }
}
