# Website

This is a simple website using Vue.js and Docker ([Live demo](https://matthieuclement.com)).

## Setup

[Setup frontend](./frontend/README.md)

[Setup backend](./backend/README.md)

## Run

```bash
docker-compose down
docker-compose build --no-cache
docker-compose up --force-recreate --no-deps
```

Then go to :

* [Backend](http://localhost:8081/health)
* [Frontend](http://localhost:8080)
