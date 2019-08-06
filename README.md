#Parent POM for Vaadin Tutorials


## Info
**Project is build/tested with svenruppert/maven-3.6.1-adopt:1.8.212-04 docker image !!**

This project is a minimized version of 
[https://github.com/RapidPM/rapidpm-dependencies](https://github.com/RapidPM/rapidpm-dependencies)

## Versioninfos

### NEXT
* TBD

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

