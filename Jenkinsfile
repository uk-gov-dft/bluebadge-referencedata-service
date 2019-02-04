def build_number  = "${env.BUILD_NUMBER}"
def REPONAME      = "${scm.getUserRemoteConfigs()[0].getUrl()}"

node {

    stage('clean workspace') {
        cleanWs()
    }

    stage('Clone sources') {
      git(
           url: "${REPONAME}",
           credentialsId: 'dft-buildbot-valtech',
           branch: "${BRANCH_NAME}"
        )
    }
    
    stage ('Gradle build') {
        // Set Environment Vairable if the CI env variable is set.
        script {
            env.SPRING_APPLICATION_JSON = '{"spring":{"datasource":{"url":"jdbc:postgresql://postgresql:5432/bb_dev?currentSchema=referencedata"}}}'
        }
        try {
            sh './gradlew --no-daemon --profile --configure-on-demand clean build bootJar createDatabaseSchemaZip artifactoryPublish artifactoryDeploy'
            sh 'mv build/reports/profile/profile-*.html build/reports/profile/index.html'
        }
        finally {
            junit '**/TEST*.xml'
        }
        withCredentials([string(credentialsId: 'GITHUB_TOKEN', variable: 'GITHUB_TOKEN')]) {
          sh '''
            curl -s -o docker-publish.sh -H "Authorization: token ${GITHUB_TOKEN}" -H 'Accept: application/vnd.github.v3.raw' -O -L https://raw.githubusercontent.com/uk-gov-dft/shell-scripts/master/docker-publish.sh
            ls -la
            bash docker-publish.sh
          '''
        }
        publishHTML (target: [
          allowMissing: false,
          alwaysLinkToLastBuild: false,
          keepAll: true,
          reportDir: 'build/reports/profile',
          reportFiles: 'index.html',
          reportName: "Gradle Profile Report"
        ])
    }

    stage ('OWASP Dependency Check') {
        sh './gradlew dependencyCheckUpdate dependencyCheckAggregate'

        publishHTML (target: [
         allowMissing: false,
         alwaysLinkToLastBuild: false,
         keepAll: true,
         reportDir: 'build/reports',
         reportFiles: 'dependency-check-report.html',
         reportName: "OWASP Dependency Check"
        ])
    }

    stage('SonarQube analysis') {
        withSonarQubeEnv('sonarqube') {
            def ver = readFile('VERSION').trim()
            echo "Version: " + ver
            // requires SonarQube Scanner for Gradle 2.1+
            // It's important to add --info because of SONARJNKNS-281
            sh "./gradlew --info sonarqube -Dsonar.projectName=referencedata-service -Dsonar.projectVersion=${ver} -Dsonar.branch=${BRANCH_NAME}"
        }
    }
    stage("Quality Gate") {
        timeout(time: 5, unit: 'MINUTES') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
    }
    stage("Acceptance Tests") {
        node('Functional') {
            git(
               url: "${REPONAME}",
               credentialsId: 'dft-buildbot-valtech',
               branch: "${BRANCH_NAME}"
            )

            timeout(time: 10, unit: 'MINUTES') {
                try {
                    sh 'bash -c "echo $PATH && cd acceptance-tests && ./run-regression.sh"'
                }
                finally {
                    archiveArtifacts allowEmptyArchive: true, artifacts: '**/docker.log'
                    junit '**/TEST*.xml'
                }
            }
        }
    }
}
