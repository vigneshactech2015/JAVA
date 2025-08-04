

**Q1. What is Constructor Chaining in Java?**



  **Constructor chaining means calling one constructor from another within the same class or from the parent class.**



**🔄 Two types:**


**Type			How it's done**


**Within same class	Using this()**

**From parent class	Using super()**





**Within same class**

public class User {

&nbsp;   User() {

&nbsp;       this("Vignesh"); // calling parameterized constructor

&nbsp;       System.out.println("Default constructor");

&nbsp;   }



&nbsp;   User(String name) {

&nbsp;       System.out.println("Hello, " + name);

&nbsp;   }



&nbsp;   public static void main(String\[] args) {

&nbsp;       new User();

&nbsp;   }

}


OUTPUT:

Hello, Vignesh

Default constructor


**Constructor Chaining using super()**

class Person {

&nbsp;   Person() {

&nbsp;       System.out.println("Person class constructor");

&nbsp;   }



&nbsp;   Person(String name) {

&nbsp;       System.out.println("Person name: " + name);

&nbsp;   }

}



class Employee extends Person {

&nbsp;   Employee() {

&nbsp;       super("Vignesh"); // calls Person(String name)

&nbsp;       System.out.println("Employee constructor");

&nbsp;   }

}



public class Main {

&nbsp;   public static void main(String\[] args) {

&nbsp;       new Employee();

&nbsp;   }

}



OUTPUT :

Person name: Vignesh

Employee constructor





**Q2)can we overload the constructor?**

  Yes, constructors can be overloaded in Java. It helps in creating flexible object initialization.

public class Book {

&nbsp;   Book() {

&nbsp;       System.out.println("Default constructor");

&nbsp;   }



&nbsp;   Book(String title) {

&nbsp;       System.out.println("Book title: " + title);

&nbsp;   }



&nbsp;   Book(String title, int pages) {

&nbsp;       System.out.println("Book: " + title + ", Pages: " + pages);

&nbsp;   }



&nbsp;   public static void main(String\[] args) {

&nbsp;       new Book();

&nbsp;       new Book("Java");

&nbsp;       new Book("Spring Boot", 300);

&nbsp;   }

}


 

**Q3)can we override the constructor ?**

   **No**, constructors cannot be overridden in Java.

   You cannot override a constructor because it's not inherited. You can only call a parent constructor using super().


**Q4)this vs super ?**

   this refers to the **current class** (its variables, methods, constructors)**,**

   super refers to the **immediate parent class** (its variables, methods, constructors)**.**


**Q5)Encapsulation and how to achieve it in code level ?**

   Encapsulation is the process of hiding internal **data** and allowing access through **public methods (getters and setters)**.



**Q6)Abstraction vs interfaces?**

   Abstraction means hiding internal **details** and showing only essential behavior.

| Feature              | Abstract Class                              | Interface                                      |

| -------------------- | ------------------------------------------- | ---------------------------------------------- |

| Purpose              | Partial abstraction                         | Full abstraction (mostly)                      | 

| Variables            | Instance variables allowed                  | Only `public static final` (constants)         |

| Constructors         | Can have constructors                       | Cannot have constructors                       |

| Multiple Inheritance | ❌ Not supported                            | ✅ Supported                                  |

| Access Modifiers     | Can be public, protected, private           | Methods are \*\*public\*\* by default              |




Q**7)is it possible for final constructor?**

	No, Java does not allow constructors to be declared as final.
Java does not allow final constructors because constructors cannot be inherited or overridden in the first place.


**Q8)managed and unmanaged code?**

📘 Managed Code:

Code that runs under the control of a **runtime environment** like the **JVM** (in Java) or .NET CLR (in .NET).



The runtime manages memory, security, and type safety.


⚠️ Unmanaged Code:


Code that runs outside of a managed runtime.



The developer is responsible for memory management and security.



Common in C, C++ where you use pointers and manual malloc / free.




**Q9)what is IOC container?**

IoC (Inversion of Control) is a **design principle** where the control of object creation and dependency management is inverted from the programmer to the framework (Spring).



The IoC Container is the part of Spring that manages the **lifecycle and dependencies** of the **beans** (objects).


**Q10)can we invoke the parent class of constructor?**

Yes, we can — using the **super() keyword**.



**Q11)aggregation vs composition ?

Both are types of object relationships ("has-a" relationships), but they differ in how strong the relationship is.**

Aggregation = "has-a" relationship where child can live independently - weak relation

Composition = "has-a" relationship where child’s lifecycle depends on parent - strong relation


**Q12)what is static and dynamic binding?

Binding = Linking a method call to its definition (code)**


It can happen at **compile time or runtime.**



**Static Binding (Early Binding)**

Happens at **compile time**



Used for:



Static methods



Private methods



Final methods



Method overloading

**Dynamic Binding (Late Binding)**


Happens at **runtime**



Used for:



**Method overriding (POLYMORPHISM)**



Based on the object's actual type, not reference type



++++++++++++++



Association in OOP:

Definition:



Association represents a connection between classes or objects. It describes how classes are related to each other and how they collaborate.

Types of Association:



IS-A (Inheritance): Describes a relationship where one class is a specialized version of another class. It's a relationship of generalization and specialization.

HAS-A (Composition, Aggregation): Describes a relationship where one class has another class as a part or a member.



++++++++++++++++



Qsn 1 :



public class Main

{

&nbsp;	public static void main(String\[] args) {

&nbsp;		String input="bee-eater";

int\[] freq=new int\[256];

for(int i=0;i<input.length();i++){

&nbsp;   freq\[input.charAt(i)]++;

}

for(int i =0;i<input.length();i++){

&nbsp;   if(freq\[input.charAt(i)]>1){

&nbsp;       System.out.println(input.charAt(i) +" - "+freq\[input.charAt(i)]);

&nbsp;   freq\[input.charAt(i)]=0;

&nbsp;       

&nbsp;   }

}



&nbsp;	}

}





-----

Qsn 2 - Spiral pattern





public class Main

{

&nbsp;   //|| top>0 || down>0 || left<n-1

&nbsp;	public static void main(String\[] args) {

&nbsp;	int n=5;

&nbsp;	int\[]\[] matrix =new int\[5]\[5];

&nbsp;	int right=0,left=n-1,top=n-1,down=n-1;

&nbsp;	int count=1;

&nbsp;	for(int i=0;i<n;i++){

&nbsp;	    

&nbsp;	    for(int j=0;j<n;j++){

&nbsp;	        if(right<n ){

&nbsp;	            matrix\[i]\[right++]=count++;

&nbsp;	        }else if( top>0){

&nbsp;	            matrix\[j]\[top--]=count++;

&nbsp;	        }else if(down>0 ){

&nbsp;	            matrix\[down--]\[n-1-j]=count++;

&nbsp;	        }else if (left<n-1){

&nbsp;	            matrix\[left--]\[i]=count++;

&nbsp;	        }

&nbsp;	    }

&nbsp;	    

&nbsp;	}

&nbsp;	for(int i=0;i<matrix.length;i++){

&nbsp;	    for(int j=0;j<matrix\[i].length;j++){

&nbsp;	        System.out.print(matrix\[i]\[j] +" ");

&nbsp;	    }

&nbsp;	    System.out.println();

&nbsp;	}

&nbsp;	}

}





