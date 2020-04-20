pipeline {
    agent any
    stages {
        stage('Upload to AWS') {
            steps {
                withAWS(region:'us-east-2',credentials:'AKIA2RYGZ3D3DITFVSNY') {
                    s3Delete(bucket: 'jenkins-bucket5', path:'**/*')
                    s3Upload(bucket: 'jenkins-bucket5', file:'index.html');
                    }
                
              }
        }
    }
}