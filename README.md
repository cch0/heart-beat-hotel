a Spring Boot application with WebSocket and STOMP
  
===========

What is it going to provide?

allow two-way communication between client (browser) and server using WebSocket and STOMP

allow multiple clients with same identification to register itself with the server to receive notification from the server

allow heart beat message to be sent between client and server (although only server-to-client heart beat is implemented here)

allow client to de-register itself with the server

===========

What is it really?

It is an application which allows client (browser) to establish connection with the server to be
able to receive server heart beat message.
 
User can also use UI to notify server to "roll the date". When date is rolled, server will send back a 
message with the new property date. All other users (with the same identification) will then also be
notified with this message.


===========

How to build the application?

This is a maven project with Java source level set to be 1.8

To build the project: 

    mvn clean package
    
This will create a jar file under target/sample-1.0-SNAPSHOT.jar
    
    
===========

How to run the application?

Since this is built by using Spring Boot, the generated jar file has everything that needs to run the application.

    java -jar target/sample-1.0-SNAPSHOT.jar
    
    
===========
    
How to access from the browser?
    
    http://localhost:8080
    
    Enter the property name in the text box.
    
    Click "Click to Connect" button to connect to the server
    
    Click "Click to roll the date" button to tell the server to roll the date for this property
    
    Click "Disconnect" button to de-register this client and disconnect from the server
    
    
    
    
    
    
    
    
