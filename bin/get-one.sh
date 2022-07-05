#!/usr/bin/env bash
set -euo pipefail
IFS=$'\n\t'
set -x

#wget -qO- http://localhost:8080/
#echo

#wget -qO- https://localhost:8080/
#echo

wget -qO- --ca-certificate src/main/resources/keystore/one.cert https://localhost:8443/secured/
echo

curl --cacert src/main/resources/keystore/one.cert https://localhost:8443/secured/
echo