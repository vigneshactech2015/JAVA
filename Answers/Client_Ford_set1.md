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

2\. what if we use final keyword for abstract class? can we use it?

3\. Spring MVC architecture

4\. How Controller class defines which services to be called in MVC?

5\. Services used in Micro services?

6\. Actuator?

7\. Heap memory and Stack memory?

8\. How to control Memory leakage?

9\. Bean Life cycle?

10\. Why dependency injection?

11\. types of Stream?

12\. Example of Function Interface and usage inn your project?

13\. Stages in Jenkin Ci / CD pipeline?

14\. API gateway usage?

15\. Profiles used in your project?

16\. How to generate credentials for your DB which is used in your project?

17\. Immutable class?

&nbsp;

&nbsp;Microservices

&nbsp;

Communicate between two microservice?

Rest template methods

12 factors in microservice

Load balancing in your application

Security used in your application

Optional keyword

Http request status types and uses

Post vs put

Scenario based questions like create a spring boot application on the mentioned scenario

OOPs concepts

Functional interface

String concepts0

AWS S3 (Added advantage)

Spring boot uses

Spring boot annotations

Angular basic concepts

Description about the project

&nbsp;

Springboot :

&nbsp;

Difference between spring \& Springboot , and its advantages

Real scenario with Agile, how it is used in project.

About Spring Security

DB Scenario based questions

Spring boot annotations

Spring boot auto wired

Two dimensional array – one dimensional array

&nbsp;Spring boot configurations and dependency basics

Configure Routes

Configure env files

Two way binding

How to handle http call

Observables

How to deploy an app

explain ur exp in spring boot

multi thread

JDBC connections

Connection pool \& DB

Performance improvement of query

how to handle in clause for 10k records in subquery

How to disable active session and how to check it in code, db

Test driven approach

Unit , integration testing

Validation in spring boot

Exception handling of those validations

Ur strength nd weakness

Questions related to previous projects 

Achievements 

Why microservices 

Cascading

Cassandra vs Rdb

Spring security

Java version 7 or 8 features

Difference between interface and abstract class

Advantages of Springboot and it's features

What are spring profiles

How did you configure the profiles

List few annotations in Springboot

How to connect to databases

What is springjpa

CI/CD configuration explanation in my project

How to check the code quality

Types of join queries

How to configure composite key

&nbsp;

Spring boot

Spring boot annotations in main file

Spring Boot vs spring MVC

3.authention n Authorization for resat services .  Oauth2 or any..

Db configuration

Get n load diff in jpa

FindById and get() method difference in spring jpa

How to use Profiles and what is its significance ?

Can you make a connection of 2 databases in a springboot application ?

What is RowMapper?

What are the different bean scopes available in SpringBoot ?

How does Spring Boot application starts ?

&nbsp;

&nbsp;Interview Questions:

&nbsp;

Self-Introduction

List Iterator \& Iterator difference

String, String Builder, String Tokenizer

Java 8 features

Functional interface 

Why we go for lambda expressions?

Why default methods?

Why Static methods?

Can we create static classes?

What are the dependency you have used in your project?

Difference between controller and rest controller?

What is @request Mapping?

What is @entity?

For primary key what kind of annotation can be used?

&nbsp;What is Foreign Key?

&nbsp;What is Composite key?

&nbsp;Angular parent to child communication?

&nbsp;Dependency injection in angular?

&nbsp;Observable \& subscribe?

&nbsp;What is Event Emitter?

&nbsp;Purpose of overriding concept in java?

Difference spring and spring-boot?

What is the use of micro-services?

Can you explain the flow of the SPA use case?

What is SPA?

How can you handle threads?

How do you communicate between services is microservice?

What are Object-Oriented principles?

What is runtime polymorphism in Java?

Explain the Java8 features?

What is the use of streams, explain with an example?



OAuth2 vs OPenID



About Angular :

&nbsp;

How to  start Angular application?

Modules

Director

Authentication and authorization

Default compilers

Routers

Angular authentication

Spring boot security

Stream Api Questions on stream methods

Angular routing

Questions about architecture of your project

Questions about handling security of your project

Angular directives

Component to component interaction

Angular hooks life cycle

Exception handling

Directives and any example of custom directive

Bootstrap process of application

Unit test case suit jasmi or krma script

&nbsp;

&nbsp;

Note - Expected to also have good understanding on OAuth2 flows and its implementation using spring-boot-security.

