node{
    try{
        stage('Checkout'){
            checkout scm
        }

        withMaven( maven: 'M3') {
            stage('Build'){
                sh 'mvn clean install -DskipTests'
            }

            stage('Test'){
                sh 'mvn test'
            }
        }

        archiveArtifacts allowEmptyArchive: true, artifacts: '**/target/*.war', fingerprint: true

        def branchName = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()

        if(branchName == 'master'){
            stage('Deploy'){
                echo 'TODO ...'

            }
        }

    } catch (Exception e){
      throw e
    }
}