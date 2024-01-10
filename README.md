# Simona Immobilier

## Overview

Housing API based on the microservice architecture.

## Requirements

You need to install:

- `Docker`

- `Minikube` , a local Kubernetes, focusing on making it easy to learn and develop for Kubernetes. More details at https://minikube.sigs.k8s.io/docs/start/

  Once `Minikube`, Run it using the following command:

  ```bash
  minikube start --cpus=2 --memory=2000 --driver=docker
  ```

- `Istio` to handle ingress gateway. More details at https://istio.io/latest/docs/setup/getting-started/

You also need to install the Istio addons (Kiali, Prometheus, Jaeger, Grafana):

```
kubectl apply -f samples/addons
```

## Getting started

Apply Kubernetes deploys, configmaps, services, etc:

```bash
./init.sh
```

Check the status of created pods:

```bash
kubectl get pod
# Output
NAME                               READY   STATUS    RESTARTS   AGE
auth-service-54d8dcd88d-8vqsk      2/2     Running   0          2m2s
db-86b97cb8c6-pnc5r                2/2     Running   0          2m2s
housing-service-7665f55df6-5xjp9   2/2     Running   0          2m2s
loki-0                             2/2     Running   0          4m6s
rental-service-68459b465b-svmvf    2/2     Running   0          2m2s
```

The initialization of the db may take time because of the execution of the SQL file.

Run the API:

```
./run.sh
```

Run monotoring services

```
./kiali.sh
./grafana.sh
```

You can check out the following services in their corresponding URL:

| Service | Url             |
| ------- | --------------- |
| Kiali   | localhost:20001 |
| Grafana | localhost:3000  |

> ⚠️ Kiali must be running before running Grafana.

## Update the docker image

If you made changes to any services. You can build the new Docker image and push it to `antoinedespres/xxx-service` Docker registry:

```bash
docker build -t antoinedespres/simona-auth-service --push .
docker build -t antoinedespres/simona-housing-service --push .
docker build -t antoinedespres/simona-rental-service --push .
```

## Clean

If you need to delete all Kubernetes components, the simplest way is to reset Minikube:

```bash
minikube delete
minikube start --cpus=2 --memory=2000 --driver=docker
```

To make sure that Minikube has been reset, you can check if there is any deployments:

```bash
kubectl get deploy
```

You also need to reinstall `Istio`:

```bash
istioctl install --set profile=demo -y
kubectl label namespace default istio-injection=enabled
kubectl apply -f samples/addons
```

## Todo

- Add authentication to housing controller
- Fix docker images using `docker buildx build --platform linux/amd64 -t antoinedespres/simona-xxx-service --push .`
