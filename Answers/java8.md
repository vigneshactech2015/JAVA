**What is Spliterator in Java SE 8?Differences between Iterator and Spliterator in Java SE 8?**


Spliterator stands for Splitable Iterator. It is newly introduced by Oracle Corporation as part Java SE 8.

Like Iterator and ListIterator, It is also one of the Iterator interface.



S.No.	Spliterator	                Iterator



1\.	It is introduced in Java SE 8.	It is available since Java 1.2.

2\.	Splitable Iterator	        Non-Splitable Iterator

3\.	It is used in Stream API.	It is used for Collection API.

4\.	It uses Internal Iteration concept to iterate Streams.	It uses External Iteration concept to iterate Collections.

5\.	We can use Spliterator to iterate Streams in Parallel and Sequential order.	We can use Iterator to iterate Collections only in Sequential order.

6\.	We can get Spliterator by calling spliterator() method on Stream Object.	We can get Iterator by calling iterator() method on Collection Object.

7\.	Important Method: tryAdvance()	Important Methods: next(), hasNext()







-----------------------------------





**What is Optional in Java 8? What is the use of Optional?Advantages of Java 8 Optional?**

Optional:

Optional is a final Class introduced as part of Java SE 8. It is defined in java.util package.



It is used to represent optional values that is either exist or not exist. It can contain either one value or zero value. If it contains a value, we can get it. Otherwise, we get nothing.



It is a bounded collection that is it contains at most one element only. It is an alternative to  null  value.



**Main Advantage of Optional is:**



It is used to avoid null checks.

It is used to avoid  NullPointerException .





**What is Type Inference? Is Type Inference available in older versions like Java 7 and Before 7 or it is available only in Java SE 8?**



Type inference existed before Java 7 but was limited.



Java 7 improved it with the diamond operator.



Java 8 enhanced it for lambdas and streams.

**Scopes in bean spring boot ?**

| Scope       | Lifetime                            | Common Use             |
| ----------- | ----------------------------------- | ---------------------- |
| Singleton   | Entire Spring container             | Shared services        |
| Prototype   | New instance each request to Spring | Stateful beans         |
| Request     | Single HTTP request                 | Request data holder    |
| Session     | HTTP session                        | User session data      |
| Application | ServletContext lifetime             | App-wide data          |
| WebSocket   | WebSocket session                   | Real-time session data |


@Scope("prototype")
@Component
public class MyBean { }



Java 10 expanded it with var.

