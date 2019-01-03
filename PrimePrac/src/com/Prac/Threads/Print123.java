package com.Prac.Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Holder implements Runnable
{
    BlockingQueue<Integer> blockingQueue;
    Holder nextHolder;

    public Holder( BlockingQueue<Integer> blockingQueue )
    {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run()
    {
        try
        {
            while( true )
            {
                Integer take = blockingQueue.take();
                System.out.println( take );
                if( take > 100 )
                {
                    break;
                }
                nextHolder.blockingQueue.add( ++take );
            }

        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

    }
}

public class Print123
{

    public static void main( String[] args )
    {
        Holder lHolder1 = new Holder( new LinkedBlockingQueue<>() );
        Holder lHolder2 = new Holder( new LinkedBlockingQueue<>() );
        Holder lHolder3 = new Holder( new LinkedBlockingQueue<>() );

        lHolder1.nextHolder = lHolder2;
        lHolder2.nextHolder = lHolder3;
        lHolder3.nextHolder = lHolder1;
        lHolder1.blockingQueue.add( 1 );

        new Thread( lHolder1 ).start();
        new Thread( lHolder2 ).start();
        new Thread( lHolder3 ).start();
    }

}
