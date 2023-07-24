FROM gradle:7.4.2-jdk17

RUN apt-get update && apt-get install

ENV INSTALL_PATH /reactive-flashcards

RUN mkdir $INSTALL_PATH

WORKDIR $INSTALL_PATH

COPY . .


