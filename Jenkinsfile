@Library('ceiba-jenkins-library') _
pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  tools {
    jdk 'JDK14_Centos' //Verisión preinstalada en la Configuración del Master
  }
  //Opciones específicas de Pipeline dentro del Pipeline
  options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
     disableConcurrentBuilds()
  }

  environment {
        PROJECT_PATH_BACK = './microservicio/'
  }


  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout scm
      }
    }


    stage('Clean') {
      steps {
                dir("${PROJECT_PATH_BACK}")
            {
              sh 'gradle clean'
            }

      }
    }
    stage('Build') {
      steps {
                dir("${PROJECT_PATH_BACK}")
            {
              sh 'gradle build -x test'
            }

      }
    }

    stage('Tests'){
        parallel {
            stage(''){
                steps {
                        dir("${PROJECT_PATH_BACK}"){
                        sh 'gradle --stacktrace test'
                    }
                }
            }
        }
    }

                      stage('Static Code Analysis'){
        steps{
            echo '------------>Analisis de código estático<------------'
            withSonarQubeEnv('Sonar') {
                     sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./microservicio/sonar-project.properties"
            }
        }
    }
  }


  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit '**/test-results/test/*.xml'  //RUTA DE LOS ARCHIVOS .XML
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'santiago.alvarez@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}