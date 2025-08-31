# étape de build
FROM node:lts-alpine AS build-stage
WORKDIR /frontend
COPY ./package*.json ./
RUN npm install
COPY . .
RUN npm run build

# étape de production
FROM nginx:stable-alpine AS production-stage
ENV ASSET_DIR=/usr/share/nginx/html
COPY --from=build-stage /frontend/dist ${ASSET_DIR}
COPY env.sh /docker-entrypoint.d/env.sh
EXPOSE 80
ENTRYPOINT [ "/docker-entrypoint.sh" ]
CMD ["nginx", "-g", "daemon off;"]