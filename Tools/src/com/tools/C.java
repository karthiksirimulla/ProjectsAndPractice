package com.tools;

class A
{
    static int number;

    static
    {
        System.out.println( "A Static" );
    }
    {
        System.out.println( "A init ..." );
    }

    A()
    {
        System.out.println( "A Constructor ..." );
        number = 10;
    }

    public void method()
    {
        System.out.println( "A method..." );
    }

}

class B extends A
{

    static
    {
        System.out.println( "B Static" );
    }
    {
        System.out.println( "B init ..." );
    }

    B()
    {
        System.out.println( "B Constructor ..." );
    }

    @Override
    public void method()
    {
        System.out.println( "B method..." );
    }

}

public class C extends B
{

    static
    {
        System.out.println( "C Static" );

    }
    {

        System.out.println( "C init ..." );
    }

    C()
    {
        System.out.println( "C Constructor ..." );

    }

    @Override
    public void method()
    {
        System.out.println( "C method..." );
    }

    public static void main( String[] args )
    {
        A a = new B();
        new B();
        System.out.println( a.number );
        a.method();

    }

}
