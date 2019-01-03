package com.Prac.Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchEg
{
    public static void main( String[] args ) throws InterruptedException
    {
        CountDownLatch lLatch = new CountDownLatch( 14 );

        ExecutorService service = Executors.newFixedThreadPool( 5 );

        for( int i = 0; i < 14; i++ )
            service.execute( new CountDownTask( lLatch, i ) );

        lLatch.await();
        service.shutdown();
        System.out.println( "------------- Completed ---------------" );
        service.awaitTermination( 1, TimeUnit.DAYS );

    }

}

class CountDownTask implements Runnable
{
    private CountDownLatch lLatch;
    private int ThreadId;

    public CountDownTask( CountDownLatch l,
        int i )
    {
        this.lLatch = l;
        this.ThreadId = i;
    }

    @Override
    public void run()
    {

        //System.out.println( "Came In ---> " + ThreadId );
        try
        {
            System.out.println( "Working ---> " + ThreadId );
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

        lLatch.countDown();
        //System.out.println( lLatch.getCount() );

    }

}
