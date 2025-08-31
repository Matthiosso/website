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
docker build -t frontend:prod .
docker run --rm -p 8080:80 --name frontend_prod -d frontend:prod
```
