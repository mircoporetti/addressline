<h2>Instructions</h2>
Use the following commands from the project root directory to run the application.

<h2>Requirements:</h2>
- Maven
- Docker (2a method) or JDK 11(2b method)

<h3>1) Build the application:</h3>

    mvn clean package

<h3>2a) Run it using Docker:</h3>

    docker build -t addressline . && docker run -it addressline

OR

<h3>2b) Run the jar file directly:</h3>

    java -jar addressline-application/target/addressline.jar

    