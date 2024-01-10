echo Kiali is run on localhost:20001
kubectl -n istio-system port-forward deployment/kiali 20001:20001