###  How Java Stream is better than normal for loop

###  Where do we use serializable ? and what happens if we don’t do it
We need Serialization for the following reasons:
* Communication: Serialization involves the procedure of object serialization and transmission. This enables multiple computer systems to design, share and execute objects simultaneously.
* Caching: The time consumed in building an object is more compared to the time required for de-serializing it. Serialization minimizes time consumption by caching the giant objects.
* Deep Copy: Cloning process is made simple by using Serialization. An exact replica of an object is obtained by serializing the object to a byte array, and then de-serializing it.
* Cross JVM Synchronization: The major advantage of Serialization is that it works across different JVMs that might be running on different architectures or Operating Systems
* Persistence: The State of any object can be directly stored by applying Serialization on to it and stored in a database so that it can be retrieved later.
 
* A Java object is serializable if and only if its class or any of its parent classes implement either the java.io.Serializable interface or its subinterface, java.io.Externalizable.
* In the Serialization process, we convert an object’s state into a byte stream so that it could be transferred from one JVM to the other and revert the byte stream back into the original object.

Case – 1: If Superclass is Serializable, then, by default, its Subclasses are also serializable. 
Case – 2: A Subclass can be serialized if it implements the Serializable Interface even if a Superclass does not implement the Serializable Interface.

###  lamda do runnable interface
###  Map how do we use with Java8
###  Springboot scope
###  Streams
###  Functions interface vs normal interface
###  Microservices design
###  Spring transaction management and implementation
###  Future and completable future
 
* A CompletableFuture class is also a Future class. It implements the Future interface. 
* A Future Object is Blocking , A Completable Future is non-blocking
* Threads cannot be combined using Future objects, they can be combined using Completable Future
* CompletableFuture provides a better mechanism to run threads in a pipleline. You can use the method thenApply() to achieve this.

```
CompletableFuture.supplyAsync(() -> d.sampleThread1()).thenApply(message -> d.sampleThread2(message)).thenAccept(finalMsg -> System.out.println(finalMsg));
```

* Why CF was introduced????
1. There is no way to complete the future. we can only attempt to cancel the task.
2. The get() method in the Future Interface is blocking operation
3. No support for exception handling
4. Multiple futures cannot be chained together.


#### Crud repo and JPA Repo
JpaRepository extends PagingAndSortingRepository that extends CrudRepository.
CrudRepository mainly provides CRUD operations.

PagingAndSortingRepository provide methods to perform pagination and sorting of records.

JpaRepository provides JPA related methods such as flushing the persistence context and deleting of records in batch.
Due to their inheritance nature, JpaRepository will have all the behaviors of CrudRepository and PagingAndSortingRepository. So if you don't need the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.

### Why ResponseEntity
* ResponseEntity is an extension of HttpEntity that represents an HTTP response including status, headers and body. ResponseEntity allows you to modify the response with optional headers and status code. 
* ResponseEntity represents the entire HTTP response. You have more control over response by including body, headers and status code.
* ResponseEntity is used when you need to change HTTP headers or HTTP status code based upon your business logic or incoming request. ResponseEntity wraps the original object as its body which is optional. 
```
@GetMapping("/hello")
ResponseEntity<String> hello() {
    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
}
```

### Comparator vs comparable
Comparable
Sorting logic must be in same class whose objects are being sorted. Hence this is called natural ordering of objects
int compareTo(Object o1)
This method compares this object with o1 object and returns  a integer

Collections.sort(List)
Here objects will be sorted on the basis of CompareTo method

Comparator
Sorting logic is in separate class. Hence we can write different sorting based on different attributes of objects to be sorted. E.g. Sorting using id,name etc.

```
int compare(Object o1,Object o2)
```
This method compares o1 and o2 objects. and returns  a integer.
```
Collections.sort(List, Comparator)
```
Here objects will be sorted on the basis of Compare method in Comparator

Collections.Sort()

### put vs patch

PUT is another HTTP method used to create a new resource at a specified URI or to update an existing resource. Although PUT can be used to create a resource, it is most often used to update resource. To create a new resource, using PUT we need to know the exact URI where the data needs to be put. If incase there is data in the specified URI, the entire data is overwritten which is update.
Most important thing to remember is the PUT payload should have all the fields of the resource when updating or else the resource is overwritten with the data we send.
PUT is idempotent and are not cacheable.

PATCH is another HTTP method which is used to update a resource with partial data. Unlike PUT, PATCH does not need the full payload to update a resource. For example if a resource has 100 fields, using PATCH would be a better option than PUT as PUT requires all 100 fields to be sent again to update a resource.
PATCH is neither safe nor idempotent.

POST works on a collection while PUT works on a single resource.

POST is a HTTP method used to create a new resource in a collection of resources. POST method should ideally be used only to create new resources. Since REST doesnt have a standard set of rules, some APIs use POST to update a resource as well. This is better to avoid. Use POST only to create a resource.
If you do the same request 2 times, 2 resources are created. Due to this reason, POST method is not idempotent and unsafe.

### Method reference
* Reference to a Static Method
```
List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
```
* We can achieve this by leveraging a simple lambda expression calling the StringUtils.capitalize() method directly:
```
messages.forEach(word -> StringUtils.capitalize(word));
messages.forEach(StringUtils::capitalize);
```

*  Reference to an Instance Method from instance

*  Reference to an Instance Method from Class Type
```
List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
numbers.stream().sorted((a, b) -> a.compareTo(b));
numbers.stream().sorted(Integer::compareTo);
```

* Reference to a Constructor
List<Integer> integers = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(ArrayList::new));

#### Functional interfaces 
A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit

Can Functional Interface have default and static methods?  ex: Predicate Class ,Consumer Class
```
void	accept(T t)
	Performs this operation on the given argument.
default Consumer<T>	andThen(Consumer<? super T> after)
	Returns a composed Consumer that performs, in sequence, this operation followed by the after operation.
```

Why Functional Interface has only one method  -> lamda to recognize which to use. 
### Scope of Lambda  ->
local variables can used in lamda to be effectively final(cannot be reassigned)


###  what about ACID property in microservices, like transaction scaling multiple microservices 
###  how will you implement put rest docs says put can also save data when data is not found? 
###  have you implemented delete mapping
###  delete not a frequent implementation for prod apps, explained why 
###  two beans are there in my config, I want Bean B should get initialized before Bean A, how to achieve? ->@DependsOn


###  two configs A and B in spring boot, how to use Config B beans inside Config A? @Import , @importResource
###  pessimistic locking vs optimistic locking 
###  Spring Transaction Management 
###  what happens under @Transactional ->(Aspect oriented Programming)
###  I have some code inside a static block and some code inside a @postConstruct block which will run first  =>Static block
###  explain Oauth 2 process 
###  different api gateways? why need them? 
###  what architecture design pattern to use with containers (Sidecar design pattern)
###  a request goes through a series of checks (basically multiple if loops like more than 4 to 5 and these have some concrete impl) - what pattern suits this scenario 
###  chain of responsibilty
###  which feature in cloud do you think is best according to you, why 
###  how will you decide if you are ready for adapting microservice architecture 
###  monolithic, soa and microservice 
###  How to decompose a monolithic project
###  disadvantages of microservices
###  how will you implement communication bet microservices 
###  logging mechanism for microservices 
###  why ELK stack instead of Splunk for logging? 
###  deployment of microservices 
###  importance of spring boot profile, give few scenarios where you used it 
###  Caching mechanism - EhCache , Redis
###  Do you think we can use a database for caching? 

