##### What is the meaning of S.O.L.I.D?
Solid represents five principles of java which are:

* S: Single responsibility principle
*  O: Open-closed principle
* L: Liskov substitution principle
*  I: Interface segregation principle
*  D: Dependency inversion principle

#### Open Closed Principle in Java
the class should remain closed for modification, but it should have the option to get extended. Ways of extending the class include:

* Inheriting from the class
* Overwriting the required behaviors from the class
* Extending certain behaviors of the class

An excellent example of open-closed principle can be understood with the help of browsers. Do you remember installing extensions in your chrome browser?
```
Basic function of the chrome browser is to surf different sites.

Do you want to check grammar when you are writing an email using chrome browser?
If yes, you can simply use Grammarly extension, it provides you grammar check on the content.

This mechanism where you are adding things for increasing the functionality of the browser is an extension. 
Hence, the browser is a perfect example of functionality that is open for extension but is closed for modification.

In simple words, you can enhance the functionality by adding/installing plugins on your browser, but cannot build anything new.
```

Why is that this principle is required?
OCP is important since classes may come to us through third-party libraries. We should be able to extend those classes
without worrying if those base classes can support our extensions. But inheritance may lead to subclasses which depend on base class implementation.
To avoid this, use of interfaces is recommended. This additional abstraction leads to loose coupling.
