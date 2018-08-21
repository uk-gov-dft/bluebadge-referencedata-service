#!/usr/bin/env bash
tearDown() {
  cd dev-env-rob
  docker-compose kill
  docker-compose rm -f
  cd ..
  rm -rf dev-env-rob
}

set -a -x

if [[ ! -e ~/.ssh/github_token ]]; then
  echo "You need to create a personal access github token in ~/.ssh/github_token in order to access github"
  exit 1
fi

# kill anything that is running
dockerContainers=$(docker ps -q)
if [[ "$dockerContainers" == "" ]]; then
   echo "No previously running containers.. nothing to kill"
else
   echo "Killing docker containers.. $dockerContainers"
   docker kill ${dockerContainers}
fi

# This really cleans everything up so there's nothing previous that could contaminate
docker system prune -a -f

# Get the dev-env stuff
if [[ -d dev-env-rob ]]; then
  tearDown
fi
curl -sL -H "Authorization: token $(cat ~/.ssh/github_token)" https://github.com/uk-gov-dft/dev-env/archive/rob.tar.gz | tar xz
if [ $? -ne 0 ]; then
   echo Cannot download dev-env!
   exit 1
fi

# 'VERSION-computed' needed for environment variables
gradle :outputComputedVersion
. env-feature.sh

cd dev-env-rob
bash load-modules.sh
docker-compose build 
docker-compose up -d
./wait_for_it.sh localhost:5432 localhost:8681:/manage/actuator/health localhost:8381:/manage/actuator/health localhost:8281:/manage/actuator/health localhost:8081:/manage/actuator/health localhost:8481:/manage/actuator/health localhost:8181:/manage/actuator/health localhost:8581:/manage/actuator/health
psql -h localhost -U developer -d bb_dev -f ./scripts/db/setup-user.sql 

# Run the acceptance tests
cd ..
gradle acceptanceTests
testExitCode=$?

# Tear down
docker kill $(docker ps -q)
tearDown

echo "Exiting with code:$testExitCode"

exit "$testExitCode"

