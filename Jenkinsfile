node {

def buildNumber = env.BUILD_NUMBER
def workspace = env.WORKSPACE
def buildUrl = env.BUILD_URL
def app
def commit_id

//Checkout the git project containing the Dockerfiles needed for building images
 stage('checkout-qa-project') {

    git branch: 'develop', credentialsId: 'jenkins_ssh_key', url: 'git@gitlab.labgsd.com:sdc/test-automation.git'
 }                                                               
  
  stage('build-run-qa-image') {
      
    sh "git rev-parse HEAD > .git/commit-id"
    commit_id = readFile('.git/commit-id').trim()
    sh "export COMMIT_ID=${commit_id}"
    
    docker.withRegistry('https://registry.labgsd.com', 'docker-reg-cred') {
      app = docker.build("registry.labgsd.com/qa", "${workspace}")
      app.push "latest"
      //app.push "${commit_id}"
    }   
 
  }
  
  stage('execute-tests-inside-qa-container') {
     // Run tests in container locally on jenkins master
    sh "docker run --name qa-container-${commit_id} --rm -t -v /opt/data/maven/repo:/usr/share/maven/repo -e COMMIT_ID=${commit_id} registry.labgsd.com/qa:latest /etc/bootstrap.sh"
  }

  stage('deploy to DCOS') {
  //      sh "dcos marathon app add ${workspace}/qa.json"
   }
    
}
