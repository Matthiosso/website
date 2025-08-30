# Website

This is a simple website using Vue.js and Docker ([Live demo](https://matthieuclement.com)).

## Setup

### Dev

1. With npm

```bash
cd frontend
npm install
npm run dev
```

2. With docker

```bash
docker build -f Dockerfile.dev -t frontend:dev .
docker run --rm -p 8080:8080 --name frontend_dev -d frontend:dev
```

3. With docker (prod version)

```bash
docker build -t frontend:prod .
docker run --rm -p 8080:80 --name frontend_prod -d frontend:prod
```
