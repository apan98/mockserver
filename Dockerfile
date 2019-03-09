FROM java:8
EXPOSE 8080
WORKDIR /srv
ADD /src /srv
ENV GRADLE_HOME=/app/gradle-2.4
ENV PATH=$PATH:$GRADLE_HOME/bin
RUN gradle bootrun

ENTRYPOINT ["launcher.sh"]