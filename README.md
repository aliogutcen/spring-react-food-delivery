# spring-react-delivo
microservices architecture for food delivery app

### Overall Architecture
![Untitled-2023-04-03-2050](https://user-images.githubusercontent.com/85200452/231953283-6003f7a1-44ea-4200-af35-2f124e78d446.png)
# Our Project 
The system will consist of four main components:

Admin Panel: This component will be responsible for managing the onboarding process of Restaurant Owners and Delivery Partners. It will provide an interface for them to register and upload their details. The admin panel will also be responsible for managing the overall system, including monitoring orders, resolving conflicts, and handling payments.

Restaurant: This component will allow restaurant owners to add menus and manage orders. They will be able to create and edit menus, manage pricing and availability, and view order details. Restaurant owners will also be able to manage payments and invoices through the system.

Delivery Partners: This component will be responsible for picking up orders from restaurant owners and delivering them to customers. Delivery partners will be able to view and accept orders, navigate to the restaurant and customer locations, and update order status.

Customers: This component will allow customers to browse menus, place orders, and make payments. Customers will be able to view restaurant details, select items from menus, specify delivery addresses, and track the status of their orders.

To ensure scalability and performance, we will use a microservices architecture for the system. Each component will be developed as a separate service, with its own database and API. This approach will allow for easy scaling and flexibility in adding new features and components to the system.

To ensure security and reliability, we will implement appropriate authentication and authorization mechanisms, as well as data encryption and backup protocols. We will also perform regular system testing and monitoring to identify and resolve any issues before they can affect the system's performance and user experience.

Overall, by applying design principles and leveraging a microservices architecture, we will create a robust and scalable Online Food Delivery System that meets the needs of all stakeholders involved.
## Technologies
---
- Java 17
- Spring Boot 2.7.9
- Spring Security
- React
- Javascript
- Html/ Css
- Open API Documentation
- Spring Data JPA
- PostgreSQL
- MongoDB
- Jwt
- Apigateway
- Restful API
- Gradle
- Junit5
- Mockito
- Integration Tests
- RabbitMQ
- ElasticSearch
- Redis
