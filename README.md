# Website

This is a simple website using Vue.js and Docker ([Live demo](https://matthieuclement.com)).

## Setup

### Dev

1. With npm

```bash
cd app
npm install
npm run dev
```

2. With docker

```bash
docker build -f Dockerfile.dev -t app:dev .
docker run --rm -p 8080:8080 --name app_dev -d app:dev
```

3. With docker (prod version)

```bash
docker build -t app:prod .
docker run --rm -p 8080:80 --name app_prod -d app:prod
```
