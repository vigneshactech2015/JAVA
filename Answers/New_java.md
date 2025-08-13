



**Question 1: What’s wrong using HashMap in the multi-threaded environment? When does the get() method go to an infinite loop?** (answer)



Well, nothing is wrong, depending on how you use it. For example, if you initialize the HashMap just by one thread and then all threads are only reading from it, then it’s perfectly fine. One example of this is a Map which contains configuration properties.



The real problem starts when at-least one of that thread is updating HashMap i.e. adding, changing or removing any key value pair. Since put() operation can cause re-sizing and which can further lead to infinite loop, that’s why either you should use Hashtable or ConcurrentHashMap, later is better.



**Question 2. Does overriding the hashCode() method have any performance implication?** (answer)



This is a good question and open to all, as per my knowledge a poor hash code function will result in the frequent collision in HashMap which eventually increases the time for adding an object into Hash Map.



From Java 8 onwards though, collision will not impact performance as much as it does in earlier versions, because after a threshold the linked list will be replaced by the binary tree, which will give you O(logN) performance in the worst case, as compared to O(n) of linked list.



**Question 3: Do all properties of an Immutable Object need to be final?** (answer)



Not necessarily, as stated above you can achieve same functionality by making the member non-final but private and not modifying them except in a constructor. Don’t provide setter methods for them and if it is a mutable object, then don’t ever leak any reference for that member.



Remember making a reference variable final, only ensures that it will not be reassigned to a different value, but you can still change individual properties of object, pointed by that reference variable. This is one of the key point, Interviewer like to hear from candidates.



**Question 4: How does the substring() method inside String works?** (answer)



Another good Java interview question, I think the answer is not sufficient, but here it is “Substring creates a new object out of source string by taking a portion of original string”.



This question was mainly asked to see if the developer is familiar with the risk of memory leaks, which a sub-string can create. Until Java 1.7, substring holds the reference of the original character array, which means even a sub-string of 5 character long, can prevent 1GB character array from garbage collection, by holding a strong reference.



How SubString works in Java



This issue is fixed in Java 1.7, where the original character array is not referenced anymore, but that change also made the creation of substring a bit more costly in terms of time. Earlier it was on the range of O(1), which could be O(n) in worst case on Java 7.



Question\*\*  5: Can you write a critical section code for the singleton?\*\* (answer)



This core Java question is a followup of the previous question and expecting the candidate to write Java singleton using double checked locking. Remember to use the volatile variable to make Singleton thread-safe.



**Question 6: How do you handle error condition while writing stored procedure or accessing stored procedure from java?** (answer)



This is one of the tough Java interview questions and its open for all, my friend didn’t know the answer so he didn’t mind telling me. My take is that stored procedure should return an error code if some operation fails but if stored procedure itself fails than catching SQLException is the only choice.



**Question 7 : What is difference between Executor.submit() and Executer.execute() methods ?** (answer)



Use execute() when you just want to run something without feedback.



Use submit() when you want to get results, check completion, or catch exceptions.



1\. execute()

Declared in: Executor interface.



Purpose: Runs a task asynchronously, no return value.



Accepts: A Runnable only.



Return Type: void — you don’t get a handle to check the result or exception.



2\. submit()

Declared in: ExecutorService interface.



Purpose: Runs a task asynchronously, returns a Future so you can check the result or exceptions.



Accepts:



Runnable (returns Future<?>)



Callable<T> (returns Future<T>)



Return Type: Future — allows get(), cancel(), etc.



Question 8:  What is the difference between factory and abstract factory pattern? (answer)





| Feature             | Factory Pattern                   | Abstract Factory Pattern               |

| ------------------- | --------------------------------- | -------------------------------------- |

| Purpose             | Creates one type of product       | Creates families of related products   |

| Complexity          | Simple                            | More complex (factory of factories)    |

| Number of Factories | One                               | Multiple                               |

| Example Analogy     | Coffee machine making only coffee | Vending machine making coffee + snacks |





**Question 9: What is a Singleton?** Is it better to make the whole method synchronized or only critical section synchronized? (answer)



Singleton in Java is a class with just one instance in the whole Java application, for example, java.lang.Runtime is a Singleton class. Creating Singleton was tricky prior Java 4 but once Java 5 introduced Enum its very easy.





**Question 11 : When do you override hashCode() and equals()?** (answer)



Whenever necessary, especially if you want to do equality check based upon business logic rather than object equality, e.g. two employee objects are equal if they have the same emp\_id, despite the fact that they are two different objects, created by different part of the code.



Also overriding both these methods are must if you want to use them as key in HashMap. Now as part of the equals-hashcode contract in Java, when you override equals, you must override hashcode as well, otherwise your object will not break invariant of classes e.g. Set, Map which relies on equals() method for functioning properly.





**Question 12 :. What will be the problem if you don’t override hashCode() method ?** (answer)



If you don’t override the equals method, then the contract between equals and hashcode will not work, according to which, two objects which are equal by equals() must have the same hashcode. In this case, an other object may return different hashCode and will be stored on that location, which breaks invariant of HashMap class, because they are not supposed to allow duplicate keys.



When you add object using put() method, it iterate through all Map.Entry object present in that bucket location, and update value of previous mapping, if Map already contains that key. This will not work if hashcode is not overridden.



java-puzzle-equal-hashcode



Question 13 : Is it better to synchronize critical sections of getInstance() method or the whole getInstance() method? (answer)



The answer is only the critical section, because if we lock the whole method, then every time some some one call this method, it will have to wait even though we are not creating any object. In other words, synchronization is only needed, when you create object, which happens only once.



Once object has created, there is no need for any synchronization. In fact, that’s very poor coding in terms of performance, as synchronized method reduce performance up to 10 to 20 times. Here is UML diagram of Singleton pattern:



Singleton design Pattern Java



By the way, there are several ways to create a thread-safe singleton in Java, which you can also mention as part of this question or any follow-up.



**Question 14: Where does equals() and hashCode() method comes in the picture during the get() operation?** (answer)



This core Java interview question is a follow-up of previous Java question and the candidate should know that once you mention hashCode, people are most likely ask, how they are used in HashMap. When you provide a key object, first it’s hashcode method is called to calculate bucket location. Since a bucket may contain more than one entry as linked list, each of those Map.Entry object is evaluated by using equals() method to see if they contain the actual key object or not.



**Questions 15: How do you avoid a deadlock in Java?** (answer)



You can avoid deadlock by breaking the circular wait condition. In order to do that, you can make an arrangement in the code to impose the ordering on acquisition and release of locks.



If lock will be acquired in a consistent order and released in just opposite order, there would not be a situation where one thread is holding a lock which is acquired by other and vice-versa. See the detailed answer for the code example and more detailed explanation.



**Question 16:  What is the difference between creating String as new() and literal?**  (answer)



When we create the string with new() Operator, it’s created in heap and not added into string pool while String created using literal are created in String pool itself which exists in PermGen area of heap.



String str = new String("Test")

does not put the object str in String pool, we need to call String.intern() method which is used to put them into String pool explicitly. It’s only when you create String object as a String literal e.g. String s = "Test" that Java automatically puts that into the String pool.



By the way there is a catch here Since we are passing arguments as “Test”, which is a String literal, it will also create another object as “Test” on string pool. This is the one point, which has gone unnoticed until knowledgeable readers of Javarevisited blog suggested it.



To learn more about the difference between String literal and String object, see this article.



Here is a nice image which shows this difference quite well:



String literal vs String Object in Java



**Question 17: What is an Immutable Object? Can you write an Immutable Class?** ( answer)



Immutable classes are Java classes whose objects can not be modified once created. Any modification in Immutable object results in the new object. For example, String is immutable in Java.



Mostly Immutable classes are also final in Java, in order to prevent sub classes from overriding methods, which can compromise Immutability. You can achieve the same functionality by making member as non-final but private and not modifying them except in constructor.



Apart form obvious, you also need to make sure that, you should not expose the internals of Immutable object, especially if it contains a mutable member. Similarly, when you accept the value for the mutable member from client e.g. java.util.Date, use clone() method keep a separate copy for yourself, to prevent the risk of malicious client modifying mutable reference after setting it.



The Same precaution needs to be taken while returning value for a mutable member, return another separate copy to the client, never return original reference held by Immutable class. You can see my post How to create an Immutable class in Java for step by step guide and code examples.



**Question 18: Give the simplest way to find out the time a method takes for execution without using any profiling tool?** (answer)



Read the system time just before the method is invoked and immediately after thr method returns. Take the time difference, which will give you the time taken by a method for execution.



To put it in code…



long start = **System.currentTimeMillis** ();

method ();

long end = System.currentTimeMillis (); System.out.println (“Time taken for execution is ” + (end – start));

Remember that if the time taken for execution is too small, it might show that it is taking zero milliseconds for execution. Try it on a method which is big enough, in the sense the one which is doing considerable amount of processing



**Question 19: Which two methods you need to implement to use an Object as key in HashMap?** (answer)



In order to use any object as Key in HashMap or Hashtable, it must implement **equals and hash-code** methods in Java. Read How HashMap works in Java for a detailed explanation on how equals and hash code method is used to put and get an object from HashMap.



**Question 20: How would you prevent a client from directly instantiating your concrete classes? For example, you have a Cache interface and two implementation classes MemoryCache and DiskCache, How do you ensure there is no object of this two classes is created by client using new() keyword.**







Use Dependency Injection (Spring style)



In Spring Boot:



@Component

public class MemoryCache implements Cache { ... }



@Service

public class DiskCache implements Cache { ... }

Clients get Cache via @Autowired, so they never call new.


**Question 21:What is shared memory and how can we implement? **

Shared memory is a way for two or more processes (or threads) to access the same block of memory for communication or data exchange, instead of copying data back and forth.

Since each Java process (JVM) has its own heap memory, true OS-level shared memory (like in C) is not directly available in java.

1. Shared Memory Between Threads (Same JVM)
When multiple threads run inside the same JVM, they share the same heap.

class SharedData {
    int counter = 0;
}

public class ThreadSharedMemory {
    public static void main(String[] args) {
        SharedData data = new SharedData(); // Shared object in heap

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) data.counter++;
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) System.out.println(data.counter);
        });

        t1.start();
        t2.start();
    }
}
