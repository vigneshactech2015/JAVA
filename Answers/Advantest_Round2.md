**Q1)What are the design pattern you know?**



Singleton -> creating instance only once



public class Singleton {



&nbsp;   private static Singleton instance;



&nbsp;  // step 1  : create a constructor

&nbsp;   private Singleton(){

&nbsp;	System.out.println("Instance created")

&nbsp; }



&nbsp;  public static Singleton getInstance(){



&nbsp;	if(instance == null) instance = new Singleton();

&nbsp;	return instance;

&nbsp; }



}





usage :  For database connectivity 



public class Main{

&nbsp;	public static void main(String\[] args){

&nbsp;	   Singleton s1 = Singleton.getInstance(); // instance created

&nbsp;	   Singleton s2 = Singleton.getInstance(); // no new instance

&nbsp;		System.out.println(s1==s2); // true

&nbsp;	}



}







-----------





Sample Input:  “abc”

Sample Output: “abc”, “bac”, “bca”, “acb”, “cab”, “cba”





generatePermutation(0,"abc");



public void generatePermutation(int l,String word){



if(l==word.length){

System.out.println(word);

return 

}



for(int i=l;i<word.length;i++){

word=swap(word,i,l);

generatePermutation(i+1,word);

word=swap(word,i,l);

}

}

public string swap(String word,int i,int j){



char\[] charArr=word.toCharArray();



int t=charArr\[i];

charArr\[i]=charArr\[j];

charArr\[j]=t;



return charArr.toString;

}



----------



String word ="Hello world";



public void printRepeatedChar(String word){

int \[] freq=new int\[256];



for(char c : word.toCharArray){

freq\[c]++;

}



for(int i=0;i<word.length;i++){

if(freq\[word.charAt(i)]>1){

System.out.println(word.charAt(i) +" - "+freq\[word.charAt(i)]);

freq\[word.charAt(i)]=0;

}

}

}







--------------





**Q2) Output based question**

class Sample   

{  

&nbsp;   public static void main (String args\[])   

&nbsp;   {  

&nbsp;       System.out.println(5 \* 10 + "Java");   

&nbsp;       System.out.println("Java" + 5 \* 10);  

&nbsp;   }  

}  

50Java

Java50



------------------

class Sample   

{  

&nbsp;   public static void main (String args\[])   

&nbsp;   {  

&nbsp;       System.out.println(50 + 110 + "Java");   

&nbsp;       System.out.println("Java" + 50 + 110);  

&nbsp;   }  

} 

160Java

Java50110



Multiplication has higher precedence than addition while string concatenation.


----------------------------





**Q3)How to design your endpoints?**


http://localhost:8080/api/v1/employee/1

This endpoint is accessing Employee with ID 1 under:



api → base path for APIs



v1 → version 1 of the API



employee → the resource



1 → the unique identifier



This is a solid REST-style endpoint.





**Q4)Principle of rest api?**

	REST APIs follow principles like **statelessness, uniform interface, and client-server separation** to build scalable and maintainable systems**.

Uniform interface : standard http method for get,post,put,delete,patch for accessing resource.**



**Q5)What is the disadvantage of rest?

   I)**Over-fetching or under-fetching.

&nbsp;  II)Statelessness can cause overhead as each request must contain all information.
  III)No built-in security Relies on external mechanism like HTTPS,OAuth for security .


**Q6)Diff between rest and restful?**

REST is a design concept/principle, and RESTful refers to a system(Implementation) that follows REST principles.


**Q7)interface vs abstract class?**

   Same as previous answers


**Q8)What are the different http components?**

   HTTP components include method, URL, headers, and body in requests and status, headers, and body in responses.


**Q9)Do you know about multithreading?**

	Multithreading is a feature that allows a program to run multiple threads concurrently — enabling better CPU utilization and faster performance, especially in tasks like file I/O, network calls, and parallel computations.

&nbsp;	
        A thread is a lightweight unit of a process.



&nbsp;	Each thread has its own stack and executes independently but shares memory with other threads in the process.

	Multithreading allows Java applications to perform multiple tasks at once, improving efficiency and responsiveness.



What is multithreading?

&nbsp;

