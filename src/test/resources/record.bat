java -Dhttp.proxyHost=192.168.1.254 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=192.168.1.254 -Dhttps.proxyPort=8080 -jar wiremock-standalone-2.7.1.jar --proxy-all="https://api.airtable.com/v0" --record-mappings --verbose --print-all-network-traffic --port=8095
pause