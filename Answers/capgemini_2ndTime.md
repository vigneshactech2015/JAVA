**Q1)What is the listener port in message queue ?**



A listener port is the entry point for your application to listen to a message queue. In Spring Boot, you often use @RabbitListener, @KafkaListener, or similar annotations instead of managing the port directly.



**Q2)Have u worked on file upload functionality in SPRING MVC ?**

File upload in Spring MVC is handled using the **Multipart File interface**. You can accept files in the controller, perform validations, and save to disk or remote storage.


**Q3)Have u working spring boot security ?**

Spring Security provides a flexible way to handle authentication, authorization, and session control.

I have implemented both session-based and token-based (JWT) security in real-time projects.


**Q4)Have u worked on message queue ?**

Yes, I have worked with message queues like RabbitMQ and Kafka for asynchronous communication between microservices.

**Q5)What is IOC and DI in spring boot ?**

🔹 IoC (Inversion of Control):

It's a design **principle** where the control of object creation and dependency management is given to the framework (Spring).



Instead of manually creating objects, Spring inverts the control and manages the lifecycle.



🔹 DI (Dependency Injection):

It's a design **pattern** used to achieve IoC.



Spring injects required dependencies (like services, repositories) into your classes automatically.




**Q6)How spring boot application starts ?**


1)main() method runs:

2)Spring Boot sets up everything . It creates and manages objects (beans)

3)Auto-configuration:

&nbsp; Spring Boot configures things like database, web server, etc., based on what’s in your project (like Spring Web, JPA, etc.)

4)Starts Embedded Server (like Tomcat)
5)App is ready

