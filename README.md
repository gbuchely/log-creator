# log-creator
Spring Boot Application to generate Logs using a Rest Controller

# Commands to deploy on Minikube Cluster
# Run with Administrator privileges

    eval $(minikube docker-env)
    gradle clean build
    docker build -t log-creator:v1 .
    kubectl run log-creator --image=log-creator:v1 --image-pull-policy=IfNotPresent
    kubectl expose deployment log-creator --type=LoadBalancer --port=8080
    minikube service log-creator

# Endpoints
    /test (GET)
    /message (POST) any string
    /bash (POST)
     
    [
        {
            "iterations" : 5,
            "delay" : 1000,
            "messages" : [
                "{\"key1\" : 0}",
                "{\"key2\" : \"value\"}"
            ]
        },
        {
            "iterations" : 3,
            "delay" : 2000,
            "messages" : [
                "{\"key3\" : -5}",
                "{\"key4\" : \"other value\"}"
            ]
        }
    ]
    
        
