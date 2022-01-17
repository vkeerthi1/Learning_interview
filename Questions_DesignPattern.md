#### Builder pattern 
it aims to “Separate the construction of a complex object from its representation so that the same construction process can create multiple different representations
A builder pattern should be more like a fluent interface. A fluent interface is normally implemented by using method cascading (or method chaining) as we see it in lambda expressions.

the builder pattern helps us in creating immutable classes with a large set of state attributes.

In normal practice, if we want to make an immutable User class, then we must pass all five information as parameters to the constructor. It will look like this:
```
public User (String firstName, String lastName, int age, String phone, String address){
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.phone = phone;
	this.address = address;
}
```
Very good. Now what if only firstName and lastName are mandatory and the rest 3 fields are optional. Problem !! We need more constructors. This problem is called the telescoping constructors problem.
```
public User (String firstName, String lastName, int age, String phone){ ...	}
public User (String firstName, String lastName, String phone, String address){ ...	}
public User (String firstName, String lastName, int age){ ...	}
public User (String firstName, String lastName){ ...	}
```
```
public class User
{
	//All final attributes
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	//All getter, and NO setter to provde immutability
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
	}

	public static class UserBuilder
	{
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		//Return the finally consrcuted User object
		public User build() {
			User user =  new User(this);
			validateUserObject(user);
			return user;
		}
		private void validateUserObject(User user) {
			//Do some basic validations to check
			//if user object does not break any assumption of system
		}
	}
}

public static void main(String[] args) 
{
	User user1 = new User.UserBuilder("Lokesh", "Gupta")
	.age(30)
	.phone("1234567")
	.address("Fake address 1234")
	.build();

	System.out.println(user1);

	User user2 = new User.UserBuilder("Jack", "Reacher")
	.age(40)
	.phone("5655")
	//no address
	.build();

	System.out.println(user2);
 }
 
```



#### Which design pattern is used to get a way to access the elements of a collection object in sequential manner?

Iterator pattern is used to get a way to access the elements of a collection object in sequential manner.

#### Mention in how many ways can you create singleton pattern?
To create single objects there are two famous ways

Lazy loading
Eager loading

####  Mention why access to the non-static variable is not allowed from static method in Java?
You cannot access non-static data from static context because non-static variable are associated with a specific instance of an object while static is not associated with any instance.

####  Mention when can you use the Intercepting pattern?

Intercepting pattern is used when you have to do some pre-processing or post processing with request or response of the application.

#### What is Inversion of Control?
Inversion of control is a pattern used to decouple the dependencies between layers and components in the system. The Dependency-Injection (DI) pattern is an example of an IoC pattern that helps in removing dependencies in the code.

Let us understand this with the help of an example. Consider we have a class A that makes use of class B as shown below:
```
public class A{
   private B b;
   
   public A(){
       this.b = new B();
   }
}
```
Here, we have a dependency between classes A and B. If we had the IoC pattern implemented, we would not have used the new operator to assign value to the dependent variable. It would have been something as shown below:
```
public class A {
   private IocB b;
   public A(IocB b) {
       this.b = b;
   }
}
```
We have inverted the control of handing the dependency of instantiating the object of class B to the IoC class IocB



