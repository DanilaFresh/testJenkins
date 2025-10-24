pipeline {
    agent {label 'java-21-agent'}

     environment {
            NEXUS_VERSION="nexus3"
            NEXUS_PROTOCOL="http"
            NEXUS_URL="nexus:8081/repository/demo-rep/"
            NEXUS_REPOSITORY="demo-rep"
            NEXUS_CREDENTIAL_ID="nexus-creds"
            LOCAL_JAR_FILE_LOCATION="target/"
        }

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
    stage('Publish') {
       steps {
         script {
            String version = getArtifactVersion()
            String groupId = getGroupId()
            String artifactName = getArtifactName()
            nexusArtifactUploader(
                nexusVersion: NEXUS_VERSION,
                protocol: NEXUS_PROTOCOL,
                nexusUrl: NEXUS_URL,
                groupId: groupId,
                version: version,
                repository: NEXUS_REPOSITORY,
                credentialsId: NEXUS_CREDENTIAL_ID,
                artifacts: [
                    [artifactId: artifactName,
                     classifier: '',
                     file: LOCAL_JAR_FILE_LOCATION + artifactName + "-" + version + ".jar",
                     type: 'jar']
                ]
             )
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

    def getArtifactName() {
        return sh(script: './mvnw help:evaluate -Dexpression=project.artifactId -q -DforceStdout', returnStdout: true).trim()
    }
    def getGroupId() {
        return sh(script: './mvnw help:evaluate -Dexpression=project.groupId -q -DforceStdout', returnStdout: true).trim()
    }
    def getArtifactVersion() {
        return sh(script: './mvnw help:evaluate -Dexpression=project.version -q -DforceStdout', returnStdout: true).trim()
    }