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
docker build -t app .
docker run --rm -p 8080:8080 app
```

3. With docker (prod version)

```bash
docker build -f Dockerfile.prod -t app .
docker run --rm -p 8080:8080 app
```
