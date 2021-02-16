#Prerequisitos
Instala primero rabitmq en tu entorno de desarrollo

### Feature rabbitmq documentation

- [Micronaut RabbitMQ Messaging documentation](https://micronaut-projects.github.io/micronaut-rabbitmq/latest/guide/index.html)

###Crea en rabbitmq un exchange llamado
skydropx.demo

###Crea dos queue
order-queue
shipment-queue

###Bindea las respectivas colas a el exchange nombralas order y shipment respectivamente

###Puntos a tomar encuenta
. El user y password seteados en el proyecto son los default guest guest
. La url de rabit es la default amqp://localhost:5672
. si gustas modificarlo editalo en aplication.yaml tanto para el api a como para el api b

## Correr los test api b
```
./gradlew clean test

```

## Iniciar las api a y b
```
cd aApi ... cd bApi
./gradlew clean run

```

## Probar envio de ordenes fedex atravez de las apis

```
curl -i -X GET \
 'http://localhost:8080/order/fedex/send'
```