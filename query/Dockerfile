FROM gradle:8.3.0-jdk11

WORKDIR /usr/src/query
COPY . /usr/src/query
VOLUME /tmp

RUN chmod +x run.sh && gradle updateLib

EXPOSE 8080

CMD [ "sh" , "run.sh" ]