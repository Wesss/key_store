# Key Store CLI

This is my solution to the key store CLI assignment. Its written using Java, and configured using Maven. Given the clean nature of this assignment, I've also included unit tests in order to make my testing go faster.

## Setup
- download java jdk 12.0.1
  - download can be found [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html)

- download and install maven 3.6.1
  - download can be found [here](https://maven.apache.org/download.cgi?Preferred=http%3A%2F%2Fapache.claz.org%2F)
  - installation instructions [here](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- clone this repository

  ```
  git clone git@github.com:Wesss/key_store.git
  ```

- compile the application

  ```
  mvn package
  ```

- run the application

  ```
  java -jar target/keystore-1.0-SNAPSHOT.jar
  ```

- run just the tests

  ```
  mvn test
  ```
