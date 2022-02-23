

## Build from source:

    %  git clone https://github.com/RostislavDolbilov/MessagingApp.git
    %  cd MessagingApp
    %  mvn package
or build from development environment (IntelliJ IDEA)

You must have a /target directory and messaging_app.jar file after building



## Start the server:

Open a terminal and run the following command in the target directory:

    %  java -cp "messaging_app.jar:lib/*" com.slavadolbilov.server.Server
If you are on Windows, make sure to change the classpath separator to ; instead of :


## Launch a first client:

Open a second terminal and run the following command in the target directory:

     %  java -cp "messaging_app.jar:lib/*" com.slavadolbilov.client.Client
If you are on Windows, make sure to change the classpath separator to ; instead of :

## Launch a second client:
With the same command used to launch the first client, run a second client in a separate terminal and start chatting.

# Example:

### Server  
    февр. 23, 2022 5:02:48 AM org.glassfish.tyrus.server.ServerContainerFactory create
    INFO: Provider class loaded: org.glassfish.tyrus.container.grizzly.GrizzlyEngine
    февр. 23, 2022 5:02:48 AM org.glassfish.grizzly.http.server.NetworkListener start
    INFO: Started listener bound to [0.0.0.0:8099]
    февр. 23, 2022 5:02:48 AM org.glassfish.grizzly.http.server.HttpServer start
    INFO: [HttpServer] Started.
    февр. 23, 2022 5:02:48 AM org.glassfish.tyrus.server.Server start
    INFO: WebSocket Registered apps: URLs all start with ws://localhost:8099
    февр. 23, 2022 5:02:48 AM org.glassfish.tyrus.server.Server start
    INFO: WebSocket server started.
    Press any key to stop the server..
    
### Client 1
    %    cd /Users/rostislavdolbilov/Desktop/JAVA/messaging-app/ServerMessagingApp/target/
    %    java -cp "messaging_app.jar:lib/*" com.slavadolbilov.client.Client
    Type your name
    Slava
    Connection established. Session id:   13a1dde2-a1ac-4f5e-93a8-3497055ba864
    You are logged in as: Slava
    Hi Natali!!!
    23.02.2022, 5:10 - Natali:  Hi Slava =)
    Do you now something about WebSocket?
    23.02.2022, 5:11 - Natali:  Yep, I will send you some links
    Ok, thank you

### Client 2
    %    cd /Users/Desktop/JAVA/messaging-app/ServerMessagingApp/target/
    %    java -cp "messaging_app.jar:lib/*" com.slavadolbilov.client.Client
    Type your name
    Natali
    Connection established. Session id:   5e436e65-ac29-4415-96ff-918b440a0223
    You are logged in as: Natali
    23.02.2022, 5:09 - Slava:  Hi Natali!!!
    Hi Slava =) 
    23.02.2022, 5:10 - Slava:  Do you now something about WebSocket?
    Yep, I will send you some links
    23.02.2022, 5:11 - Slava:  Ok, thank you


