Capgemini



Output based question 1)    class TestClass {​​

&nbsp;   **protected** int x, y; 

}​​


class Main {​​

&nbsp;   public static void main(String args\[]) {​​

&nbsp;       TestClass t = new TestClass();

&nbsp;       System.out.println(t.x + " " + t.y); 

&nbsp;   }​​

}​​

t.x = ? 

t.y = ?

**Output : 0 0** 

​---------------

Output based question 2 ) Method overloading with null



&nbsp;   public class TestClass {​​

&nbsp;	
	public static void main(String\[] args) {​​

&nbsp;    		someMethod(**null**);

&nbsp;	}​​


	public static void someMethod(Object o) {​​

&nbsp;		System.out.println("Object method Invoked");

&nbsp;	}​​

&nbsp;	public static void someMethod(String s) {​​

&nbsp;		System.out.println("String method Invoked");

&nbsp;	}​	​


     }​

​

null is valid for both methods.



But Java chooses the most specific method available.



Since String is more specific than Object, it calls:

Output : **String method Invoked**



------------



**Q1)is it possible override final and provide methods?**



No, final methods cannot be overridden because their behavior is locked to prevent modification by subclasses.





**Q2)is it possible overload final and provide methods?**

Yes, you can overload a final method.



**Q3)difference between consumer , predicate and supplier?**

These are functional interfaces introduced in Java 8 under java.util.function package. They are used for writing lambda expressions and functional-style code.



**🔹 1. Consumer<T>**


**Takes input, returns nothing.**



Used for performing actions (like printing, saving, etc.)



**Consumer<String> printer = name -> System.out.println("Hello " + name);**

**printer.accept("Vignesh");  // Output: Hello Vignesh**


**🔹 2. Predicate<T>**


**Takes input, returns boolean.**



Used for filtering or condition checks.



**Predicate<Integer> isEven = num -> num % 2 == 0;**

**System.out.println(isEven.test(10));  // Output: true**


**🔹 3. Supplier<T>**


Takes no input, returns a value.



Used for lazy loading or generating values.



**Supplier<String> randomUUID = () -> UUID.randomUUID().toString();**

**System.out.println(randomUUID.get());**



**Q4)what is the use of default method in interface?**

Default methods allow you to provide method implementation in interfaces, enabling backward compatibility and code reuse in Java 8+.

interface Vehicle {

&nbsp;   void start();



&nbsp;   **default** void horn() {

&nbsp;       System.out.println("Beep Beep!");

&nbsp;   }

}



class Car implements Vehicle {

&nbsp;   public void start() {

&nbsp;       System.out.println("Car started");

&nbsp;   }

}



Car c = new Car();

c.start();  // Car started

c.horn();   // Beep Beep!





**Q5)Hashmap and internal working and new feature in java8?**

In Java 8, HashMap became more efficient with **tree-backed buckets** to handle **hash collisions**, improving performance from O(n) to O(log n) in worst cases.

Before Java 8 , HashMap was using LinkedList to handle hash collision , now only smaller bucket it uses Linkedinlist .


**Q6)What are collection used in your project?**

We used **Array List** for ordered collections like reports, **HashSet** for ensuring uniqueness (like IDs), **HashMap** for fast lookups (like caching configurations), and **Streams** for filtering/grouping data efficiently in service layers.



**Q7)How to disable embedded tomcat and plug in another server in Spring Boot?**

To disable embedded Tomcat:

You need to exclude the embedded Tomcat dependency from the starter:

<dependency>

&nbsp; <groupId>org.springframework.boot</groupId>

&nbsp; <artifactId>spring-boot-starter-web</artifactId>

&nbsp; **<exclusions>**

    **<exclusion>**

&nbsp;     <groupId>org.springframework.boot</groupId>

&nbsp;     <artifactId>spring-boot-starter-tomcat</artifactId>

&nbsp;   **</exclusion>**

  **</exclusions>**

</dependency>




**Q8)what is IOC?**

IoC (Inversion of Control) is a principle where the control of object creation and dependency management is shifted from the application code to the **Spring container**.





**Q9)Constructor and setter injection?**

Use constructor injection for required dependencies (recommended)



Use setter injection for optional or configurable ones

**Constructor Injection example : Immutable**

@Component

public class UserService {

&nbsp;   private **final** UserRepository repo;



&nbsp;   **@Autowired**

&nbsp;   public UserService(UserRepository repo) {

&nbsp;       this.repo = repo;

&nbsp;   }

}




**Setter Injection Example : Mutable**

@Component

public class UserService {

&nbsp;   private UserRepository repo;



&nbsp;   @Autowired

&nbsp;   public void setRepo(UserRepository repo) {

&nbsp;       this.repo = repo;

&nbsp;   }

}




**Q10)What is ORM framework?**

It is a technique that allows you to map Java objects (entities) to database tables, so you can interact with the database using Java code instead of SQL.


**Q11)What is difference between get() and load() in Hibernate?**

Both get() and load() are methods provided by Hibernate Session to **fetch an entity** from the database, but they behave differently.

| Feature                 | `get()`                                     | `load()`                                      |

| ----------------------- | ------------------------------------------- | --------------------------------------------- |

| \*\*When called\*\*         | Immediately hits the database (**eager** fetch) | Returns a proxy object, hits DB on demand     |

| \*\*Return if not found\*\* | Returns `null`                              | Throws `ObjectNotFoundException`              |

| \*\*Performance\*\*         | Slightly slower (fetches data immediately)  | Better for performance (**lazy** initialization)  |

| \*\*Use case\*\*            | When you \*\*need data right away\*\*           | When you may \*\*not use the data immediately\*\* |

| \*\*Proxy Object?\*\*       | ❌ No                                        | ✅ Yes                                         |





**Q12)What is API service or gateway?**

An API Gateway is the single entry for your microservices system, handling routing, authentication, rate-limiting, and more — simplifying the client’s interaction with multiple services.






