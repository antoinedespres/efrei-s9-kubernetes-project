echo Grafana is run on localhost:3000
kubectl -n istio-system port-forward deployment/grafana 3000:3000