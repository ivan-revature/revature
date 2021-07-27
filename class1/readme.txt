# What is Java?

Java is a programming langugage
It is high level, robst, object oriented and secure programming langugage


# Type of App
1. Desktop application such as note
2. Web Application
3. Enterprise app such banking, insurence app
4. Mobile
5. Embedded system
6. Games

# Java Editions
1. Java SE (standard edition)
2. Java EE (Enterprise edition)
3. Java ME (Micro edition)
4. JavaFX


# Features
1. Simple
2. Object Oriented
3. Platform independent
4. Secured 
5. Robust
6. Portable
7. Hign Performance
8. Multi-threaded


# difference between JDK, JRE and JVM
JDK - Java developer Kit
JVM - Java Virtual Machine
JRE - Java Run time

JVM
> It is called a virtual machine because it does not exist physically
> It provide specification in which java bytecode can be executed

what are the main task perform by JVM
1. Loads code
2. verifiy code
3. execute code
4. provide runtime enviornmant


# JRE
The Java run time enviornment is a set of software tool which are used for developing java application
> It contains a set of libraries + other files that JVM uses at run time

# JDK
Java development kit
It is a software development kit whicb is used to develop java application
JDK contain a private JVM and few other resouces such as compiler, loader, etc



# JVM Architecture

It is a specification where working of java virtual machine is specified
It is an implementation and its implementeation is know as Java runtime env
It is runtime instance wherever you write java command on the command prompt to run the java class, an instance of JVM is created



1. Class Loader - it is subsystem of JVM which is used to load class files. whenever we run the java program it is loaded first by the
class loader and there are 3 built in class loader in java

> bootstrap class loader
> extension class loader
> system / application class loader

2. Class Area
3. Heap
4. Stack
5. Program Counter Register
6. Native Method stack

7. Execution Engine
> A virtual processer
> Interpreter
> Just-In-Time (JIT) compiler

8. Java Native Interface


# First Java Program

class Hello{
   public static void main(String args[]){
      System.out.println("Hello World")
   }
}


> class keyword is used to declare a class in java
> public keyword is an access modifier which decide the visibility
> static is a keyword used to create a static method which can be access directly by the class name
> void is a return type it mean thsi method does not return any value
> main represent the starting point of the program
> String[] arg is used to for command line argument
> System.out.println() it is used to print statement

Note:
1. java is case sensative
2. in the entire app we can have only one main method
3. main method is the start point of the programe
4. all statements in java should end with semicolon


# Java Variables
A variable is a container which holds the value while java program is executed
A variable is assigned with a data type
variable is a name of memort location

There are three type of variables
1. local 
2. instance
3. static

# Local Variable
A variable declared inside the body of the method is called local variable, you can use this variable only within that method and 
other method in the class cannot aware of the variable

# Instance variable
A variable declared insid the class but outside the body of the method
it is called instance variable because its value is instance specific and is not shared amoung the instance

# static variable
variable that is declared with static keyword are called static variable
it cannot be local variable
static variable are shared among all instaces of the class
memory allocation for variable happens only once when the class is loaded in the memoery


# Data Types 
Data type specify the different sizes and values that can be store in the variable

Data types are of two types
1. Primitive type - simple type - char, boolean, int, long, float etc
2. Non Primitive type - complex type - classes, interface and arrays


Data type		Default size
boolean				1 bit
char				2 byte
byte				1 byte
short				2 byte
int				4 byte
long				8 byte
float				4 byte
double				8 byte


# Operators 
> unary opeartor
> Arithmetic
> Shift
> Relational 
> Bitwise
> logical 
> ternary
> Assignment


# Unary 	-	expr++
# Arithmatic	-	+ - * / %
# Shift		-	>> << 
# Relational	- 	> < >= <= !=  ==  ===
# Bitwise	- 	& |
# Logical	- 	&& ||
# ternary 	-	? :
# Assignment	- 	= += -= *= 


# Keywords
1. class
2. static
3. abstract
4. boolean
5. continue
6. break
7. for
etc

# Conditional Statment
> if statement
> if-else statement
> if elseif else statement
> nested if statement


if(condition){
 // code to be executed
}

# Switch
We can use switch statement to execute single statement from multipe conditions'


# Loops
In programming langugage loops are used to execute a set of instruction repeadly when some condition is true

There are 3 type of loops in java
1. for
2. while
3. do-while

for loop
we can initialze a variable, check condition amd increment/decrement value

syntex
------
for(initialzation; condition; incr/decr){
// statement
}


# While loops is used to iterate a part of a program repeatedly until the specified condition is true, as soon as boolean
condition become false the loop automatically stop

syntex
-----
while(condition){
//  statement
}

# do-while
will make sure to execute the loops atleast once befor checking the condition and then if condition is true keep executing
and if condition false terminate loop

syntex
------
do{
// statement
}while(condition)

# Jump statment

> break
> continue

break is used inside a loop to terminate the existing statement and resume the control from next statment

continue is used to step over the current statement

# OOPs (Object Oriented Programming)
Object means a real time entity such as car, chair, table etc
Object oriented programming is a methodology or paradigm to design a program using classes and objects
It simplifies software development and maintence by providing some key features

> object
> class

The four main pillers in OOP
1. inhritance
2. Polymorphism
3. Encapsulation
4. Abstraction

# Object
Any entity that has state and behaviour is known as object for example car, table, chair etc
An object can be define as an instance of a class. 
An object take some amount of space in the memory to maintaine its state (data)
object can communicate with the class properties and methods


# Class
A class is a logical container in which we can define methods and variables
A class can also be defined as a blue print from which you can create an individual object
class doesn't consume any space


# Class naming convention
> it should start with uppercase letter
> it should be start with character not number or any special character
> it should be title case if we have more then two words
> try to give a meaning full to a class


# What a class can contain
> Fields
> Methods
> Constructor
> Blocks
> Nested class and interface

class can contain members
> member variable
> member function / methods

Syntex
-------

<access_modifier> class <class_name>{
 
 // member variable
 <access_modifier> <data_type> <variable_name>;
 <access_modifier> <data_type> <variable_name>;

 // member methods
 <access_modifier> <return_type> <method_name>(<paraneters>){
  // method body
 }
}


# The new keyword is used to allocate memory at runtime.
All the object get memory in Heap memory area.

DRY - Dont repeat yourself

Method in Java - expose the behavior of object
Advatage
1. Code reusability
2. Code Optimization

# Constructor
> It is a special method present under the class responsable for initializing the class variable
> Constructor are the special method which get called immediately when we create the object of the class
> The name of the constructor method should be exactly the same name of the class in which it is present
> Each and every class require a constructor if we want to create the instance of the class
> it is responsibilty of a programmer to create a constructor for the class but if he fails to do so the compiler
  will create a default constructor or implicit constructor

# Type of constructor
> Default or parameter less constructor
> Parameterized constructor
> Copy constructor
> Static constructor





# Constructor overloading
To have more then one constuctor in a class
we have differentiate constructor on basic of parameters

1. diff number of parameters
2. diff type of parameters
3. diff order of parameters



# Inheritance
> It is a mechanism of consuming members of one class in another class by eastablishing parent and child relationship 
between the class
> It encourage the code reusability

Employee	-> Parent / base / super
FullTimeEmployee-> Child / derived / sub

Example:
Demo22
Demo24

> In inhertiance child class can consume members of its parent class as it is the owner of those members (except private member
of the parent class)
> Parent class constructor must be accessible to the child class otherwise inheritance will not be possible
> in inheritance child class can access parent class members but parent class can not access any member that is define in
  child class

# Advantage
1. Code reusability
2. reduce error
3. reduce time
4. more maintable code


# Type of inheritance
1. simple
2. multi-level
3. hirarchical
4. hybrod
5. multiple

Demo25 - inheritance
Demo26
Demo27












