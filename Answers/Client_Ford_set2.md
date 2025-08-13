Java :



**1. Can an abstract class be declared final?**



❌ No, because:



abstract = meant to be extended.



final = cannot be extended.



Both contradict each other.



**2. For concatenation of strings, which method is good?**



Use StringBuilder (or StringBuffer if thread-safe) when doing multiple concatenations in loops.



Use + or concat() for simple cases.



**3. Does HashMap allow null value?**

 Yes



It allows one null key and multiple null values.



**4. Which statement is used to execute stored procedure?**

  Use **CallableStatement**:

CallableStatement stmt = con.prepareCall("{call myProcedure()}");





**5. What is the return type for executeQuery() method?**

It returns a **ResultSet** object.


**6. Can a final variable be declared inside a method?**

Yes, it becomes a local constant.


**7. What is the base class of all exceptions?**

java.lang.**Throwable**


**8. Can abstract class have non-abstract methods?**

Yes , Abstract class can have both abstract and concrete methods.



**9. Which modifier is used to prevent a method from being overridden?

final**


**10. Which of the following is not a Wrapper Class?**

In Java, a wrapper class is an object representation of a **primitive data type** .

Examples of wrapper classes: Integer, Double, Character, etc.



❌ String is not a wrapper class.


**11. If you are overriding equals() method of a class, what other methods you might need to override ?**

Also override hashCode()


**12. Which of the following variable can not be Serialized?**

**transient** 


**13. Which interface is used for getting ordered collection of Objects?**

List (like ArrayList, LinkedList) – maintains insertion order.



**14. Can there be an abstract class with no abstract methods in it?**

&nbsp;
Yes . You can mark a class abstract to **prevent instantiation** even if it has no abstract methods.

**15. What value does readLine() return when it has reached the end of a file?**

returns null


**16. When a thread blocks on I/O, what state does it enter?

 Blocked / Waiting** 





**17. Interface contains which methods?**

By default, **public abstract** methods.



Java 8+ allows default, static, and private methods too.


**18. Which interface is used to save the Object in a file?**



Serializable



**Spring Concepts :**


&nbsp;**1. What are the types of Dependency Injection Spring supports?**

Spring supports two types of Dependency Injection:



**Constructor Injection**



**Setter Injection**


 **2. How singleton bean initialized lazily?**

By default, singleton beans are created eagerly at context startup.

**@Lazy**

@Component

public class MyBean { }


 **3. Which Module in spring offers a meaningful exception hierarchy for managing the exception handling and error messages?**

Spring **DAO** (Data Access Object) module



Provides a meaningful exception hierarchy by wrapping exceptions like SQLException into DataAccessException.


&nbsp;4. Is Spring a Portable Application?

Yes

&nbsp;5. What are the exceptions thrown by the Spring DAO classes ?

Spring wraps all data access exceptions under:

DataAccessException (unchecked runtime exception)

	EmptyResultDataAccessException

	DuplicateKeyException

	IncorrectResultSizeDataAccessException



&nbsp;6. What are the types of the transaction management Spring supports ?

| Type                                       | Description                                                                                           |
| ------------------------------------------ | ----------------------------------------------------------------------------------------------------- |
| 1. **Programmatic Transaction Management** | You control transactions in code manually using `TransactionTemplate` or `PlatformTransactionManager` |
| 2. **Declarative Transaction Management**  | You declare transactions using annotations or XML — Spring handles it for you                         |




&nbsp;7. Which module of Spring is used for building Web applications?

Spring Web module

&nbsp;8. Which module in spring is used for managing the state between pages in a flow?

Spring Web Flow module

&nbsp;9. Which module provides context information to the Spring framework?

 Spring Context module :

	Provides ApplicationContext, event propagation, resource loading, internationalization, etc.

&nbsp;10. Which logging framework is used for providing logging support in Spring?

Commons Logging (Jakarta Commons Logging - JCL) by default .

11\. Does Spring Framework support Transaction context propagation across remote calls ?

No, transaction context does not propagate across remote calls (e.g., web service/RMI).
Use Saga Pattern or Distributed Transactions (JTA) if cross-service coordination is required.

12\. How do you configure Spring in a web application?

Define DispatcherServlet in web.xml (Spring MVC)

Or use @SpringBootApplication in Spring Boot

Load config using applicationContext.xml or Java Config

&nbsp;13. How do you configure your database driver in Spring?

via application.properties in Spring Boot.

&nbsp;14. How can you configure JNDI instead of datasource in Spring applicationcontext.xml?

<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    <property name="jndiName" value="java:comp/env/jdbc/MyDS"/>
</bean>

&nbsp;15. How do you define hibernate mapping file in Spring?

<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
    <property name="mappingResources">
        <list>
            <value>Employee.hbm.xml</value>
        </list>
    </property>
</bean>


&nbsp;16. List few Modules in Spring?

Spring Core

Spring Context

Spring Web

Spring MVC

Spring AOP

Spring DAO

Spring JDBC

Spring ORM

Spring Web Flow

Spring Security

Spring Boot (extension)

Webservices :

1.WSDL stands for?

WSDL = Web Services Description Language

It is an XML-based file used to describe:

What a web service does

Where it lives (URL)

How to call it (methods, input/output)

2.Can I access a web services from any application?

Yes, if:

The application supports web protocols like HTTP, SOAP, or REST

You have the correct endpoint and authentication (if needed)

3.What are the two types of Web Services?

SOAP Web Services (uses XML over HTTP)

RESTful Web Services (uses HTTP methods like GET, POST, etc.)

4. Which of the following is a directory service where enterprises register and search for web services?

UDDI (Universal Description, Discovery and Integration)

It acts like a “Yellow Pages” for web services.


5. Which of the following is used to perform remote procedure calls in web services?

SOAP (Simple Object Access Protocol)

It allows apps to call functions/methods over the internet.


6. What are the web service platform elements?

Three main platform elements:

SOAP – Message protocol

WSDL – Describes the service

UDDI – Directory of services


7. Which of the following is used to locate and describe web services?

WSDL


8.  In WSDL a <port> refers to

A <port> defines:

A binding (i.e., how to access)

A specific network address (i.e., where to access)

So, it's the actual endpoint of the web service.

9. Can I access a web services from any application?

YES . 

10. Is UDDI a registry and a repository ? 

True

Registry = Search services

Repository = Store metadata like WSDL files




