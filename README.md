# Intuit Demo
#### purpose: show case programming skills.

## Requirements
* Use Spring boot 1.x with Java 8.  (Will be using spring boot 1.5.19).

#### Story
Implement a web application using spring boot which will expose an POST endpoint consuming a JSON payload.
The JSON payload should be logged onto the terminal and mask sensitive information. Then simply return the JSON 
payload intact as response.

#### Design
Endpoint:  POST: /intuit/account

Payload sample:
```json
{
  "account": "123456789",
  "cc": "1234 5555 1234 6666",
  "firstname": "John",
  "lastname": "Doe"
}
```

#### Build from terminal
You can manually build the project within the terminal.  Navigate to the root of the project and execute the following:
```
./gradlew clean build
```

#### Run from terminal
```json
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8012,suspend=n -jar build/libs/mask-0.0.1-SNAPSHOT.jar --server.port=8080
```

#### Try the application from browser (will only do a GET not the POST) - just to verify the server is up and running
try the following url:  [http://localhost:8080/intuit/account](http://localhost:8080/intuit/account)


#### Try a POST with curl
```json
curl --header "Content-Type: application/json" --request POST \
--data '{"account": "123456789", "cc": "1234 5555 1234 6666", "firstname": "John", "lastname": "Doe" }' \
http://localhost:8080/intuit/account
```
#### Test Coverage
The `./gardlew clean build` command above will also run all the tests and create a test coverage report located 
in the `build/reports/tests/test/index.html` folder.  Open this `index.html` into a browser to see the coverage report.


#### Lombok
Note that I will use lombok for logging to terminal.  If you run the web application directly from IntelliJ, make sure you 
select `Enable annotation processing` from `Preferences / Compiler / Annotation Processors`

Otherwise, you can always run it from terminal (as above instructions).

  

