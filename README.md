Scala Design Patterns
=====================

This repository contains the code that goes with the **Scala Design Patterns** book.

### Project Structure

The source code for the book is presented as amulti-module Maven project and it contains different modules for the following chapters:

1. Chapter 1 - The Design Patterns Out There and Setting Up Your Environment.

    There is no code for this chapter. It provided the users with some skeletons.

2. Chapter 2 - Traits and Mixin Compositions.
    
    a. Module name: **traits**.
     
3. Chapter 3 - Unification.

    a. Module name: **unification**.

4. Chapter 4 - Abstract and Self Types.

    a. Module name: **abstract-types**.

5. Chapter 5 - Aspect Oriented Programming and Components.

    a. Module name: **aop**.

6. Chapter 6 - Creational Design Patterns.

    a. Module name: **creational-design-patterns**.

7. Chapter 7 - Structural Design Patterns.

    a. Module name: **structural-design-patterns**.

8. Chapter 8 - Behavioral Design Patterns - Part 1.

    a. Module name: **behavioral-design-patterns**.

9. Chapter 9 - Behavioral Design Patterns - Part 2.

    a. Module name: **behavioral-design-patterns**.

10. Chapter 10 - Functional Design Patterns – The Deep Theory.

    a. Module name: **deep-theory**.

11. Chapter 11 - Functional Design Patterns – Applying What We Learned.

    a. Module name: **functional-design-patterns**.

12. Chapter 12 - Real Life Applications.

    a. Module name: **real-life-applications**.
    b. Module name: **job-scheduler**.
    
### Running the Code

Running the code is pretty straightforward from here and anyone with some minor Maven experience should manage.

#### Compiling the Projects

`mvn clean compile`

#### Running the Unit Tests

`mvn clean test`

The test command will also run the compile one.

#### Creating the Jars

`mvn clean package`