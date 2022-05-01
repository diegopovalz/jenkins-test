pipeline {
  //Donde se va a ejecutar el Pipeline
  agent any

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	  disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK 8u221' //Versión necesaria para SonarQube según logs (Se menciona que es necesario JDK >= 11)
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout'){
      steps{
        echo "------------>Checkout<------------"
        checkout([
          $class: 'GitSCM',
          branches: [[name: '*/master']],
          doGenerateSubmoduleConfigurations: false,
          extensions: [],
          gitTool: 'Default',
          submoduleCfg: [],
          userRemoteConfigs: [[
            credentialsId: 'GitHub_diegopovalz',
            url: 'https://github.com/diegopovalz/jenkins-test'
          ]]
        ])
      }
    }

    stage('Clean') {
      steps{
        sh 'chmod +x ./mvnw'
      	sh './mvnw clean'
      }
    }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>compile & Unit Tests<------------"
        sh './mvnw test'
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        sh './mvnw build -DskipTests'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      //junit 'build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      //mail (to: 'diego.poveda@ceiba.com.co', subject: "Failed Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}")
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