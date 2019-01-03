package com.Prac.Threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueuePrac
{
    public static void main( String[] args )
    {
        BlockingQueue<Integer> bQ = new SynchronousQueue<>();
        Prod p = new Prod( bQ );
        Cons c = new Cons( bQ );

        Thread prod = new Thread( p );
        Thread cons = new Thread( c );

        prod.start();
        cons.start();

    }

}

class Prod implements Runnable
{
    private BlockingQueue<Integer> q;

    Prod( BlockingQueue<Integer> q )
    {
        this.q = q;

    }

    @Override
    public void run()
    {
        while( true )
        {
            Integer i = new Random().nextInt( 100 );
            try
            {
                q.put( i );
                System.out.println( "Prod : " + i );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }

        }

    }

}

class Cons implements Runnable
{
    private BlockingQueue<Integer> q;

    Cons( BlockingQueue<Integer> q )
    {
        this.q = q;

    }

    @Override
    public void run()
    {
        while( true )
        {
            try
            {
                System.out.println( "Queue Size : " + q.size() );
                Thread.sleep( 1000 );
                System.out.println( "Cons" + q.take() );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }

        }

    }

}