# étape de build
FROM node:lts-alpine AS build-stage
WORKDIR /frontend
COPY ./frontend/package*.json ./
RUN npm install
COPY frontend .
RUN npm run build

# étape de production
FROM nginx:stable-alpine AS production-stage
COPY --from=build-stage /frontend/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]