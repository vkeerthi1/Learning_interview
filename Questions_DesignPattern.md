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



