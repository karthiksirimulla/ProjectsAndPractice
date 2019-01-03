package com.misc;

class A
{
    public void method()
    {
        System.out.println( "Method from A" );
    }

}

class B extends A
{
    public void method()
    {
        System.out.println( "Method from B" );
    }

}

public class C extends B
{

    public static void main( String[] args )
    {
        A a = new B();

        if( a instanceof B )
        {
            System.out.println( " a instanceof B  " );

        }

        if( a instanceof C )
        {
            System.out.println( " a instanceof C  " );

        }

        if( a instanceof A )
        {
            System.out.println( "a instanceof A" );
        }

    }

}