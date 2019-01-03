package com.Threads;

public class Print
{
    volatile int count = 0;

    final int LIMIT = 10;

    private Object obj = new Object();

    public void printEven() throws InterruptedException
    {
        while( count < LIMIT )
        {
            synchronized( obj )
            {
                while( count % 2 != 0 )
                {
                    obj.wait();
                }
                System.out.println( "Thread 1: " + count );
                count++;
                obj.notifyAll();
            }
        }

    }

    public void printOdd() throws InterruptedException
    {
        while( count < LIMIT )
        {
            Thread.sleep( 1000 );
            synchronized( obj )
            {
                while( count % 2 == 0 )
                {
                    obj.wait();
                }
                System.out.println( "Thread 2: " + count );
                count++;
                obj.notifyAll();
            }
        }

    }

}
