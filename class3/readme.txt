# Java String

> String is basically an object that represent sequence of char values
> An array of characters works same as java string

char[] ch = {'h','e','l','l', 'o'}
String str = new String(ch);

or

String str = "Hello";

In Java.lang contain a class String which implemnets Serializable, Comparable, CharSequence interface

# CharSequence interface
The CharSequence interface is used the sequence of characters.

String
StringBuffer
StringBuilder


The Java String is immutable which means it cannot be changed, whenever we change any string a new instance is created
For mutable strings we can use StringBuffer and StringBuilder class


# There are two ways we can create a string object
1. by string literal
2. by new keyword

1. String Literal
using double quotes we can create string 

String str = "hello";

Each time you create a string literal, the JVM check the string constact pool, if the string exists in the pool, a reference to 
the pooled instance is returned. If the string doesn't exists in the pool, a new string is created and placed in the pool



2. by new keyword

String str = new String("Hello");

JVM will create a new string object in noraml heap memory and the literal "hello" will be placed in the string constant pool.
the variable str will refer to the object in the heap


# String class provides various methods
charAt()
length()
subString()
contains()
join()
equals()
isEmpty()
concat()

# Immutable String in java
In java string objects are immutable - means unchangeable or unmodifiable
once string object is created its data or state cannot be changed but we can create a new instance


Why string objects are immutable in java?
beacuse java uses the concept of string literal
suppose theer are 10 refrence variable all refer to one object "Hello"
if one refrence variable changes the valkue of the object it will affected to all reference varaible
that is why string object are immutable in java


# Compare String

we can compare String in java on the basics of content and reference

There are 3 ways we can compare String in java
1. using equals() method
2. by using == opeartor
3. compareTo() method

# By using equals() method

the string class equals() method compares the original content of the string.
It compares values of string for equality


boolean equals(Other object)  // compare the string to the other object
boolean equalsIgnoreCase(Other object)  // compare the string to the other string ignoring case


2. using == opeartor
The == operator compares references not value

3. using compareTo() method
String class compareTo() method compares values and return an interger that describe if first string is less then equal to
or greater the second string

s1 and s2

s1==s2 // 0
s1 > s2  // positive
s1 < s2  // negative

# String Concatenation
In java string concatenation means a new string that is the combination of multiple string

There are 2 ways we can concat string in java
1. using + operator
2. using concat() method

1. using + operator
in java string concatenation is implemented throgh the stringBuilder / stringBuffer class and its append method.
String concatenation operator produces a new string by appending the second operant into the end of the first opearnd
the string concatenation operator can concat not only string but primitive values also


2. using concat() method
string concat method will concatenats the specific string to the end of current string

public String concat(String another)


# Substring in java 
> A substring is a part of string
> Java provide a built-in method substring() that extract a sybstring from the given string using the index value passed as an
  argument

substring(int startIndex)
substring(int startIndex, int endIndex)

startIndex - inclusion
endIndex - exclusion

example:

System.out.println("Original message: "+ message);
System.out.println("Substring starting from index 7: "+ message.substring(7));
System.out.println("Substring starting from index 0 to 7: "+ message.substring(0,7));


String str1 = "Hello";
String str2 = "World";
String str3  ="HelloWorld";


# Split() method
split() method of a string class can be used to extract a substring from a phrase. it accepts argument in the form of regular
expression



# Java StringBuffer class
In Java StringBuffer class is used to create mutable (changable) String object
It is same as String class except it is mutable ie it can be changed


# StringBuffer class Constructor
> StringBuffer()  with initial capacity of 16
> StringBuffer(String str) - it create an object with specified string
> StringBuffer(int capacity) - it create an object with empty String buffer but we can specified capacity as length


# StringBuffer methods
append()
insert()
replace()
delete()
reverse()
capacity()
chatAt()
length()


# insert() - this will insert the given string with this string at the given position
# delete()
# replace()
# reverse()
# capacity()

The default capacity of the buffer is 16, if the number of character increses from its current capacity. it increase the capacity
(oldCapacity * 2)+ 2 

default capacity = 16


(16 *2)+ 2 = 34;


# StringBuilder
In Java StringBuilder clas is used to create mutable string.
The Java StringBuilder class is same as StringBuffer class except that it is not synchronized

stringBuilder has almost all method same as stringbuffer

append()
insert()
replace()
delete()
reverse()
capacity()



# String vs StringBuffer

String:
> it is immutable
> string is slow and consume more memory when you concat too many string 
> string class override the equals() method of object class so can compare the contents of two string by equals() method

StringBuffer
> it is mutable
> it is fast and consumne less memory when you concat strings
> it doesnot override the equals() method of object class





# StringBuffer vs StringBuilder

StringBuffer
> It is synchorized ie thread safe
> stringBuilder is less efficient 

StringBuilder
> it is non-synchronized ie not thread safe
> it is more efficient



# Exception Handling
Exception is an event which occurs during the execution of a program that cause the application or program to terminate 
inappropriately

we can handle the exception using
1. try
2. catch
3. finally
4. throw
5. throws

# Type of exception
there are mainly two type of exception are checked and unchecked, however there are some errors which also considered as uncheck exception
1. checked
2. unchecked
3. error


# Checked exception:
as also knows as compile time exception which means these exception we must handle at compile time for ex: IOException, SQLException

# Uncheck exception
as also knows as runtime excepotion which means these exception are dangerous and if not handled it may cause your application
to terminate inappropriately ex: NullPointerException, ArryIndexOutOfBound() unchecked exception are not checked
at compile time buy they are checked at runtime

# Error
errors are irrecoverable eg: OutOfMemoeryError, VirtualMachineError


# try
> any code or statment which we feel is risky or can cause an exception we will write inside the try block

# Catch
> whenever any exception happen it will get the control and you can add any alternative or error handling code in the
  catch block

# finally
> no matter exception happens or not it will give you guarantee to excute the code
> when you want to excute any piece of code even excpetion happed or not we can write inside the finally block

example: open the connection and we want to make sure connection get closed so we can connection close code inside the finally


Demo - Finally
case 1. exception doesn't occur
case 2. exception occurs and not handled
case 3. exception occurs and handle

throw: it is keyword is used to explicity throw an exception
we can use throw keyword to either throw check or unchecked exception in java


# throw vs throws
throw
1. Java throw keyword is used to explicity throw an exception
2. checked exception cannot be propogated using throw only
3. it is followed by an instance
4. it is used within the method

throws
1. java throw keyword is used to declare an exception
2. checked exception can be propagated with throw
3. it is followed by class
4. it is used with the method signature

# final vs finally vs finalize

1. final
It is used to apply restriction on variable, method and class, final class can't inherited, final method can't be overridden,
final variable value cann't be changed

final is a keyword

2. finally
finally is used to place important code, it will be executed wheather excpetion is handled or not

finally is a block

3. finalize
finalize is used to perform clean up processing just before object is garbage collected

finalize is a method


# Top 10 exception
1. NullPointerException
2. ArrayIndexOutOfBoundException()
3. StackOverFlowException()
4. ClassCastException()
5. IllegalArgumentException()
6. NumberFormatExcpetion()
7. IllegalStateException()
8. NoClassDefFoundException()
9. AssertException()
10 ArithmaticExcpetion()


# Try eith resouces 
In Java, try with resouces statement is a try statemnent that declares one or more resouces in it.
A resource is an object that must be closed once your program is done using it

try(declare resouces ){
// use resouces

}









