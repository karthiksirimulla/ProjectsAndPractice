package com.Prac.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreEg
{
    public static void main( String[] args ) throws InterruptedException
    {
        ExecutorService serv = Executors.newCachedThreadPool();

        for( int i = 0; i < 200; i++ )
        {
            serv.submit( new Runnable()
            {

                @Override
                public void run()
                {
                    Connection.getInstance().connect();

                }
            } );
        }

        serv.shutdown();
        serv.awaitTermination( 1, TimeUnit.DAYS );

    }

}

class Connection
{
    private static Connection connection = new Connection();

    private int id = 1;

    private int connections = 0;

    private Semaphore s = new Semaphore( 10 );

    private Connection()
    {

    }

    public static Connection getInstance()
    {
        return connection;
    }

    public void connect()
    {
        try
        {
            s.acquire();
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

        synchronized( this )
        {
            connections++;
            System.out.println( this.id );
            System.out.println( "Current Connections : " + connections );
        }

        try
        {
            TimeUnit.MILLISECONDS.sleep( 100 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

        synchronized( this )
        {
            connections--;
            //System.out.println( "Came here !!!" );
        }

        s.release();
    }

}
