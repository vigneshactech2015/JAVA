

**q1)What are the Stereotype exceptions?**

Stereotype annotations in Spring are used to **mark classes as components** for automatic detection and registration by Spring's container during component scanning.

🔍 Common Stereotype Annotations:

**Annotation	Description**


**@Component**	Generic stereotype for any Spring-managed bean

**@Service**	Marks a service class (business logic layer)

**@Repository**	Marks a DAO class; also enables Spring DataException translation

**@Controller**	Marks a web controller that returns views (used in MVC)

**@RestController**	Combines @Controller and @ResponseBody to return JSON/XML responses



**q2)If we have Postmapping and JPA level @Query(insert ) does this scenario will work?**

Yes, @PostMapping + @Query(insert) can work if @Modifying is used.

But for inserts, it’s better to use save() — it’s cleaner and handled by JPA automatically.



**Q3)Employee + Salary tables: how do we model this and what's the relation?**

Structure:



employees

---------

id | name



salary

---------

empid | salary


🧠 Relationship:

This is a **One-to-One relationship**:



One employee has one salary.



Salary is mapped to employee using empid (foreign key to employees.id)



✅ In JPA (Hibernate), here's how you model it:

Employee.java


**@Entity**

public class Employee {



&nbsp;   **@Id**

&nbsp;   private Long id;



&nbsp;   private String name;


&nbsp;   // Link to Salary

&nbsp;   **@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)** //cascade = CascadeType.ALL: Changes in Employee will also apply to Salary.

&nbsp;   private Salary salary;

}

Salary.java


@Entity

public class Salary {



&nbsp;   @Id

&nbsp;   private Long id;



&nbsp;   private Double salary;


    // Foreign key relationship to Employee

&nbsp;   **@OneToOne**

    **@JoinColumn(name = "empid")** //empid in salary table maps to employee.id

&nbsp;   private Employee employee;

}

🔍 What Hibernate does:

Maps the foreign key empid in salary to id in employee.



Handles join automatically when fetching employee or salary.



✅ Summary:

It’s a One-to-One mapping.

Use @OneToOne and @JoinColumn in JPA to map between employees and salary table.

Employee emp = employeeRepo.findById(1L).get();

Double empSalary = emp.getSalary().getSalary();




**Q4)How and where hibernate stores the cache?**
	
Hibernate supports **two levels of caching** to improve performance:

🧠 Level 1 Cache (Session Cache)

🧠 Level 2 Cache (SessionFactory Cache)


🧠 Level 1 Cache (Session Cache):


Feature	Details

Scope	**Per session** (enabled by **default**)

Storage	In-memory (inside the Hibernate Session)

Purpose	Avoids multiple DB hits for the same object within one session

Example	If you call session.get(Employee.class, 1L) twice, DB is hit only once.



Session session = sessionFactory.openSession();

Employee emp1 = session.get(Employee.class, 1L); // DB hit

Employee emp2 = session.get(Employee.class, 1L); // No DB hit - from cache



🧠 Level 2 Cache (SessionFactory Cache)


Feature			Details

Scope			**Across sessions**

Not enabled by default	You need to configure it manually

Providers		**EHCache**, Infinispan, **Redis**, etc.




**Q5)What is ORM framework and explain hibernate?**
	
ORM stands for Object-Relational Mapping.

It’s a technique that helps you map Java classes to database tables.

✅ Hibernate Features:


Feature	Description


@Entity				Maps class to a table

@Id, @GeneratedValue		Maps primary key

@OneToMany, @ManyToOne		Handles relationships

HQL(Hibernate Query Language)	SQL-like but object-oriented

Caching	Supports 		first and second-level caching

Auto DDL			Can auto-create or update DB schema


**Q6)What is the default ORM framework in springboot?** 

	Hibernate

Spring Boot uses Spring Data JPA, which is a wrapper over JPA (Java Persistence API).



By default, Hibernate is the JPA provider under the hood.



**Q7)Have u worked on multithreading?**

🔧 Example Use Cases:


Use Case			Tool Used


**Processing large records	ExecutorService,** ThreadPoolExecutor


**Parallel API calls		CompletableFuture,** ForkJoinPool


**Background tasks (e.g., email)	@Async** in Spring **+ @EnableAsync**


**Scheduled jobs			@Scheduled + ThreadPoolTaskScheduler**



**Q8)difference between interface and abstract class?**

Feature			Interface					Abstract Class
Purpose			Defines a contract				Provides partial implementation
Methods			Can have abstract + default, static methods	Can have abstract + concrete methods
Constructor		❌ No constructors				✅ Can have constructors
Multiple Inheritance	✅ Yes (a class can implement many interfaces)	❌ No (a class can extend only one abstract class)
Access Modifiers	Methods are public by default			Can have private/protected/public methods
Fields			Only public static final (constants)		Can have instance variables


**Q9)What is the features in java8?**

Feature				Description

Lambda Expressions		Enables writing anonymous functions — cleaner, shorter code

Functional Interfaces		Interfaces with a single abstract method (@FunctionalInterface)

Streams API			Process collections using map, filter, reduce in a functional style

Default & Static Methods	Interfaces can now have method implementations

Method References		A shorthand for calling methods using :: operator

Optional Class			Avoid NullPointerException by wrapping values in Optional

Date and Time API		New package java.time for better date/time handling

Nashorn JavaScript Engine	Allows running JavaScript inside Java (mostly removed in later versions)

Collectors & Parallel Streams	Easily collect, group, and parallelize data processing



