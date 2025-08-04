**Q1)Difference b/w abstract and interface ?**

**Q2)Types of access specifiers**

   Public , private , default , protected

   private - > within same class
   protected -> same package + subclasses in other package
   default -> same package


**Q3)Types of inheritance in java ?** 

   Java supports single, multilevel, hierarchical, and multiple inheritance via interfaces.

&nbsp;  Hybrid is achieved by combining these using interfaces.

**Q4)What are the annotations used in the project?**
   
   Spring Boot projects use annotations like **@RestController, @Autowired, @Entity, etc., to handle dependency injection, web requests, and data persistence.**


**Q5)what is the xargs commands?**

   xargs is a command in Unix/Linux used to convert input from standard input (stdin) into arguments to a command.



&nbsp;  It helps when you want to pass the output of one command as arguments to another command.

&nbsp; 

&nbsp;  Example : cat files.txt | xargs rm

&nbsp;	

**Q6)What is the deployment pool ?**

   A Deployment Pool is a shared group of deployment agents used across pipelines for scalable and consistent application deployments.


**Q7)How to kill the job?**

   Use kill or kill -9 along with a **job ID (%1) or process ID (12345)** to stop a running job or process.
    

**Q8)What are the diff ways to create the object?**

   I)  Using **new** Keyword
   II) Using **clone()** Method

      Car car1 = new Car();

&nbsp;     Car car2 = (Car) car1.clone();

&nbsp; 
  III) Using **Class.forName()** (Reflection)
    
       Class<?> clazz = Class.forName("com.example.Car");

&nbsp;      Car car = (Car) clazz.newInstance();

   IV) Using **Deserialization**

	ObjectInputStream in = new ObjectInputStream(new FileInputStream("car.ser"));

&nbsp;	Car car = (Car) in.readObject();



 


**Q9)flow of the object creation process?**

&nbsp;   
  Object creation in Java involves **memory allocation**, **default values initialization**, calling parent constructors, running initializers, and finally executing the child constructor.



==========================

employee

Address



select \* from employee e inner join Address a on e.employee\_id =a.employee\_id where a.city='chennai';

select a.city , count(\*) count from employee e inner join Address a on e.employee\_id =a.employee\_id group by city;





class Employee implements Cloneable{

private int employeeId;

private String empName;



//getter

//setter

public Object clone(){

return super.clone();

}

}



Employee emp=new Employee();





Abstract class Shape



class rect 

class cirle





---------

char\[] c1={'h','e','l','l','o'};

char\[] c2={'h','e','l','a','b'};



int \[] freq=new int\[256];



for(char c : c1){

freq\[c]++;

}





for(char c : c2){

freq\[c]++;

}



for(int i : freq){

if(i>1){

syso((char)i);

}

}



============================

int\[] arr={1,2,3,4,5,6,7,8,9};



for(int i=1;i<arr.lenght;i++){

if(i%2==0){

syso(arr\[i]);

}

}



We can use i+=2 to print the even position of values





for(int i=1;i<arr.lenght;i+=2){

syso(arr\[i]);



}

===========



String str="000123";



String res="";

for(char c: str.toCharArray()){

res+=c;

}

syso(res);



str.substring(3);











String st="java";

ajav



for(int i=0;i<st.lengh();i+=2){

st=swap(st,i,i+1);

}



swap(String st,int i,int j){

char\[] carr=st.toCharArray();

char t=carr\[i];

carr\[i]=carr\[j];

carr\[j]=t;

return String.valueOf( carr);

}

















