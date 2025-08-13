&nbsp;

Core Java questions


**1. What is the difference between final, finally \& finalize ?**



| Keyword    | Meaning                                                                          |

| ---------- | -------------------------------------------------------------------------------- |

| `final`    | Used to \*\*declare constants\*\*, prevent \*\*inheritance\*\*, or \*\*method overriding\*\* |

| `finally`  | A block in exception handling that \*\*always executes\*\*                           |

| `finalize` | A method called by JVM \*\*before garbage collection\*\* (deprecated now) 
  		 Cleanup method (not recommended for use anymore)





**2. Can we overload static methods, Explain with Example?**
	
   Yes overload is allowed. But overriding static methods is not allowed because they belong to the class, not the object.


**3. Difference between static binding \& dynamic binding ?**

| Feature       | \*\*Static Binding\*\*                             | \*\*Dynamic Binding\*\*                            |

| ------------- | ---------------------------------------------- | ---------------------------------------------- |

| Also Known As | Early Binding                                  | Late Binding                                   |

| Happens At    | \*\*Compile Time\*\*                               | \*\*Runtime\*\*                                    |

| Applied To    | \*\*Static\*\*, \*\*private\*\*, and \*\*final\*\* methods | \*\*Overridden methods\*\* (non-static, non-final) |

| Decided By    | Compiler                                       | JVM (at runtime)                               |




**4. Difference between List \& Set ?**

| Feature             | \*\*List\*\*                     | \*\*Set\*\*                                      |

| ------------------- | ---------------------------- | -------------------------------------------- |

| \*\*Order\*\*           | Maintains insertion order    | No guaranteed order (except `LinkedHashSet`) |

| \*\*Duplicates\*\*      | Allows duplicate elements    | Does \*\*not\*\* allow duplicates                |

| \*\*Access\*\*          | Can access elements by index | No index-based access                        |

| \*\*Implementations\*\* | `ArrayList`, `LinkedList`    | `HashSet`, `LinkedHashSet`, `TreeSet`        |



**5. Difference between Exceptions \& Error?**

| Feature         | \*\*Exception\*\*                                         | \*\*Error\*\*                                 |

| --------------- | ----------------------------------------------------- | ----------------------------------------- |

| \*\*Definition\*\*  | Problems that occur during program execution          | Serious problems mostly caused by the JVM |

| \*\*Can Handle?\*\* | Yes, you can catch and handle it                      | No, should not try to handle it           |

| \*\*Examples\*\*    | `NullPointerException`, `IOException`, `SQLException` | `OutOfMemoryError`, `StackOverflowError`  |

| \*\*Caused By\*\*   | Programmer mistakes, invalid input                    | System failures, memory issues            |

Exceptions are recoverable → you should catch them



Errors are not recoverable → you should let the JVM handle them



**6. What are Checked \& Unchecked Exception ?**

🔹 Checked Exceptions:

Checked at compile-time



You must handle them using try-catch or throws



Represent recoverable issues (e.g., file not found)



Examples:

IOException, SQLException, ParseException

🔹 Unchecked Exceptions:

Checked at runtime



You’re not forced to handle them



Usually due to programming errors



Examples:

NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException





**7. What is co-variant return type ?**

Co-variant return type allows an overriding method to return a more specific type than the one declared in the parent class.


🔹 Before Java 5:

Return type must be exactly same in parent and child.



🔹 From Java 5 onwards:

You can return a subtype (child class) in the overridden method.

**8. Suppose if Parent class is throwing an Exception, What exception a child can throw ?**

If a parent class method throws a checked exception, then the child class overriding method:



✅ Can throw the same exception

✅ Or throw a subclass of that exception

❌ Cannot throw a broader (new) checked exception

✅ Allowed:

class Parent {

&nbsp;   void show() throws IOException {

&nbsp;       // some code

&nbsp;   }

}



class Child extends Parent {

&nbsp;   @Override

&nbsp;   void show() throws FileNotFoundException { // Allowed (subclass of IOException)

&nbsp;       // some code

&nbsp;   }

}



❌ Not Allowed:

class Child extends Parent {

&nbsp;   @Override

&nbsp;   void show() throws Exception { // ❌ Error: broader checked exception

&nbsp;       // not allowed

&nbsp;   }

}


Child class can only throw the same or narrower checked exception.

**Unchecked exceptions have no such rules.**


**9. What is Compile Time \& Runtime Exception ?**

   Checked (Compile time) 

   Unchecked (Runtime)


**10. At what condition you need to handle the exception, explain with example ?**

      You should handle exceptions when the error is **recoverable**, and you want your program to continue running gracefully or show a friendly message to the user.


**11. Java 8 concepts**

Java 8 focuses on functional programming, cleaner collection handling(using streams), and better date/time APIs.


**12. Functional interfaces and its usage**

A functional interface is an interface with **only one abstract method(So that lambda expressions can be used unambiguously)**.

It can have multiple default or static methods, but only one abstract method.

@FunctionalInterface

interface Calculator {

&nbsp;   int operate(int a, int b);

}

Calculator add = (a, b) -> a + b;

System.out.println(add.operate(5, 3)); // 8



**13. Lambda expression**

Same as previous answer


**14. Filter list of emp whose salary  greater than 50k in Java 8**

class Employee {

&nbsp;   String name;

&nbsp;   double salary;



&nbsp;   Employee(String name, double salary) {

&nbsp;       this.name = name;

&nbsp;       this.salary = salary;

&nbsp;   }



&nbsp;   public double getSalary() {

&nbsp;       return salary;

&nbsp;   }



&nbsp;   public String getName() {

&nbsp;       return name;

&nbsp;   }



&nbsp;   @Override

&nbsp;   public String toString() {

&nbsp;       return name + " - ₹" + salary;

&nbsp;   }

}

List<Employee> employees = Arrays.asList(

&nbsp;   new Employee("Vignesh", 60000),

&nbsp;   new Employee("Raj", 45000),

&nbsp;   new Employee("Priya", 75000)

);



List<Employee> filtered = employees.stream()

&nbsp;   .filter(emp -> emp.getSalary() > 50000)

&nbsp;   .collect(Collectors.toList());



filtered.forEach(System.out::println);





**15. Exception handling and hash map internal functionality in Java 8 ?**

Java 8 didn’t change the core of exception handling (try-catch-finally), but combined it with functional style using Optional, lambdas, and streams.

List<String> values = Arrays.asList("10", "20", "abc", "30");



values.stream().forEach(val -> {

&nbsp;   try {

&nbsp;       int num = Integer.parseInt(val);

&nbsp;       System.out.println(num);

&nbsp;   } catch (NumberFormatException e) {

&nbsp;       System.out.println("Invalid: " + val);

&nbsp;   }

});



Java 8 introduced balanced trees (Red-Black Tree) for buckets with many collisions.



If a bucket has > 8 entries, and the overall map size is > 64, the bucket converts from LinkedList to Tree for faster lookup.



**16. Comparator and comparable**

| Feature            | \*\*Comparable\*\*                    | \*\*Comparator\*\* -External Sorting   |

| ------------------ | --------------------------------- | ---------------------------------- |

| \*\*Package\*\*        | `java.lang`                       | `java.util`                        |

| \*\*Purpose\*\*        | Defines \*\*natural ordering\*\*      | Defines \*\*custom ordering\*\*        |

| \*\*Method\*\*         | `compareTo(Object o)`             | `compare(Object o1, Object o2)`    |

| \*\*Used on\*\*        | Implemented by the class itself   | Passed as external class or lambda |

| \*\*Changes Needed\*\* | Requires modifying original class | No need to modify original class   |



🔹 Comparable Example (Natural Order):

class Student **implements Comparable**<Student> {

&nbsp;   int age;

&nbsp;   Student(int age) { this.age = age; }



    **@Override**

&nbsp;   public int **compareTo**(Student s) {

&nbsp;       return this.age - s.age;

&nbsp;   }

}

Collections.sort(studentList);


🔹 Comparator Example (Custom Order):


class Student {

&nbsp;   int age;

&nbsp;   Student(int age) { this.age = age; }

}



**Comparator**<Student> ageComparator = (s1, s2) -> s1.age - s2.age;

Collections.sort(studentList, **ageComparator**);





17\. Singleton class And string immutable concept

A Singleton ensures that only one instance of a class is created throughout the application.


class Singleton {

&nbsp;   private static Singleton instance;



&nbsp;   private Singleton() {} // private constructor



&nbsp;   public static Singleton getInstance() {

&nbsp;       if (instance == null) {

&nbsp;           instance = new Singleton();

&nbsp;       }

&nbsp;       return instance;

&nbsp;   }

}


In Java, String is immutable – once created, its value cannot be changed.


String s = "Hello";

s.concat(" World");

System.out.println(s); // Still prints "Hello"

Why String is Immutable?


Security (used in class loaders, file paths)



Thread-safety without synchronization



String Pooling (reuse of string literals)



Caching of hashcode (used in collections like HashMap)




18\. Java basics on collections(concurrent hash map)

&nbsp;

ConcurrentHashMap is a thread-safe alternative to HashMap.

It allows multiple threads to read and limited threads to write without locking the entire map.

 Key Features:


✅ Thread-safe for read/write operations



✅ Allows concurrent access without synchronized



✅ Uses bucket-level locking (a.k.a. lock stripping)



❌ Null keys/values not allowed

ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();



map.put("A", 1);

map.put("B", 2);



map.forEach((k, v) -> System.out.println(k + " -> " + v));



 

SQL questions

1\. Write a query to find the count of all the employees who belongs to city 'X' ?

2\. Write a query to find the count of all the employees with the city 'X' ?

&nbsp;

1\. String builder vs String buffer?

| Feature         | `StringBuilder`                      | `StringBuffer`                         |
| --------------- | ------------------------------------ | -------------------------------------- |
| **Thread-safe** | ❌ No                                | ✅ Yes                                |
| **Performance** | ✅ Faster (no overhead of sync)      | ⚠️ Slower (because of synchronization)|
| **Use Case**    | Use in **single-threaded** scenarios | Use in **multi-threaded** scenarios    |




2\. what if we use final keyword for abstract class? can we use it?

❌ No, we cannot use final with an abstract class.
Because their purposes contradict each other:

abstract ➝ Meant to be extended (incomplete implementation).

final ➝ Meant to prevent extension (cannot be inherited).

3\. Spring MVC architecture

Spring MVC cleanly separates presentation, business, and data access layers for modular and testable web applications.

4\. How Controller class defines which services to be called in MVC?

The controller calls services using injected objects (@Autowired).
It is the developer’s job to route the correct service methods based on the request.

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Employee emp = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(emp);
    }
}


5\. Services used in Micro services?

Each microservice handles a specific responsibility, communicates via REST APIs or messaging queues, and can be deployed independently.


6\. Actuator?

Spring Boot Actuator is a production-ready tool that provides insight into the internal state of a Spring Boot application.

Actuator gives built-in monitoring, health checks, and metrics to help you manage your app in production.

7\. Heap memory and Stack memory?

| Aspect                | **Heap Memory**                        | **Stack Memory**                           |
| --------------------- | -------------------------------------- | ------------------------------------------ |
| **Used for**          | Storing objects and instance variables | Storing method calls and local variables   |
| **Access Speed**      | Slower                                 | Faster                                     |
| **Size**              | Larger                                 | Smaller                                    |
| **Memory Type**       | Shared across all threads              | One per thread                             |
| **GC Involvement**    | Yes, garbage collected                 | No, cleared automatically when method ends |
| **Error on overflow** | `OutOfMemoryError`                     | `StackOverflowError`                       |


public class Example {
    int instanceVar = 5;     // Stored in Heap

    public void method() {
        int localVar = 10;   // Stored in Stack
    }
}


8\. How to control Memory leakage?

| Technique                                 | Description                                                      |
| ----------------------------------------- | ---------------------------------------------------------------- |
| **Use `WeakReference`**                   | Prevent strong references from holding unused objects            |
| **Avoid static references**               | Don’t store large objects in static fields                       |
| **Remove unused listeners**               | Unregister listeners in GUI or event-based apps                  |
| **Close resources**                       | Always close DB, file, socket connections (`try-with-resources`) |
| **Use memory profilers**                  | Tools like VisualVM, JProfiler, Eclipse MAT                      |
| **Avoid large object caches**             | Clear caches periodically or use eviction strategies             |
| **Use `finally` or `try-with-resources`** | Proper resource cleanup                                          |


9\. Bean Life cycle?

Constructor → Dependency Injection → @PostConstruct → Bean Ready → @PreDestroy → GC

10\. Why dependency injection?

Dependency Injection is a design pattern where the object’s dependencies are provided (injected) by the framework instead of being created manually.

| Benefit                       | Explanation                                                        |
| ----------------------------  | -----------------------------------------------------------------  |
| ✅ **Loose Coupling**         | Classes are not tightly bound to their dependencies               |
| ✅ **Easier Testing**         | You can mock dependencies easily                                  |
| ✅ **Code Reusability**       | Swap one implementation with another (e.g., in-memory vs DB repo) |
| ✅ **Centralized Config**     | All objects managed by Spring’s IoC container                     |
| ✅ **Better Maintainability** | Easier to understand and change logic with minimal impact         |


11\. types of Stream?

🔹 1. Sequential Stream

Processes elements one after another (single-threaded).

Default type when you call .stream().

List<String> names = List.of("A", "B", "C");
names.stream().forEach(System.out::println);

🔹 2. Parallel Stream

Splits the stream into multiple threads and processes in parallel.

Useful for large datasets and CPU-intensive tasks.

List<String> names = List.of("A", "B", "C");
names.parallelStream().forEach(System.out::println);


12\. Example of Function Interface and usage in your project?

An interface with only one abstract method (can have default or static methods too).
Used primarily with lambda expressions and method references in Java 8.

Functional interfaces help simplify your code using lambdas, and are widely used in Streams, event handling, and custom logic injection.


13\. Stages in Jenkins Ci / CD pipeline?

Jenkins CI/CD pipeline consists of stages like checkout, build, test, package, and deploy to fully automate the software delivery process.

14\. API gateway usage?

An API Gateway is a single entry point for all client requests to microservices in a distributed system.

15\. Profiles used in your project?

Spring profiles allow your app to behave differently in dev/test/prod without changing code — just by switching config.

16\. How to generate credentials for your DB which is used in your project?

You can generate and manage DB credentials using Spring profiles, env variables, CI/CD secrets, or secret managers — never hardcode them directly in code.

17\. Immutable class?

An immutable class is a class whose objects cannot be modified once they are created.

The most common example is:
✅ String in Java is immutable.

🔹 Why Use Immutable Classes?

✅ Thread-safe by default (no synchronization needed)

✅ Predictable and reliable

✅ Useful in multithreading, caching, and keys in collections



&nbsp;

&nbsp;Microservices

&nbsp;

Q1)Communicate between two microservice?

i)Synchronous - via REST API using:

RestTemplate (legacy)

WebClient (non-blocking, recommended)

ii)Asynchronous - via Message Queues:

  RabbitMQ, Kafka, etc.

Q2)Rest template methods ?


| Method                                         | Description                                     |
| ---------------------------------------------- | ----------------------------------------------- |
| `getForObject(url, class)`                     | Retrieves response body directly                |
| `getForEntity(url, class)`                     | Retrieves full response (headers, status, body) |
| `postForObject(url, request, class)`           | Sends POST request, returns response body       |
| `postForEntity(url, request, class)`           | Sends POST request, returns full response       |
| `put(url, request)`                            | Sends PUT request (no return)                   |
| `delete(url)`                                  | Sends DELETE request                            |
| `exchange(url, method, request, responseType)` | Fully customizable call (all HTTP methods)      |


Q3)12 factors in microservice

| Factor                     | Meaning                                                           |
| -------------------------- | ----------------------------------------------------------------- |
| **1. Codebase**            | One codebase per app, tracked in version control (e.g., Git)      |
| **2. Dependencies**        | Declare dependencies explicitly (e.g., `pom.xml`, `build.gradle`) |
| **3. Config**              | Store config in environment variables, not in code                |
| **4. Backing services**    | Treat services like DB, cache as attached resources               |
| **5. Build, release, run** | Separate build, release, and run stages                           |
| **6. Processes**           | App runs as one or more stateless processes                       |
| **7. Port binding**        | App should self-host using port (e.g., Spring Boot runs on 8080)  |
| **8. Concurrency**         | Scale out via process/model replication                           |
| **9. Disposability**       | Fast startup and graceful shutdown                                |
| **10. Dev/prod parity**    | Keep development and production as similar as possible            |
| **11. Logs**               | Treat logs as event streams — don't manage log files manually     |
| **12. Admin processes**    | Run one-off admin tasks (e.g., DB migrations) separately          |


Q4)Load balancing in your application

Load balancing distributes incoming network traffic across multiple instances of your service to ensure high availability and reliability.


| Type            | Example Tool               | Description                                                |
| --------------- | -------------------------- | ---------------------------------------------------------- |
| **Client-side** | Spring Cloud LoadBalancer  | Logic is inside the client (e.g., chooses instance itself) |
| **Server-side** | AWS ELB, NGINX, HAProxy    | External component handles routing to instances            |
| **API Gateway** | Spring Cloud Gateway, Zuul | Can also perform load balancing behind the scenes          |


Q5)Security used in your application ?

Security in Spring Boot includes authentication (JWT), authorization, HTTPS, validation, and method-level protection. JWT is preferred for stateless microservices.

Q6)Optional keyword in java ?

Optional is a container object introduced in Java 8 that may or may not contain a non-null value — helps avoid NullPointerException.


Q7)Post vs put

| Feature        | `POST`                                    | `PUT`                                       |
| -------------- | ----------------------------------------- | ------------------------------------------- |
| **Purpose**    | Create a new resource                     | Update/replace an existing resource         |
| **Idempotent** | ❌ No – Multiple calls create duplicates  | ✅ Yes – Multiple calls result in same state |
| **URL Format** | `/users`                                  | `/users/{id}`                               |
| **Usage**      | Used when the server **generates** the ID | Used when the **client knows** the ID       |



Q8)String concepts

| Concept                               | Description                                                   |
| ------------------------------------- | ------------------------------------------------------------- |
| **Immutable**                         | Strings cannot be changed after creation                      |
| **String Pool**                       | Java stores strings in a pool to reuse memory                 |
| **`equals()` vs `==`**                | `equals()` compares values, `==` compares references          |
| **`StringBuilder` vs `StringBuffer`** | Mutable versions of string, better for concatenation          |
| **Concatenation**                     | `+` or `.concat()` are commonly used                          |
| **Common Methods**                    | `length()`, `substring()`, `indexOf()`, `toUpperCase()`, etc. |





&nbsp;

Springboot :

&nbsp;

1 dimensional array :

int[] arr = {1, 2, 3, 4, 5};
System.out.println(arr[2]); // Output: 3

2 dimensional array : 

int[][] matrix = {
  {1, 2},
  {3, 4}
};
System.out.println(matrix[1][0]); // Output: 3

🔹What is a Connection Pool?

A Connection Pool is a cache of database connections maintained so connections can be reused, rather than opened and closed repeatedly.

Spring Boot auto-configures HikariCP by default for optimal performance.

🔹Performance Improvement of a Query ?

Improve query performance by indexing, fetching only needed data, avoiding unnecessary joins, and using pagination for large datasets.


How to Handle IN Clause for 10K Records in Subquery ?

🔹 Problem:
Using IN (...) with very large sets (like 10,000 IDs) can:

Slow down queries

Cause memory/CPU issues

Hit query length limits in some DBs

🔹 Solutions:

✅ 1. Use a Temporary Table

Insert large list of values into a temporary or staging table

Then use a JOIN instead of IN

-- Assume temp_ids has 10k emp IDs
SELECT * 
FROM employees e
JOIN temp_ids t ON e.emp_id = t.emp_id;


How to disable active session and how to check it in code/DB?

🔹 1. Disabling or Invalidating a Session in Code (Spring Boot)
To manually expire a session, use:

// In controller or service
request.getSession().invalidate();


🔹 2. Session Timeout in application.properties

server.servlet.session.timeout=15m



✅ What is Cascading in Hibernate / JPA?

🔹 Real-Life Analogy:
If you delete a folder, all files inside it are also deleted. That’s cascade delete.



@Entity
public class Employee {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}


Now, when you persist, remove, or merge Employee, those actions will also apply to Address.

Cascading is a feature in JPA/Hibernate that lets you automatically propagate operations (like persist, remove, merge) from a parent entity to its related child entities.


&nbsp;

Spring boot :

✅1) Get and load difference in jpa ?

| Aspect                | `get()`                              | `load()`                             |
| --------------------- | ------------------------------------ | ------------------------------------ |
| **Immediate vs Lazy** | `get()` loads the entity immediately | `load()` returns a proxy (lazy load) |
| **If Not Found**      | Returns `null`                       | Throws `ObjectNotFoundException`     |
| **Use Case**          | When you want the actual object      | When you just need a reference       |


2) FindById and get() method difference in spring jpa

| Feature       | `findById()`                | `get()`                            |
| ------------- | --------------------------- | ---------------------------------- |
| Belongs to    | Spring Data Repository      | Hibernate Session                  |
| Return type   | `Optional<T>`               | Entity object or `null`            |
| Null Handling | Encourages safe null checks | Directly returns `null`            |
| Lazy loading  | No                          | No (for `get()`), yes for `load()` |


Use findById() in Spring JPA for safer null handling via Optional.

Use get() only if you're directly dealing with Hibernate’s Session.

3) How to use Profiles and what is its significance ?


Profiles allow you to switch environments easily, keeping code clean and configurations isolated. They're essential for real-world, multi-environment applications.


4)Can you make a connection of 2 databases in a springboot application ?

You can connect to multiple databases in Spring Boot by defining separate data source beans and configuration classes. Just be sure to separate JPA repositories and entities accordingly.


5)What is RowMapper?

RowMapper is used to convert a row from the DB into a Java object when using plain SQL with JdbcTemplate. It avoids boilerplate and gives full control over mapping.

6)What are the different bean scopes available in SpringBoot ?

In Spring, bean scope determines how long a bean lives and how it's created or shared.

| Scope         | Description                                                       |
| ------------- | ----------------------------------------------------------------- |
| `singleton`   | **(Default)** One shared instance per Spring container            |
| `prototype`   | A **new instance** every time it's requested                      |
| `request`     | One instance per **HTTP request** – only for web apps             |
| `session`     | One instance per **HTTP session** – only for web apps             |
| `application` | One instance per **ServletContext** – for entire web app          |
| `websocket`   | One instance per **WebSocket session** – for STOMP/WebSocket apps |


@Component
@Scope("prototype")
public class MyBean {
    public MyBean() {
        System.out.println("New instance created");
    }
}


7)How does Spring Boot application starts ?

Spring Boot simplifies app startup by auto-configuring, starting an embedded server, and managing beans using annotations – all from just one main() method.

&nbsp;

&nbsp;Interview Questions:

&nbsp;


List Iterator & Iterator difference ?

Both Iterator and ListIterator are used to iterate over collections, but there are key differences in functionality and usage.

| Feature                | `Iterator`               | `ListIterator`                        |
| ---------------------- | ------------------------ | ------------------------------------- |
| Applicable to          | All **Collection** types | Only **List** types                   |
| Direction of Traversal | **Forward only**         | **Both forward and backward**         |
| Modify Elements        | Can **remove()** only    | Can **add(), remove(), and set()**    |
| Get index of elements  | ❌ Not supported          | ✅ `nextIndex()` and `previousIndex()` |
| Supports `add()`       | ❌ No                     | ✅ Yes                                 |
| Supports `set()`       | ❌ No                     | ✅ Yes                                 |


String, String Builder, String Tokenizer ? 

Use String for simple string values.

Use StringBuilder for heavy modification (loops, appends).

Use StringTokenizer or String.split() to break a string into parts.


Why Static methods?

Static methods belong to the class, not to instances (objects). You don’t need to create an object to call them.


Can we create static classes?


🔹 Top-level static class? ❌ No


🔹 Static nested class? ✅ Yes


