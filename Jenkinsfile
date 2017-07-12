node {
    // Clean workspace before doing anything
    deleteDir()

    try {
        stage ('Clone') {
            checkout scm
        }
        stage ('Build') {
             echo "shell scripts to build project..."
        }
        stage ('Tests') {
            parallel 'static': {
                echo "shell scripts to run static tests..."
            },
            'unit': {
                echo "shell scripts to run unit tests..."
            },
            'integration': {
                echo "shell scripts to run integration tests..."
            }
        }
        stage ('Deploy') {
            echo "shell scripts to deploy to server..."
        }
    } catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}
