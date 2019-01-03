package com.Prac.Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrintNumbers
{
    public static void main( String[] args )
    {
        // Create the workers
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        Worker w3 = new Worker();
        Worker w4 = new Worker();
        Worker w5 = new Worker();

        // chain them in a round robin fashion
        w1.setNext( w2 );
        w2.setNext( w3 );
        w3.setNext( w4 );
        w4.setNext( w5 );
        w5.setNext( w1 );

        // Create named threads for the workers
        Thread t1 = new Thread( w1, "Thread-1 - " );
        Thread t2 = new Thread( w2, "Thread-2 - " );
        Thread t3 = new Thread( w3, "Thread-3 - " );
        Thread t4 = new Thread( w4, "Thread-4 - " );
        Thread t5 = new Thread( w5, "Thread-5 - " );

        // start the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Seed the first worker
        w1.accept( 1 );
    }

}

class Worker implements Runnable
{

    BlockingQueue<Integer> bQ = new LinkedBlockingQueue<>();
    Worker next = null;
    static final int limit = 10;
    static int counter = 1;

    public void setNext( Worker w )
    {
        this.next = w;
    }

    public void accept( int i )
    {
        bQ.add( i );
    }

    @Override
    public void run()
    {
        while( counter < limit )
        {
            try
            {
                int i = bQ.take();
                System.out.println( Thread.currentThread().getName() + " - " + "i" + " - Counter - " + counter );
                Thread.sleep( 100 );
                counter++;
                if( next != null )
                {
                    next.accept( i + 1 );
                }

            }
            catch( InterruptedException e )
            {
                System.err.println( Thread.currentThread().getName() + " interrrupted." );
            }

        }
    }

}