#!/bin/bash
set -o nounset

export JENKINS_CONTAINER_NAME=jenkins-agent11
export JENKINS_CONTAINER_NAME_2=jenkins-agent17
export JENKINS_HOME=/home/jenkins
export JENKINS_AGENT_SSH_PUBKEY="$(cat ~/.ssh/id_rsa.pub)"

JENKINS_CONTAINER_NAME=$JENKINS_CONTAINER_NAME JENKINS_HOME=$JENKINS_HOME JENKINS_AGENT_SSH_PUBKEY="$JENKINS_AGENT_SSH_PUBKEY" docker-compose -f docker-compose.yaml up --build -d

sleep 10

docker exec $JENKINS_CONTAINER_NAME bash -c "apt-get update -y -q && apt-get upgrade -y -q && apt-get install -y -q git python3 python3-venv maven"
docker exec $JENKINS_CONTAINER_NAME_2 bash -c "apt-get update -y -q && apt-get upgrade -y -q && apt-get install -y -q git python3 python3-venv maven"
