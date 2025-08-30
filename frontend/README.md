# Vue 3 + Vite

Following this [tutorial](https://www.youtube.com/watch?v=zo0oOsCqYzc)

## Setup

### With npm

```bash
cd frontend
npm install
npm run dev
```

### With docker

```bash
docker build -f Dockerfile.dev -t frontend:dev .
docker run --rm -p 8080:8080 --name frontend_dev -d frontend:dev
```

### With docker (prod version)

```bash
docker build -t frontend:prod .
docker run --rm -p 8080:80 --name frontend_prod -d frontend:prod
```
