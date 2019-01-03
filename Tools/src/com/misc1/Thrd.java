package com.misc1;

class A implements Runnable
{

    @Override
    public void run()
    {
        System.out.println( Thread.currentThread().getName() );

    }

}

public class Thrd
{
    public static void main( String[] args )
    {
        A a = new A();
        Thread t = new Thread( a );
        t.setName( "PiPi" );
        t.start();
    }

}
