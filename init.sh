kubectl create configmap db-init-scripts --from-file=./db/init-database.sql
kubectl apply -f .