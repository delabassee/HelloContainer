#!/usr/bin/env bash
set -ex
mvn clean install
native-image -cp ./target/HelloWorld-1.0-SNAPSHOT.jar -H:Name=HelloWorld -H:Class=com.delabassee.HelloWorld -H:+ReportUnsupportedElementsAtRuntime --allow-incomplete-classpath