Accenture 



**Q1)what is different endpoints and their meaning ?**

&nbsp;	
   In REST APIs, endpoints are the **URLs** that define **operations on resources**. Each is tied to an HTTP method:

   GET , POST , PUT, DELETE , PATCH



**Q2)what is controller advice?**

	**@ControllerAdvice** is a special annotation in Spring Boot used to handle exceptions globally across all controllers.



💡 Simple Use Case:

Instead of writing try-catch in every controller, you can handle all exceptions in one place.


**@ControllerAdvice**

public class GlobalExceptionHandler {



&nbsp;   @ExceptionHandler(ResourceNotFoundException.class)

&nbsp;   public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {

&nbsp;       return ResponseEntity.status(HttpStatus.NOT\_FOUND).body(ex.getMessage());

&nbsp;   }



&nbsp;   @ExceptionHandler(Exception.class)

&nbsp;   public ResponseEntity<String> handleOtherErrors(Exception ex) {

&nbsp;       return ResponseEntity.status(HttpStatus.INTERNAL\_SERVER\_ERROR).body("Something went wrong");

&nbsp;   }

}







**Q3)What are annotations used in your project?

“**In my project, we use **@Component , @RestController, @Service, @Repository, @Autowired,** and validation annotations like **@Valid, @NotBlank, etc.,** to structure the app and secure endpoints**."**


**Q4)How to setup external server in our project?**

	You can set up and connect to external servers by configuring endpoints in **application.properties**, and deploying Spring Boot as a JAR or WAR on a server like Tomcat or a cloud VM.



**Q5)what core java features used in your project ?**

	"We use Java **Streams** and **Lambda expressions** for processing **collections**, exception handling with custom exception classes, and **generics** for reusable methods and type safety. Collections like **HashMap** and **ArrayList** are used in business logic. We also use **enums** to manage constants like roles or statuses."


**Q6)How to secure your endpoints?**

   In Spring Boot, you can secure your endpoints using **Spring Security**.

   For example:



&nbsp;  /admin/\*\* is only accessible to admin users



&nbsp;  /user/\*\* is accessible to normal users



&nbsp; We also use annotations like **@PreAuthorize("hasRole('ADMIN')")** to secure specific methods.



In some projects, we use JWT (JSON Web Token) to handle login and authentication without storing sessions. The client sends a token with each request, and the server verifies it to allow access."


**Q7)swap the string problem ?**

&nbsp;  

&nbsp; public String swapCharacters(String str, int i, int j) {

&nbsp;   char\[] chars = str.toCharArray();

&nbsp;   char temp = chars\[i];

&nbsp;   chars\[i] = chars\[j];

&nbsp;   chars\[j] = temp;

&nbsp;   return new String(chars);

&nbsp;  }

  swapCharacters("hello", 1, 3); // Output: "hlleo"

	**Swap two strings without using a third variable**

	String a = "Hello";

&nbsp;	String b = "World";



&nbsp;	// Step 1: Combine both

&nbsp;	a = a + b;        // a = "HelloWorld"



&nbsp;	// Step 2: Extract original b

&nbsp;	b = a.substring(0, a.length() - b.length()); // b = "Hello"



&nbsp;	// Step 3: Extract original a

&nbsp;	a = a.substring(b.length()); // a = "World"



&nbsp;	System.out.println("a: " + a); // World

&nbsp;	System.out.println("b: " + b); // Hello




**Q8)difference between controller and restcontroller?**

Both are **Spring MVC annotations,** but they behave slightly differently:



**Feature				@Controller			@RestController**

**Purpose**		Used for returning **views (HTML/JSP)**	Used for **REST APIs (JSON/XML response)**



**Response Type**	Returns a **view name (template)		Returns data directly (like JSON)**

**Requires 	@ResponseBody✅Yes(on each method)	❌ No, it's added automatically**

**Common Use	Web UI apps (Thymeleaf, JSP)		REST APIs (frontend talks to backend)**	


**Q9)What is the bean life cycle?

🔄 Bean Lifecycle Steps :**


**Instantiation –** Spring creates the object**.**



**Populate Properties – @Autowired, @Value**, etc., are set**.**



**BeanNameAware / BeanFactoryAware (Optional) –** If implemented, these callbacks are triggered**.**



**@PostConstruct** or InitializingBean **– Custom init logic runs.**



**✅ Bean is ready to use**



**Context is closed / Bean is removed**



**@PreDestroy or DisposableBean – Clean-up logic runs before destruction.

🧠 Summary:**

**The Spring container manages bean creation, initialization (@PostConstruct), and destruction (@PreDestroy).**


**Q11.what is preDestroy method?**

@PreDestroy is an annotation used in Spring to define cleanup logic before a bean is destroyed.

Use case : 

Closing database connections

Shutting down thread pools

**Q12.How to handle Global exception in springboot?**

In Spring Boot, you can handle all exceptions in a centralized way using @ControllerAdvice.

To handle exceptions in one place for the whole app

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {   
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Something went wrong");
    }
}


Use @ControllerAdvice and @ExceptionHandler to handle exceptions globally, and send proper responses for errors like 404 or 500.



**Q13.what will happen if we pass get endpoints with post request?**

If you try to call a GET endpoint using POST, Spring Boot will respond with a 405 Method Not Allowed error.


**Q14.what is the junit version used?**

Junit 5 for modern spring boot application and Junit 4 for older spring projects.



**Q15.If we are creating object as static that mean that is state less?**

Not always.
Just because an object or variable is declared static doesn’t guarantee that it's stateless.

🔍 What's the difference?
✅ Stateless means the object doesn’t hold any data specific to a user or session. It behaves the same every time it's used.

🔁 Static means there's only one instance of that variable or method across the whole application/class.

📌 Example:

public class MyService {
    static MyBean bean = new MyBean(); // static

    public void process() {
        // This may or may not be stateless
    }
}

If MyBean holds no user-specific or request-specific data, it can be stateless.
But if it stores data (like user info or request state), it is stateful, even if declared static.

✅ Summary:
Declaring something as static just means it's shared globally.
It’s stateless only if it doesn’t hold any changing or user-specific data.



