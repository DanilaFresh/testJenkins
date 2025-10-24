pipeline {
    agent {label 'java-21-agent'}

    stages {

        stage('Checkout') {
        	steps{
        		checkout([
              $class: 'GitSCM',
              branches: [[
        	      name: '*/master'
              ]],
              doGenerateSubmoduleConfigurations: false,
              extensions: [],
              submoduleCfg: [],
        			userRemoteConfigs: [[
        				credentialsId: 'test',
        				url: 'git@github.com:DanilaFresh/testJenkins.git'
        			]]
        		])
        	}
        }

        stage('Build') {
        	steps {
        		sh "ls"
        		sh "java -version"
        		sh 'chmod +x mvnw'  // Делаем исполняемым
        		sh './mvnw clean install'
        	}
        }

        stage('Test') {
                	steps {
                		sh "./mvnw clean test"
                	}
                }
    }

    post {
        success {
            echo 'Build and Test succeeded!'
        }
        failure {
            echo 'Build or Deploy or Test failed!'
        }
    }
}