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
        		sh './mvnw clean install'
        	}
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build or Deploy failed!'
        }
    }
}