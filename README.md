# Auto Complete Project

## Description
This project allows getting list of names the matches to a given prefix.

## Language and technologies
* Project written in Java with Spring-boot.
* Using H2 as a db.

## Design
App designed to load data to H2 DB from a given file and return a list of names according to given prefix in the fastest possible way. For allowing that, used in Trie data object which support retrieving list of strings matched to a prefix in O(K).

## Run
> mvn spring-boot:run (exposed on port 8080)

Or alternatively
> mvn package
> 
> docker build -t autocomplete:1 .
> 
> docker run -d --name autocomplete -p 9090:9090 autocomplete:1

## API
This app exposing 1 endpoint:
* **autoComplete** - GET request that returns a list of names which matches to a given prefix as a query parameter named *prefixName*.
  > curl --location --request GET 'localhost:8080/bl/v0/autoComplete?prefixName=s'

##NOTES
file path that contains the data to load located in resources.static directory and can be customized in application.properties file under resources directory.