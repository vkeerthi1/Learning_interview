SOLID is one of the most popular sets of design principles in object-oriented software development. It’s a mnemonic acronym for the following five design principles:

Single Responsibility Principle
Open/Closed Principle
Liskov Substitution Principle
Interface Segregation Principle
Dependency Inversion


Single Responsibility Principle:
A class should have one, and only one, reason to change.
Benefits:
1.Frequency and effects of changes
We all know that requirements change over time. Each of them also changes the responsibility of at least one class. The more responsibilities your class has, the more often you need to change it. If your class implements multiple responsibilities, they are no longer independent of each other.
2.Easier to understand
The single responsibility principle provides another substantial benefit. Classes, software components and microservices that have only one responsibility are much easier to explain, understand and implement than the ones that provide a solution for everything. This reduces the number of bugs, improves your development speed, and makes your life as a software developer a lot easier.

Examples:
JPA EntityManager
The EntityManager interface provides a set of methods to persist, update, remove and read entities from a relational database. Its responsibility is to manage the entities that are associated with the current persistence context.
That is the only responsibility of the EntityManager. It doesn’t implement any business logic or validation or user authentication. Not even the application-specific domain model, which uses annotations defined by the JPA specification, belongs to the responsibility of the EntityManager. So, it only changes, if the requirements of the general persistence concept change.

Open/Closed Principle:
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.”
inheritance introduces tight coupling if the subclasses depend on implementation details of their parent class.

Liskov Substitution Principle:
The principle defines that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application. That requires the objects of your subclasses to behave in the same way as the objects of your superclass.
An overridden method of a subclass needs to accept the same input parameter values as the method of the superclass.That means you can implement less restrictive validation rules, but you are not allowed to enforce stricter ones in your subclass. Otherwise, any code that calls this method on an object of the superclass might cause an exception, if it gets called with an object of the subclass.
•
Similar rules apply to the return value of the method. The return value of a method of the subclass needs to comply with the same rules as the return value of the method of the superclass.You can only decide to apply even stricter rules by returning a specific subclass of the defined return value, or by returning a subset of the valid return values of the superclass.


Interface Segregation Principle:
Clients should not be forced to depend upon interfaces that they do not use.”
Violating the Interface Segregation Principle
None of us willingly ignores common design principles to write bad software. But it happens quite often that an application gets used for multiple years and that its users regularly request new features.
From a business point of view, this is a great situation. But from a technical point of view, the implementation of each change bears a risk. It’s tempting to add a new method to an existing interface even though it implements a different responsibility and would be better separated in a new interface.That’s often the beginning of interface pollution, which sooner or later leads to bloated interfaces that contain methods implementing several responsibilities.

Dependency Inversion:
High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend on details. Details should depend on abstractions.
