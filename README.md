# Drinks and Delight

- [Drinks and Delight](#drinks-and-delight)
  - [Check Deployment](#check-deployment)
  - [`inventory-database-service`](#inventory-database-service)
  - [`inventory-auth-service`](#inventory-auth-service)
  - [`inventory-discovery-server`](#inventory-discovery-server)
  - [`inventory-product-order-service`](#inventory-product-order-service)
  - [`inventory-rawmaterial-order-service`](#inventory-rawmaterial-order-service)
  - [`inventory-stock-management-service`](#inventory-stock-management-service)
  - [`inventory-supplier-service`](#inventory-supplier-service)
  - [Steps To Start](#steps-to-start)
    - [Localhost](#localhost)
    - [Docker](#docker)
    - [Kubernetes (Local)](#kubernetes-local)
    - [Kubernetes Google Gloud](#kubernetes-google-gloud)
  - [Documentations](#documentations)
  - [TODO - CORS Observations (Need Help)](#todo---cors-observations-need-help)
    - [Update [Fixed]](#update-fixed)

## Check Deployment

- Click on https://gagandeep39.github.io/drink-and-delight

## `inventory-database-service`

- Database Server
- Microservice Port 9500
- Database port 9550
- Endpoint `/h2`
- Credentials
  - username: `sa`
  - password: 

## `inventory-auth-service`

- Perform Login, Registeration, Change Password
- Refer [file](inventory-auth-service/manual-test.http) for JSON formats
- Encrypts Password
- Default Port 9100

## `inventory-discovery-server`

- All microservices register themselves to eureka
- Microservices path is fetched By Gateway
- Default port 8761

## `inventory-product-order-service`
- Purchase a new Product
- Fetch list of all products
- Update Product Delivery Status
- Default port 9200

## `inventory-rawmaterial-order-service`

- Crete Raw Material Order
- Update Raw Material Order
- Default Port 9300

## `inventory-stock-management-service`
- Create new Product entity and Raw Material Entity
- Update Stocks
- Fetch All products and Raw materials

## `inventory-supplier-service`
- Stores Supplier, Distribtor Data
- Create and Update Supplier, Distributor
- Fetch All Supplier AAnd Distributors

## Steps To Start

### Localhost

1. Open the project on Ecllipse/ VS Code
2. Launch Eureka Discovery Server
3. Launch Database Server
4. Launch Gateway Server
5. Launch All other Services

### Docker
1. Go to root of the project
2. Run Docker-compose up to Run the server
3. Run the Client Separately
4. Make sure Client Project running normally or in docker has correct server URL

### Kubernetes (Local)
1. Go to k8s Directory
2. Run `kubectl apply -f .`
3. Check the Zuul service port number
4. Update Application URL by setting it as zuul nodeport url
5. Run client Code

### Kubernetes Google Gloud
1. Install Google Cloud SDK on PC
2. Launch Docker Desktop on PC (Make sure Kubernetes is on)
3. Create a new Cluster with 4 CPU and 8GB
4. Set Kubernetes Context to Google Cloud Cluster
5. Go to K8s Directory
6. Run `kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.40.2/deploy/static/provider/cloud/deploy.yaml`
7. ### Code Deployment
1. Go to Kubernetes Depoyment Code directory
2. Run `kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.40.2/deploy/static/provider/cloud/deploy.yaml`
3. Run `kubernetes apply -f .`
4. Check Google Cloud Console -> Services
   1. Look for a load balancer service
   2. Copy the Extenal Load Balancer URL
   3. Run it in Browser
   4. Wait for Sometime for services to start (15 min atleast)
5. Go to services -> Create Ingress (This step requires a NodePort service - Take a note if modifying K8s)
   1. Create Ingress
   2. Specify Path as default
   3. Specify Service as zuul-srv
   4. Create
6. Run the Client with External Load balancer IP


## Documentations

- Application Docs [link](https://docs.google.com/document/d/1Te2IA0HN0hNlut2BKSFw_3Qm6EbWebSG4EGJwBOMDH8/edit?usp=sharing)
- Test Case Docs [link](https://docs.google.com/spreadsheets/d/1xxKnm2lhQwETKgAzmdislwUP-Ep6zBeLnQce522hff8/edit?usp=sharing)
- Refer Above link for Latest Docs or else fetch the docs from current repository

## TODO - CORS Observations (Need Help)

- Auth Service
1. Route must hvae Cross origin annotation independent of everything lese it will surely give erro
2. Registreation routes will still give error with origins annotation(Needs cors().and() in Security fofx to fix it)


- Client
1. Cors Interceptor with allow origin header breaks CORS

- Zuul
1. cors().and() breaks JWT Code (Prevents any Request from even hitting JWT filter or auth entry point)
2. CORS filter Bean causes Error for Cross-Origin header missing
3. adding res.addHeader("Authntication") in JWT Filter fixes code temporailiy in Chrome Only

- Zuul Properties
1. SensitiveHeaders must be set blank (Cant be removed)
2. Ignored Header causes Origin Error

### Update [Fixed]

- To Run Client and server in localhost, use extension [`moesif cors chrome extension`](https://chrome.google.com/webstore/detail/moesif-origin-cors-change/digfbfaphojjndkpccljibejjbppifbc)
- To Deploy in a remote device append `https://cors-anywhere.herokuapp.com/` before `http://`
- Make sure localhost client has port number in gateway url i.e `localhost:9000`
