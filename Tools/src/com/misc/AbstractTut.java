package com.misc;

abstract class Base
{
    int var;

    public Base( int var )
    {
        this.var = 10;
    }

    Base()
    {
        System.out.println( "Base Constructor Called" );
    }

    abstract void fun();

}

abstract class Base1 extends Base
{

    void bun()
    {
    }

}

class Derived extends Base1
{
    Derived()
    {
        System.out.println( "Derived Constructor Called" );
    }

    @Override
    void fun()
    {
        // TODO Auto-generated method stub

    }

}

abstract class Abstrat
{
    Abstrat()
    {
        m1();
        m2();
    }

    abstract void m1();

    void m2()
    {
        m1();
    }

}

public class AbstractTut extends Abstrat
{

    public static void main( String args[] )
    {
        AbstractTut abs = new AbstractTut();

    }

    @Override
    void m1()
    {
        System.out.println( "m1" );

    }
}
