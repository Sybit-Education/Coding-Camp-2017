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

                sh 'cp target/r750explorer.war /data/r750'       

            }


            if(env.BRANCH_NAME == 'master'){
                echo 'Deploy master on PROD Server ...'  
                withCredentials([usernamePassword(credentialsId: 'r750explorer', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    // available as an env variable, but will be masked if you try to print it out any which way
                    sh 'echo $PASSWORD'
                    // also available as a Groovy variable—note double quotes for string interpolation
                    echo "$USERNAME"
                    sh "ssh $USERNAME@r750explorer.me  \"echo ${env.BUILD_ID}\""
                }

                            
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