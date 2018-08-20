#!/usr/bin/env bash
tearDown() {
  cd dev-env-rob
  docker-compose kill
  docker-compose rm -f
  cd ..
}

set -a -x

if [[ ! -e ~/.ssh/github_token ]]; then
  echo "You need to create a personal access github token in ~/.ssh/github_token in order to access github"
  exit 1
fi

# Get the dev-env stuff
if [[ -d dev-env-rob ]]; then
  tearDown
  rm -rf dev-env-rob
fi
curl -sL -H "Authorization: token $(cat ~/.ssh/github_token)" https://github.com/uk-gov-dft/dev-env/archive/rob.tar.gz | tar xz
if [ $? ne 0 ]; then
   echo Cannot download dev-env!
   exit 1
fi


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
tearDown
rm -rf dev-env-rob

echo "Exiting with code:$testExitCode"

exit "$testExitCode"

