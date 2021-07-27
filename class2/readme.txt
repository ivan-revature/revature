# Static

The static keyword in Java is used for memory management. 
We can use static keywords with variables, methods, blocks, and nested classes.

Static variable
> the static variable can be used to refer to the common property of all objects

The static variable will get memory only once. If an object changes the value of the static variable, it will retain its value.

# Static Methods
If we apply a static keyword with any method, it will be known as a static method.

> A static method belongs to the class rather than the object of a class
> A static method can be invoked without the need for creating an instance of a class
> A static method can access static data member and can change the value of it

# Static block
> it is used to initialize the static data members
> It is executed before the main method at the time of classloading

Note:  Static members can only access static members only


# Polymorphism
> This is one of the main pillars of OOP
> Poly (many) + morph(shape)
> this allows you to invoke the derived class method through a base class reference during runtime


# There are two types of polymorphism
1. static / compile time
2. dynamic / runtime 


Method overloading - static
Method overriding - dynamic


# Method overloading
> In this case, we define multiple methods with the same name by changing their parameters
> This can be performed either within a class as well as between parent and child class also
> method overloading is all about defining multiple or adding behavior to a method

Condition for method overloading
1. different number of parameter
2. different types of parameter
3. different order of parameter
4. different return type  -  NO 


# Method Overriding
> Method overriding is used to provide the specific implementation of a method that is already provided by the super-class
> method overriding is used for runtime polymorphism
> it is all about changing the behavior
> in this case, we define multiple methods with the same name and same parameter
> this can be performed only between parent and child class and never can be done within the class


# final
> the final keyword in Java is used to restrict the user
> final keyword can be used in many contexts
1. variable
2. method
3. class

> when we use final keyword with variable, it becomes constant means its value cannot be changed
> When we use the final keyword with the parent class method, the child cannot override that method
> when we use the final keyword with class, no other class can able to inherit from that class


# Abstraction
Abstraction is a process of hiding the implementation details and showing only functionality to the user.

In another way, it shows only essential things to the user and hides the internal details.

# Abstract class and method

> A class which declared with abstract keyword is know as abstract class
> Abstract class can contain abstract as well as non-abstract methods
> Abstract class consider as incomplete hence we cannot able to create an instance of the abstract class
> Abstract can always be super-class
> the class derived from the abstract class is responsible for providing the implementation or body of the abstract methods
> A non-abstract class derived from the abstract class must provide the implementation of all abstract methods


> Abstract method cannot have body or implementation, and if we try to do so, it will be a compile-time error
> only abstract classes contain abstract methods


Demo15, Demo16

Rectangle, circle, cone, triangle

width, height, radius, pie, height


# Interface vs. Abstract class
1. interface is used to achieve 100% abstraction, whereas abstract classes are used for partial abstraction
2. interface can inherit from multiple inheritances, whereas abstract class is a class which means cannot be inherited from
  more than one class


#  Interface
> It is a kind of a contract which needs to be fullied by a class
> An interface in Java is a blueprint of a class
> It has static constants and abstract method
> it is a compile-time error to provide an implementation for any interface member
> if a class inherit from an interface, it must provide an implementation for all interface members
> interface can also inherit from another interface. A class that inherits from this interface must provide 
  implementation for all interface members in the entire interface chain
> we can not create an instance of an interface
> we can hold the reference of a class that has implemented interface in interface instance

Java 8, we can have default and static methods in an interface
Java 9, we can have private methods in an interface


Note: by default, interface fields are public, static, and final, and the method is public and abstract.

Multiple inheritances in Java are possible with the help of the interface.

> Default method in interface
Since java 8, we can have a method body in the interface, but we need to make it the default method.

> Static method in interface
Since java 8, we can have a static method in the interface.

# nested interface 


# OOPs
> Inheritance
> Abstraction
> Polymorphism
> Encapsulaion


# Encapsulation 
It means hiding your method, variables with the help of access modifiers.

> Packages
> Access Modifiers


# Packages
In java, a package is a group of similar types of classes, interfaces, and sub-packages
Packages in java can be categorized in two forms, 
1. built-in packages
2. user-defined packages

there are many built-in packages are available in java for example, lang, awt, swing, io, util, SQL, etc


# Adavantages
1. packages are used to categorize the classes and interface so that they can be easily maintained
2. java packages provide access protection
3. java packages removes naming collision

package myPack;

class A{
}

class B{
}



import myPack.A;


# Access Modifiers in Java
There are two types of modifiers
1. access modifiers
2. non-access modifiers

# Access- modifiers
1. private
2. default
3. protected
4. public


Private - the access level of a private modifier is only within the class. it cannot be accessed from outside the class

Default - the access level of a default modifier is only within the package. It cannot be accessed from outside the package
	   if we don't specify any access level, it will be the default

Protected - the access level of a protected modifier is within the package and outside the package through child class.
 	    if we do not make the child class, it cannot be accessed from outside the package

Public - the access level of a public modifier is everywhere. it can be accessed within the class, outside the class, within
         package and outside the package


Problem
id = should not be a negative number
name = should not be null
pass mark = should be read-only














