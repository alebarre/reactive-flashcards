gradle clean
gradle bootJar
#java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar build/lib/reactive-flashcards-0.0.1-SNAPSHOT
java -jar build/lib/reactive-flashcards-0.0.1-SNAPSHOT