package com.misc;

class Based
{

    // Static method in base class which will be hidden in subclass 
    public static void display()
    {
        System.out.println( "Static or class method from Base" );
    }

    // Non-static method which will be overridden in derived class 
    public void print()
    {
        System.out.println( "Non-static or Instance method from Base" );
    }
}

// Subclass
class Derive extends Based
{

    // This method hides display() in Base 
    public static void display()
    {
        System.out.println( "Static or class method from Derived" );
    }

    // This method overrides print() in Base 
    public void print()
    {
        System.out.println( "Non-static or Instance method from Derived" );
    }
}

// Driver class
public class BaseTest
{
    public static void main( String args[] )
    {
        Based obj1 = new Derive();

        // As per overriding rules this should call to class Derive's static 
        // overridden method. Since static method can not be overridden, it 
        // calls Base's display() 
        obj1.display();

        // Here overriding works and Derive's print() is called 
        obj1.print();
    }
}
