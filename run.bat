@echo off

REM Compilation
echo Compiling the Maven project...
mvn compile

REM Unit Testing
echo Running tests...
mvn test

REM Packaging (JAR file)
echo Packaging the application...
mvn package

REM Run the Maven project
echo Running the application...
java -jar target/Five-card-1.0-SNAPSHOT.jar
