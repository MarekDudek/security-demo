### Check which port binds to a port

`sudo lsof -i -P -n | grep LISTEN | grep 8443`

### Stop service

`sudo systemctl stop foreman-proxy`

# Inspect certificate

* client certificate

`openssl x509 -in src/main/resources/keystore/baeldungopen.cer -text`

* server certificate

`openssl pkcs12 -info -in src/main/resources/keystore/keystore.p12 -password pass:changeit -passout pass:changeit`


# Generate certificate

`keytool -genkeypair -alias alias-one -keyalg RSA -keysize 4096 -validity 3650 -dname "CN=localhost" -keypass oneone -keystore one.p12 -storeType PKCS12 -storepass oneone`

`keytool -export -alias alias-one -keystore one.p12 -rfc -file one.cert -storepass oneone`

### Creating, Exporting, and Importing SSL Certificates

[https://docs.oracle.com/cd/E54932_01/doc.705/e54936/cssg_create_ssl_cert.htm#CSVSG179](https://docs.oracle.com/cd/E54932_01/doc.705/e54936/cssg_create_ssl_cert.htm#CSVSG179)