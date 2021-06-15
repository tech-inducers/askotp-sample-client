#!/bin/bash
java -jar ./target/kuhakAppeMailHandler-0.0.1-SNAPSHOT.jar --spring.config.location=file:./target/application.properties & echo $! > ./pid.file &