node{
    try{
        
        stage('Checkout'){
            deleteDir() //cleanup workspace
            checkout scm
        }

        stage('Build'){
            sh 'mvn install -DskipTests'
            archiveArtifacts allowEmptyArchive: true, artifacts: '**/target/*.war', fingerprint: true
        }

        stage('Deploy'){

            if(env.BRANCH_NAME == 'develop'){         

                sh 'cp target/githubr750.war /data/r750'       

            }


            if(env.BRANCH_NAME == 'master'){
                echo 'TODO master ...'              
            }
        }

        stage('Test'){
            sh 'mvn test'
            junit 'target/surefire-reports/*.xml'
            step( [ $class: 'JacocoPublisher' ] )
        }   

    } catch (e){
      echo e
    }


}