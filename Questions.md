# By default, java cloning is ‘field by field copy’ i.e. as the Object class does not have idea about the structure of class on which clone() method will be invoked.
# So, JVM when called for cloning, do following things:

• If the class has only primitive data type members then a completely new copy of the object will be created and the reference to the new object copy will be returned.
• If the class contains members of any class type then only the object references to those members are copied and hence the member references in both the original object as well as the cloned object refer to the same object.
Apart from above default behavior, you can always override this behavior and specify your own.

``` java
/*
Creates and returns a copy of this object. The precise meaning of "copy" may depend on the class of the object.
The general intent is that, for any object x, the expression:
1) x.clone() != x will be true
2) x.clone().getClass() == x.getClass() will be true, but these are not absolute requirements.
3) x.clone().equals(x) will be true, this is not an absolute requirement.
*/
```
 
protected native Object clone() throws CloneNotSupportedException;
Java clone() method


Shallow clone is “default implementation” in Java. In overridden clone method, if you are not cloning all the object types (not primitives), then you are making a shallow copy.


# Question 3: Does all property of the Immutable Object needs to be final in Java? 
Not necessary, you can achieve the same functionality by making a member as non-final but private and not modifying them except in constructor.
Don’t provide a setter method for them, and if it is a mutable object, then don’t ever leak any reference for that member.
Remember making a reference variable final, only ensures that it will not be reassigned a different value. However, you can still change the individual properties of an object, pointed by that reference variable.
* “Substring creates a new object out of source string by taking a portion of the original string.”
* Until Java 1.7, substring holds the reference of the original character array, which means even a sub-string of 5 characters extended, can prevent 1GB character array from garbage collection, by containing a strong reference.

This issue was fixed in Java 1.7, where the original character array is not referenced anymore, but that change also made the creation of substring a bit costly in terms of time. Earlier it was on the range of O(1), which could be O(n) in the worst case of Java 7 onwards.



# One might ask why not simply add the value to a list. Why do we need a HashMap? 
The simple reason is performance. If we want to find a specific element in a list, the time complexity is O(n) and if the list is sorted, it will be O(log n) using, for example, a binary search.
* The advantage of a HashMap is that the time complexity to insert and retrieve a value is O(1) on average.

How do you run a Java application on the command line and set the classpath with multiple jars?
java -cp /dev/myapp.jar:/dev/mydependency.jar com.codementor.MyApp

# What is the difference between final, finalize and finally?
final is a Java keyword used to indicate that either a method can not override in a subclass, or a class can not be extended or a field can not be modified. 
finalize is a method that gets called on an instance of an Object when it is garbage collected.
finally is a Java keyword used in exception handling to indicate a block of code that should always be run whether an exception is thrown or not.

# What’s the difference between a ClassNotFoundException and NoClassDefFoundError?
A ClassNotFoundException means the class file for a requested class is not on the classpath of the application.
A NoClassDefFoundErrormeans that the class file existed at runtime, but for some reason the class could not be turned into a Class definition.
 A common cause is an exception being thrown in static initialization blocks.

# Why isn’t String‘s .length() accurate?
It isn’t accurate because it will only account for the number of characters within the String. In other words, it will fail to account for code points outside of what is called the BMP (Basic Multilingual Plane), that is, code points with a value of U+10000 or greater.
The reason is historical: when Java was first defined, one of its goal was to treat all text as Unicode; but at this time, Unicode did not define code points outside of the BMP. By the time Unicode defined such code points, it was too late for char to be changed.
This means that code points outside the BMP are represented with two chars in Java, in what is called a surrogate pair. Technically, a char in Java is a UTF-16 code unit.
The correct way to count the real numbers of characters within a String, i.e. the number of code points, is either:
someString.codePointCount(0, someString.length())
or, with Java 8:
someString.codePoints().count()

Given two double values d1, d2, why isn’t it reliable to test their equality using:
d1 == d2
Because of Double.NaN (literally: “Not a Number”).
This code:
``` java
final double d1 = Double.NaN;
final double d2 = Double.NaN;
System.out.println(d1 == d2);
```
will print false.
The most accurate way to tell whether two double values are 
equal to one another is to use Double.compare() and test against 0, as in:
System.out.println(Double.compare(d1, d2) == 0);


# What is the problem with this code:
``` java
final byte[] bytes = someString.getBytes();
```
There are, in fact, two problems:
• the code relies on the default Charset of the JVM;
• it supposes that this default Charset can handle all characters.
While the second problem is rarely a concern, the first certainly is a concern.
For instance, in most Windows installations, the default charset is CP1252; but on Linux installations, the default charset will be UTF-8.
As such, such a simple string as “é” will give a different result for this operation depending on whether this code is run on Windows or Linux.
The solution is to always specify a Charset, as in, for instance:
final byte[] bytes = someString.getBytes(StandardCharsets.UTF_8);


# In this code:
# IntStream.range(0, 10).forEach(System.out::println);
# what is the inferred type of the method reference System.out::println? 
It is an IntConsumer.
IntStream.range(0, 10) returns an IntStream, and 
IntStream defines a .forEach() method accepting an IntConsumer as an argument, whose prototype is:
void accept(int value);
System.out is a PrintStream, and a PrintStream has a method named println which takes an int as an argument and returns void. This matches the signature of an IntConsumer, hence the result.

# What is the problem with this code?
final Path path = Paths.get(...);
Files.lines(path).forEach(System.out::println);
The problem is that the Stream returned by Files.lines() is not closed.
This should be used instead:
``` java
try (
    final Stream<String> stream = Files.lines(path);
) {
    stream.forEach(System.out::println);
}
```
Stream extends BaseStream, and BaseStream extends AutoCloseable.
While this has no influence on streams you obtain from collections for instance, the stream returned by Files.lines() is I/O bound. Neglecting to close it correctly may lead to a resource leak in the event of an error occurring while processing the stream.

# Consider the following piece of code:
``` java
final List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.remove(2);
```
What will be the contents of the list after this operation and why?
The contents will be:
[ 1, 2 ]
The reason is that there are two removal operations on a List:
• remove(int index)
• remove(Object obj)
The JVM will always select the most specific overload of a method; and here we pass an int as an argument,
 the code therefore removes the element at index 2.
To remove the _element_ 2 from the list, the following needs to be written:
list.remove(Integer.valueOf(2));
 

# What is the contract between equals and hashCode of an object?
The only obligation is that for any objects o1 and o2 then if o1.equals(o2) is true then o1.hashCode() == o2.hashCode() is true.
Note that this relationship goes only one way: for any o1, o2 of some class C, where none of o1 and o2 are null, then it can happen that o1.hashCode() == o2.hashCode() is true BUT o1.equals(o2) is false.

# Can an enum be extended?
No. Enum types are final by design.

# How threadsafe is enum in Java?
Creation of an enum is guaranteed to be threadsafe.
 However, the methods on an enum type are not necessarily threadsafe

# How does the JVM handle storing local variables vs storing objects?
Objects are stored on the heap. Variables are a reference to the object.
Local variables are stored on the stack.

Identify the problem in the below code:
``` java
public class Foo {
    public Foo() {
        doSomething();
    }
public void doSomething() {
        System.out.println("do something acceptable");
    }
}
public class Bar extends Foo {
    public void doSomething() {
        System.out.println("yolo");
        Zoom zoom = new Zoom(this);
    }
}
```
Classic example for escaping references.
When an object of Bar is created, the super constructor in Foo gets called first, which in turn calls the ‘overridden’ doSomething method.
The doSomething method passes the this instance to the class Zoom. Zoom now can use the ‘this‘ instance before it is created entirely. BAD!!!

# Why do you need to use synchronized methods or blocks?
If threads are being used and a number of threads have to go through a synchronized section of code, only one of them may be executed at a time. This is used to make sure shared variables are not updated by multiple threads.

# What is the difference between HashMap and ConcurrentHashMap?
ConcurrentHashMap is thread-safe; that is the code can be accessed by single thread at a time
 while HashMap is not thread-safe. ConcurrentHashMap does not allow NULL keys while HashMap allows it.

# When do you need to override the equals and hashCode methods in Java?
By defining equals() and hashCode() consistently, the candidate can improve the usability of classes as keys in hash-based collections such as HashMap.

# What is a Service?
A service is a function that is well-defined, self-contained, and does not depend on the context or state of other services.

# What is a good usecase of calling System.gc()?
One may call System.gc() when profiling an application to search for possible memory leaks. All the profilers call this method just before taking a memory snapshot.

# What is the marker interface in Java?
The marker interface in Java is an interfaces with no field or methods.
 In other words, it an empty interface in java is called a marker interface. 
An example of a marker interface is a Serializable, Clonable and Remote interface. These are used to indicate something to the compiler or JVM.

# How are Annotations better than a Marker Interfaces?
Annotations lets one achieve the same purpose of conveying metadata about the class to its consumers without creating a separate type for it. Annotations are more powerful, too, letting programmers pass more sophisticated information to classes that “consume” it.
What are checked and unchecked exceptions? When do you use them?
A checked exception is an exception that must be catch, they are checked by the compiler. 
An unchecked exception is mostly runtime exception, and is not required to be catch. In general, use checked exception when the situation is recoverable (retry, display reasonable error message).
int a = 1L; won’t compile and int b = 0; b += 1L; compiles fine. Why ?
When += is used, that’s a compound statement and the compiler internally casts it. 
Whereas in the first case, the compiler straightaway shouts at you since it is a direct statement.
Compiler behavior and statement types can be confusing, so questions like this will test a candidate's grasp of these concepts.

# Why aren’t you allowed to extend more than one class in Java but are allowed to implement multiple interfaces?
Extending classes may cause ambiguity problems.
 On the other hand, in terms of interfaces, the single method implementation in one class can serve more than one interfaces.

# Why doesn’t the following code generate a NullPointerException even when the instance is null?
``` java
Test t = null;
t.someMethod();
public static void someMethod() {
  ...
}
```
There is no need for an instance while invoking a static member or method, 
since static members belongs to a class rather than an instance.
A null reference may be used to access a class (static) variable without causing an exception.

``` java
public class Test
{
    public static void main(String[] args)
    {
        Integer a = 1000, b = 1000;
        System.out.println(a == b);
        Integer c = 100, d = 100;
        System.out.println(c == d);
    }
}
```
outputs:
false
true
Why is the code printing true in the second and false in the first case?
JVM’s cache behavior can be confusing, so this question tests that concept. 
The second output is true as we are comparing the references, 
because the JVM tries to save memory when the Integer falls within a range (from -128 to 127).
 At point 2, no new reference of type Integer is created for ‘d’. Instead of creating a new object
 for the Integer type reference variable ‘d’, it is only assigned
 with a previously created object referenced by ‘c’. All of these are done by JVM.

# How do you check if the given 2 Strings below are Anagrams or Not?
``` java
String s1="home";
String s2="mohe";
boolean result = new String(Arrays.sort(s1.toCharArray()))
                  .equals(new String(Arrays.sort(s2.toCharArray())));
```

How do you reverse String("Java Programming") without using Iteration and Recursion?

System.out.println("reverse = " + new StringBuilder(givenString).reverse());


— Give real world examples of when to use an ArrayList and when to use LinkedList.
ArrayList is preferred when there are more get(int), or when search operations need to be performed as every search operation runtime is O(1).
If an application requires more insert(int) and delete(int) operations, then LinkedList is preferred, 
as LinkedList does not need to maintain back and forth to preserve continued indices as arraylist does. Overall this question tests the proper usage of collections.

— What is the difference between an Iterator and a ListIterator ?
This question tests the proper usage of collection iterators. One can only use ListIterator to traverse Lists, and cannot traverse a Set using ListIterator.
What’s more, one can only traverse in a forward direction using Iterators.
 Using ListIterator, one can traverse a List in both the directions (forward and backward).
One cannot obtain indexes while using Iterator. Indexes can be obtained at any point of time while traversing a list using ListIterator.
 The methods nextIndex() and previousIndex() are used for this purpose.

— What is the advantage of generic collection?
They enable stronger type checks at compile time.
A Java compiler applies strong type checking to generic code, and issues errors if the code violates type safety. Fixing compile-time errors is easier than fixing runtime errors, which can be difficult to find.

