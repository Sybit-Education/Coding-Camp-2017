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


        stage('Test'){
            sh 'mvn test'
            junit 'target/surefire-reports/*.xml'
            step( [ $class: 'JacocoPublisher' ] )
        }

        stage('Deploy'){

            if(env.BRANCH_NAME == 'develop'){         
                echo 'Deploy develop on Test-Server ...'  
                sh 'cp target/r750explorer.war /data/r750'       

            }


            if(env.BRANCH_NAME == 'master'){
                echo 'Deploy master on PROD-Server ...'  

                withCredentials([usernamePassword(credentialsId: 'r750explorer', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    
                    sh 'sshpass -p \'$PASSWORD\' ssh $USERNAME@r750explorer.me "service r750explorer stop; scp ./target/r750explorer.war /var/r750explorer/ ; service r750explorer start;"'
                    
                }

                            
            }
        }   

    } catch (e){
      echo e
    }


}