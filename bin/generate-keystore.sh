#!/usr/bin/env bash
set -euo pipefail
IFS=$'\n\t'
set -x

rm -f src/main/resources/keystore/keystore.p12

# this is wrong
#keytool -genkeypair -alias baeldung -keyalg RSA -keysize 4096 \
#  -validity 3650 -dname "CN=localhost" -keypass changeit -keystore src/main/resources/keystore/keystore.p12 \
#  -storeType PKCS12 -storepass changeit