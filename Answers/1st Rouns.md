**Q1) How to provide the security related checked need to do in spring security?**

&nbsp;	

&nbsp;	

&nbsp;	In Spring Security, we handle security in three main ways:



1)Authentication – Verifies the user’s identity.

You can use form login, HTTP Basic, JWT tokens, or OAuth2.



2)Authorization – Controls access to resources.

Use annotations like @PreAuthorize("hasRole('ADMIN')") or define rules in your SecurityConfig class.



3)Input \& Data Protection –



Use @Valid for input validation.



Enable CSRF protection (enabled by default in Spring Security).



Prevent XSS and SQL Injection using ORM (like Hibernate) and proper output encoding.



http

&nbsp; .authorizeHttpRequests()

&nbsp; .requestMatchers("/admin/\*\*").hasRole("ADMIN")

&nbsp; .anyRequest().authenticated()

&nbsp; .and()

&nbsp; .formLogin();







**Q2) Internal working of spring batch?**



&nbsp;  	Spring Batch is a framework for processing large volumes of data in batches. It handles things like reading data, processing it, and writing the output, typically used in ETL jobs or scheduled data processing.



🔄 Internal Workflow:

Job – The entire batch process.



Step – Each job has one or more steps (like stages).



ItemReader – Reads data (e.g., from DB, file).



ItemProcessor – Processes/validates/transforms data.



ItemWriter – Writes data (e.g., to DB, file).







&nbsp;	@Bean

&nbsp;	public Step step() {

&nbsp;   		return stepBuilderFactory.get("step")

&nbsp;       	.<InputType, OutputType>chunk(100)

&nbsp;       	.reader(reader())

&nbsp;       	.processor(processor())

&nbsp;       	.writer(writer())

&nbsp;       	.build();

}



&nbsp;	



**Q3) How to make a list unique based on the 2 elements in list?**



List<Person> uniqueList = new ArrayList<>();

Set<String> seen = new HashSet<>();



for (Person person : people) {

&nbsp;   String key = person.getId() + "-" + person.getName();

&nbsp;   if (seen.add(key)) {

&nbsp;       uniqueList.add(person);

&nbsp;   }

}





**Q4)How to create the index and more than one field?**



&nbsp;	To create an index on more than one field (also called a composite index or multi-column index), you can use the SQL CREATE INDEX statement with multiple columns.





&nbsp;	CREATE INDEX idx\_name ON table\_name (column1, column2);





&nbsp;	Some DBs (like MongoDB) also support compound indexes:





&nbsp;	db.users.createIndex({ first\_name: 1, last\_name: 1 })



**Q5)soap vs Rest?**


&nbsp;	 SOAP (Simple Object Access Protocol)

Feature			SOAP				REST

Type			Protocol			It is not protocol , it is Architecture Style

Format			XML				JSON, XML, etc.

Speed			Slower (heavier)		Faster (lightweight)

Flexibility		Low (strict standards)		High (uses HTTP freely)

Best For		(Bank,telecom)			Public APIs, web/mobile apps







📦 Example: Used in enterprise apps like banking, telecom, where reliability and security are critical.



**Q6)What is options in rest?**

&nbsp;

&nbsp;   The OPTIONS method in REST is an HTTP method used to:



🔍 Ask the server what operations (HTTP methods) are allowed on a specific URL or resource.



&nbsp;  UseCase : CORS Preflight Requests : When browsers send cross-origin AJAX requests, they first use OPTIONS to ask the server for permissions.

&nbsp;	     Server replies with allowed methods, headers, etc.



**Q7)What are the ways to detect the loop in linked list?**



&nbsp;	There are two common ways to detect a loop (cycle) in a linked list:



&nbsp;	✅ 1. Floyd’s Cycle Detection Algorithm (Tortoise and Hare) -> Best approach

&nbsp;	Use two pointers:



&nbsp;	slow moves one node at a time



&nbsp;      fast moves two nodes at a time



If there's a loop, slow and fast will eventually meet.



🧾 Code Example:



public boolean hasLoop(Node head) {

&nbsp;   Node slow = head, fast = head;



&nbsp;   while (fast != null \&\& fast.next != null) {

&nbsp;       slow = slow.next;

&nbsp;       fast = fast.next.next;



&nbsp;       if (slow == fast) return true; // Loop detected

&nbsp;   }



&nbsp;   return false; // No loop

}

✅ Efficient:



Time: O(n)



Space: O(1)





**Q8)What are the design pattern you know?**



&nbsp;	✅ 1. Creational Patterns (Object creation)
	✅ 2. Structural Patterns (Class and object composition)

&nbsp;	✅ 3. Behavioural Patterns (Object interaction \& responsibility)

🧠 Real-World Java Usage Examples:


Pattern		Real Java Example							Pattern


Singleton	Runtime.getRuntime(), Spring Beans					Creational

Factory		DocumentBuilderFactory.newInstance()					Creational

Builder		StringBuilder, Lombok @Builder						Creational

Proxy		Spring AOP, Hibernate lazy loading					Structural

Observer	PropertyChangeListener, event listeners (pub - sub model)		Behavioural

Strategy	Comparator, Spring's RestTemplate customization				Behavioural





&nbsp;

