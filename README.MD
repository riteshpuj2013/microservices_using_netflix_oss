Here are the details about the assignment:
Core Rest Web Services:
1. Product Service (Spring Boot)
2. Price Service (Spring Boot)

Composite Service:
3. Product Proxy Service (Spring Boot)

Support Infrastructure:
4. Service Discovery App (Spring Boot Netflix Eureka)

To check the list of active applications in the Service Discovery Service:
curl -s -H "Accept: application/json" http://localhost:8761/eureka/apps | json_pp

Start Service Discover App:
cd discovery-server; mvn spring-boot:run

Start Product Service:
cd product_service; mvn spring-boot:run

Start Price Service:
cd product_service; mvn spring-boot:run

Start Product_Proxy Service:
cd product_service; mvn spring-boot:run

Call Get API of Product_Proxy Service Using Swagger:
http://localhost:8080/swagger-ui.html#!/product45controller/getProductUsingGET

Output:
{
"id": 1,
"name": "Mouse",
"category": "Computer Accessories",
"price": 400,
"currency": "INR"
}

Load Balancing:
1. Start two instances of Product Service using the command above. The service will automatically use the available port in the system.
2. Check http://localhost:8761/ - It should show two instances of Product Service.
3. Call Product Proxy Service. Check logs, the call to Product service will get load balanced because we use Netflix Ribbon Load Balancer.

Monitoring:
1. Check http://localhost:8761/
2. The dashboards displays which applications are live.

