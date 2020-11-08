# Drinks and Delight

- [Drinks and Delight](#drinks-and-delight)
  - [`inventory-database-service`](#inventory-database-service)
  - [`inventory-auth-service`](#inventory-auth-service)
  - [`inventory-discovery-server`](#inventory-discovery-server)
  - [`inventory-product-order-service`](#inventory-product-order-service)
  - [`inventory-rawmaterial-order-service`](#inventory-rawmaterial-order-service)
  - [`inventory-stock-management-service`](#inventory-stock-management-service)
  - [`inventory-supplier-service`](#inventory-supplier-service)
  - [Steps To Start](#steps-to-start)
    - [Localhost](#localhost)
  - [Documentations](#documentations)
  - [TODO - CORS Observations (Need Help)](#todo---cors-observations-need-help)

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

## `inventory-rawmaterial-order-service`

- Crete Raw Material Order
- Update Raw Material Order
- Default Port 9300

## `inventory-stock-management-service`

## `inventory-supplier-service`

## Steps To Start

### Localhost

1. Open the project on Ecllipse/ VS Code
2. Launch Eureka Discovery Server
3. Launch Database Server
4. Launch Gateway Server
5. Launch All other Services

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
