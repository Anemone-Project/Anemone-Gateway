# Anemone-Gateway

## Description
This is a microservice intended as a receptor for external json data that maps data towards the [Anemone-Bot](https://github.com/Anemone-Project/Anemone-Bot)
using Google Gson.

This service currently runs in a dockerized enviroment for scalability & simplified deployment.

### Prerequisites
Select installation fit for your system at - [Docker](https://www.docker.com/community-edition)
[Apache Maven](https://maven.apache.org/)


**Optional:**
Docker plugin & maven integration available in IDE:
[IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Deployment & quick guide

1. Write this command in terminal at root directory of the repository and run this command in order to build an image of this webservice:
`docker build -f Dockerfile -t anemone-gateway . `

2. Run application through CLI with:
`docker run --rm -it -p 26501:8080 -d anemone-gateway`


## Built with
* [JDA Library](https://github.com/DV8FromTheWorld/JDA)
* [Docker](https://www.docker.com/)
* [Maven](https://maven.apache.org/)
* [Spring framework](https://spring.io/)
* [Gson library](https://github.com/google/gson)

## Authors
* [Software developer - Patricio Morales](https://github.com/Patricio89)
* [Software developer - Jimmy Gustafsson](https://github.com/Seophyn)

## License
**OpenSource**


