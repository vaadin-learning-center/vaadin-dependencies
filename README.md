# Parent POM for Vaadin Tutorials

## Current state
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Info
**Project is build/tested with svenruppert/maven-3.6.1-adopt:1.8.212-04 docker image !!**

This project is a minimized version of 
[https://github.com/RapidPM/rapidpm-dependencies](https://github.com/RapidPM/rapidpm-dependencies)

## How to use
The dependency is distributed via Bintray.
Add first to repository coordinates to your **pom.xml**

```xml
  <repositories>
    <repository>
      <name>bintray</name>
      <id>bintray-vaadin-tutorials-maven</id>
      <url>https://dl.bintray.com/vaadin-tutorials/maven</url>
      <snapshots><enabled>false</enabled></snapshots>
    </repository>
  </repositories>
```

After this you can add the **parent**. 
This project supports all LTS versions up from Vaadin8 and the current version.

### V8 (LTS)
```xml
  <parent>
    <groupId>org.vaadintutorials</groupId>
    <artifactId>vaadin-dependencies-v08</artifactId>
    <version>XXXX</version>
  </parent>
```
### V10 (LTS)
```xml
  <parent>
    <groupId>org.vaadintutorials</groupId>
    <artifactId>vaadin-dependencies-v10</artifactId>
    <version>XXXX</version>
  </parent>
```
### V14 (LTS)
```xml
  <parent>
    <groupId>org.vaadintutorials</groupId>
    <artifactId>vaadin-dependencies-v14</artifactId>
    <version>XXXX</version>
  </parent>
```
### Current 
```xml
  <parent>
    <groupId>org.vaadintutorials</groupId>
    <artifactId>vaadin-dependencies-vXX</artifactId>
    <version>XXXX</version>
  </parent>
```

## Versioninfos

### NEXT
* TBD
### 2.0.1


### 2.0.0
* changed structure
* switched to bintray repos
* using nano-vaadin for jetty and undertow


### 1.0.6
* added java-faker to scope test

### 1.0.5
* added Testcontainers (core and selenium) to the scope **test**
* added testbench as dependency for scope **test**
* param for NanoVaadin --apm (to activate Application Performance Monitoring)

### 1.0.4
* added nano-jetty module
* update to V14RC9


### 1.0.0
initial release

## Properties
* **minimum-maven.version** - setting required maven version, default is 3.3.9
* **activateJavaOnly** - true = JDK only / false JDK plus Kotlin activated
* **vaadin-productionMode** - activated inside the vaadin-dependencies the production mode
* **vaadin-install-nodejs** - true or false (default)
    * frontend-maven-plugin.nodeVersion
    * frontend-maven-plugin.npmVersion
    * frontend-maven-plugin.installDirectory - default value - target
* **kotlin.compiler.jvmTarget** - default 1.8
* **kotlin.version** - default mostly latest version
* **kotlin.compiler.incremental** - default true


## Profiles

### _nodejs_npm - For NodeJS && NMP installation
Some Webprojects need NodeJS and NPM installed. Vaadin 14 Flow is one example.
To configure this you can use the following properties.

```xml
    <!--Vaadin-->
    <vaadin-productionMode>false</vaadin-productionMode>
    <vaadin-install-nodejs>true</vaadin-install-nodejs>
    <frontend-maven-plugin.nodeVersion>v4.6.0</frontend-maven-plugin.nodeVersion>
    <frontend-maven-plugin.npmVersion>2.15.9</frontend-maven-plugin.npmVersion>
    <frontend-maven-plugin.installDirectory>target</frontend-maven-plugin.installDirectory>
```

