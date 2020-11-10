# Kubernetes Deployment

- [Kubernetes Deployment](#kubernetes-deployment)
  - [Google Kubernetes Engine](#google-kubernetes-engine)
    - [Installing Cloud SDK](#installing-cloud-sdk)
    - [Creating Cluster in GKE](#creating-cluster-in-gke)
    - [Connecting To remote Cluster](#connecting-to-remote-cluster)
    - [Code Deployment](#code-deployment)
    - [Notes](#notes)

## Google Kubernetes Engine

### Installing Cloud SDK
1. Download and Install [link](https://cloud.google.com/sdk/docs/quickstarts)
2. Run `gcloud auth login` (Redirected t browser for logging in)
3. `gcloud init` Run through all the instructions (noot required if setup already done by CLoud installer)

### Creating Cluster in GKE
1. Go To Google Kubernetes Website
2. Create a new Cluster
   - Note the regoin here the Cluster was created
5. Create a `Node Pool` in that cluster
   - 4 nodes
   - Size must be small 2vCPU, 4GB RAM (Free Quota)

### Connecting To remote Cluster
1. Make sure Docker Desktop is installed
2. `gcloud container clusters get-credentials <cluster-name>`
3. Go to Docker desktop and cross verify the Context shows something related to google cloud instead of `Docker Desktop`

### Code Deployment
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

### Notes

- Sometimes Application may appear to crash aain and again, mostly this is due to low resource allocation
- Starting a new Deployment/ Updating requires some free CPU, so we need to manually delete an old deployment Pod
- Check all the service running status at Google Kubernetes Engine Dashboard