node{
        stage('git checkout'){
            echo "checking out the code from github"
            git 'https://github.com/asambajava/insure-me-capstone.git'
        }
        
        stage('maven build'){
            sh 'mvn clean package'
        }
        
        stage('build docker image'){
            sh 'docker build -t asambaraju/insure-me:1.0 .'
        }
        
        stage('push docker image to docker hub registry')
        {
            echo 'pushing images to registry'
            
            withCredentials([string(credentialsId: 'docker-hub-password', variable: 'dockerHubPassword')]) {
                sh "docker login -u asambaraju -p ${dockerHubPassword}"
                sh 'docker push asambaraju/insure-me:1.0'
            }
        }
        
        stage('configure test-server and deploy insure-me'){
            echo "configuring test-server"
          //  sh 'ansible-playbook configure-test-server.yml'
            ansiblePlaybook become: true, credentialsId: 'ssh-key-ansibles', disableHostKeyChecking: true, installation: 'ansible', inventory: '/etc/ansible/hosts', playbook: 'configure-test-server.yml'
        }
        
}
