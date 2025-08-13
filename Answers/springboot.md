**How can I enable auto reload of my application with Spring Boot?**



In Spring Boot, you can enable auto-reload (hot reloading) so that changes to your code or resources are automatically picked up without restarting the application manually.

 Use Spring Boot DevTools







How can I add custom JS code with Spring Boot?



Create a folder called static under resources folder. You can put your static content in that folder.



For your example the path to myapp.js would be **resources\\static\\js\\myapp.js**



You can refer to it in jsp using



<script src="/js/myapp.js"></script>





//restservice



Q : What is Spring Data REST?



Spring Data REST can be used to expose HATEOAS RESTful resources around Spring Data repositories.



An example using JPA is shown below



@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")

public interface TodoRepository

&nbsp;       extends PagingAndSortingRepository<Todo, Long> {

Without writing a lot of code, we can expose RESTful API around Spring Data Repositories.



A few example REST Services are shown below:



POST

URL : http://localhost:8080/todos

Use Header : Content-Type:application/json

Request Content

{

&nbsp; "user": "Jill",

&nbsp; "desc": "Learn Hibernate",

&nbsp; "done": false

}

Response Content



{

&nbsp; "user": "Jill",

&nbsp; "desc": "Learn Hibernate",

&nbsp; "done": false,

&nbsp; "\_links": {

&nbsp;   "self": {

&nbsp;     "href": "http://localhost:8080/todos/1"

&nbsp;   },

&nbsp;   "todo": {

&nbsp;     "href": "http://localhost:8080/todos/1"

&nbsp;   }

&nbsp; }

}

The response contains the href of the newly created resource.







How does path= users , collectionResourceRel= users  work with Spring Data Rest?

@RepositoryRestResource(collectionResourceRel = "users", path = "users")



public interface UserRestRepository extends

PagingAndSortingRepository<User, Long>

path - The path segment under which this resource is to be exported.

collectionResourceRel - The rel value to use when generating links to the collection resource. This is used when 



generating HATEOAS links.

