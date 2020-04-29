pipeline{
        agent any
        stages {
            stage('Lint HTML'){
                steps {
                    sh 'tidy -q -e *.html'
                }
            }
            stage('Upload to AWS') {
                steps {
                    retry(3){
                       withAWS(region:'us-east-2',credentials:'AKIA2RYGZ3D3DITFVSNY') {
                       s3Delete(bucket: 'jenkins-bucket5', path:'**/*')
                       s3Upload(bucket: 'jenkins-bucket5', file:'index.html');
                    }                             
                }
            }
        }
    }
}
