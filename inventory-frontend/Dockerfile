# If build is already created
FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/*
COPY /dist/inventory-frontend /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80

# If build is required to be created during docker build
# FROM node:12.16.1-alpine As builder
# WORKDIR /usr/src/app
# COPY package.json package-lock.json ./
# RUN npm install
# COPY . .
# RUN npm run build --prod
# FROM nginx:alpine
# COPY --from=builder /usr/src/app/dist/angular-fitness-tracker /usr/share/nginx/html
# EXPOSE 80

## Works, But doesnt show 404
# FROM nginx:alpine
# RUN rm -rf /usr/share/nginx/html/*
# COPY /dist/inventory-frontend /usr/share/nginx/html
# EXPOSE 80
