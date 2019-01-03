package com.Rough;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class RoughThread
{
    public static void main( String[] args )
    {
        ExecutorService lServ = Executors.newFixedThreadPool( 10 );
        for( int i = 0; i < 200; i++ )
            lServ.submit( Calling.getInstance() );
        lServ.shutdown();
    }

}

class Calling implements Callable<String>
{
    private static Calling calling = new Calling();
    private static final Semaphore lSema = new Semaphore( 10 );
    private static int callers = 0;

    private Calling()
    {

    }

    public static Calling getInstance()
    {
        return new Calling();
    }

    public String call() throws Exception
    {
        callPick();
        return null;
    }

    private void callPick() throws InterruptedException
    {
        lSema.acquire();
        synchronized( this )
        {
            callers++;
            System.out.println( "current callers  : " + callers );
            // TimeUnit.MILLISECONDS.sleep( 1000 );
            callers--;
        }
        lSema.release();
    }
}