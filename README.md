# Website

This is my portfolio website using Vue.js (frontend), Java Spring (backend) and Kubernetes (deployment).

You can check out the [live demo here](https://matthieuclement.com).

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
