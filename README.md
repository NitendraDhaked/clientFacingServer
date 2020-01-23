Clientfacing Server is microservice which is internally calling function server

Project can be build or test using maven, below are the some commands.
$mvn package

$mvn test

project is containerised and pushed to docker artifatory.
$mvn jib:build

3 alternatively one can run this project after local build, artifacts is available in target directory.

$java -jar clientfacingserver-1.0.1.jar


EurekaServer is not impleneted, so auto discovery of service is not there.

Please run this service in localhost

functionserver should be must run to process client request

Please open services in two different terminal and hit the bewlow request from browser.

http://localhost:8089/api/v1/operation?operation=multiply&operand1=10&operand2=20
