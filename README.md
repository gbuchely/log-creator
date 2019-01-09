# log-creator
Spring Boot Application to generate Logs using a Rest Controller

# commands to deploy on Minikube
eval $(minikube docker-env)
docker build -t log-creator:v1 .
kubectl run log-creator --image=log-creator:v1 --image-pull-policy=IfNotPresent
kubectl expose deployment log-creator --type=LoadBalancer --port=8080
minikube service log-creator
