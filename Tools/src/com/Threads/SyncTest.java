package com.Threads;

class Creation implements Runnable
{
    static int objectCount = 0;

    public Creation()
    {

        objectCount++;

    }

    @Override
    public void run()
    {
        objectCount++;

    }

}

class Test extends Thread
{

}

public class SyncTest
{
    public static void main( String[] args ) throws InterruptedException
    {
        Creation c = new Creation();
        Thread t1 = new Thread( new Runnable()
        {

            @Override
            public void run()
            {
                for( int i = 0; i < 5; i++ )
                {
                    System.out.println( "t1 -" + i );
                    new Creation();
                }
            }

        } );

        Thread t2 = new Thread( new Runnable()
        {

            @Override
            public void run()
            {
                for( int i = 0; i < 5; i++ )
                {
                    System.out.println( "t2 -" + i );
                    new Creation();
                }
                t1.interrupt();

            }
        } );
        t1.start();
        t2.start();
        System.out.println( c.objectCount );

        Test t = new Test();
        t.start();

    }

}
