#!/bin/bash
mvn clean package -DskipTests
mkdir -p target/java-app
unzip -q target/xtr-price-service-1.0.0.jar -d target/java-app
