package com.Prac.Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierEg
{
    public static void main( String[] args ) throws InterruptedException, BrokenBarrierException
    {
        CyclicBarrier cb = new CyclicBarrier( 5, new CyclicBarrrierEvent() );

        ExecutorService service = Executors.newFixedThreadPool( 5 );

        while( Printer.counter < Printer.limit )
        {
            for( int i = 0; i < 5; i++ )
                service.execute( new Printer( cb, i ) );
        }

        service.shutdown();
        service.awaitTermination( 1, TimeUnit.DAYS );
        System.out.println( "---------completed ---------------------" );

    }

}

class Printer implements Runnable
{
    private CyclicBarrier cb;

    public static volatile int counter = 0;

    public static final int limit = 10;

    private int ThreadId;

    public Printer( CyclicBarrier c,
        int id )
    {
        this.cb = c;
        this.ThreadId = id;
    }

    @Override
    public void run()
    {

        if( counter < limit )
        {
            synchronized( cb )
            {

                counter++;
                System.out.println( counter + " ----> " + ThreadId );

            }
        }

        try
        {
            TimeUnit.MILLISECONDS.sleep( 100 );
            cb.await();
        }
        catch( InterruptedException | BrokenBarrierException e )
        {
            e.printStackTrace();
        }

    }

}

class CyclicBarrrierEvent implements Runnable
{

    public void run()
    {
        System.out.println( " -----------------------------------------  " );
        System.out.println( "As all threads have reached common barrier point " + ", CyclicBarrrierEvent has been triggered" );
        System.out.println( " -----------------------------------------  " );
    }

}
