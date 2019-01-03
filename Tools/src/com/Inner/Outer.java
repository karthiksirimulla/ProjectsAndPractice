package com.Inner;

interface phone
{
    void call();

}

public class Outer
{
    int i;

    class Inner
    {
        int j;

    }

    static class InnerStatic

    {
        int k;

    }

    public void print()
    {
        System.out.println( "From the old method..." );
    }

    public static void main( String[] args )
    {
        Inner innerObj = new Outer().new Inner();
        innerObj.j = 5;

        InnerStatic innerStaticObj = new InnerStatic();

        innerStaticObj.k = 5;

        Outer o = new Outer()
        {
            public void print()
            {
                System.out.println( "From the Anonymous method..." );
            }
        };

        o.print();

        phone p = new phone()
        {

            @Override
            public void call()
            {
                System.out.println( "calling...." );

            }
        };
        p.call();

        phone p1 = () -> System.out.println( "JAVA 8 calling" );

        p1.call();
    }

}
