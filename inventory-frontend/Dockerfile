# If build is already created
FROM nginx:alpine
COPY /dist/inventory-frontend /usr/share/nginx/html
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