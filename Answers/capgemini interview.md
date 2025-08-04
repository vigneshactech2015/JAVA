

Capegemini

1st round

\- Print the fibonacci number till 150 

\- print the prime number


**microservice questions**


**Q1)if you call from amazon microservice, get the 1000 json object with department and price**

**how to call it?**



&nbsp;  To call another microservice (like Amazon’s), you typically use REST API using a REST client like:



✅ Using RestTemplate (Old way): Synchronous (Blocking)



✅ Using WebClient (Modern, Reactive way): Async \& Reactive



WebClient webClient = WebClient.create("http://amazon-service");



List<Product> products = webClient.get()

&nbsp;   .uri("/api/products")

&nbsp;   .retrieve()

&nbsp;   .bodyToFlux(Product.class)

&nbsp;   .collectList()

&nbsp;   .block();



DTO - Data Transfer Object (It is a plain java class used to transfer and process data between microservices)



**Q2) if the get the response as json, how to get the departments?**


&nbsp;  After converting JSON to DTO, you can use Java Streams to filter, group, sum, and process data in a clean functional style.

Map<String, Double> priceByDept = products.stream()

&nbsp;   .collect(Collectors.groupingBy(

&nbsp;       ProductDTO::getDepartment,

&nbsp;       Collectors.summingDouble(ProductDTO::getPrice)

&nbsp;   ));





**Q3)@Autowired by type ,name in spring?**

@Autowired is used for **Dependency Injection** in Spring — it automatically wires a bean into another bean where it's needed.



Spring by **default** tries to match the **type** of the bean. If there are multiple beans of the same type, Spring then tries to match by variable name**(fallback)**.

✅ Best Practices:

Use @Qualifier("beanName") to explicitly specify the bean if multiple beans of the same type exist

&nbsp;

**Q4)How does Spring use CGLIB proxy with @Bean methods and configuration classes?**

	Without proxy, calling serviceB() inside serviceA() would create a new instance each time you call it, breaking the Singleton rule.

	When you mark a class with @Configuration, Spring creates a subclass (proxy) using CGLIB to enhance the behavior of @Bean methods.

	CGLIB = Code Generation Library

✅ With CGLIB Proxy:


Spring subclasses AppConfig at runtime



The subclass overrides serviceB()



If serviceB() is called multiple times, Spring returns the same singleton bean, not a new one


**🔴 Important Note:**

**If your method is:**



**private**



**static**



**final**



**Then Spring can’t override it, and CGLIB can’t intercept it → It will create a new instance (not Singleton).**



&nbsp;

**Q5) Difference Between Dynamic Proxy, JDK Proxy, and CGLIB Proxy ?

| Feature                   | \*\*JDK Dynamic Proxy\*\*                                        | \*\*CGLIB Proxy\*\*                                               |**

**| ------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------- |**

**| \*\*Based On\*\*              | Interfaces                                                   | Subclassing (extends original class)                          |**

**| \*\*Used When\*\*             | Target class implements an interface                         | Target class doesn't implement an interface                   |**

**| \*\*Required Inheritance?\*\* | No (just interface needed)                                   | Yes (CGLIB creates subclass)                                  |**

**| \*\*Limitations\*\*           | Can't proxy classes without interfaces                       | Can't proxy `final`, `private`, or `static` methods           |**

**| \*\*Performance\*\*           | Slightly faster for interfaces                               | Slightly slower (generates bytecode)                          |**

**| \*\*Used in Spring For\*\*    | `@Transactional`, `@Async`, etc. when interface is available | When no interface is present (e.g., `@Configuration` classes) |**

**| \*\*Dependency\*\*            | Built into Java SDK (`java.lang.reflect.Proxy`)              | External library (CGLIB, part of Spring core)                 |**





