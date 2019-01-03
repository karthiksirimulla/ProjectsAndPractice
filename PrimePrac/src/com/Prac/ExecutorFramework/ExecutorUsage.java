package com.Prac.ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorUsage
{
    private static ExecutorService executor = null;

    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        executor = Executors.newFixedThreadPool( 2 );
        executor.submit( new TaskOne() );
        executor.submit( new TaskTwo() );

        executor.shutdown();

    }

}

class TaskOne implements Runnable
{

    @Override
    public void run()
    {
        System.out.println( "Executing --> Task 1" );
        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

    }

}

class TaskTwo implements Runnable
{

    @Override
    public void run()
    {
        System.out.println( "Executing --> Task 2" );
        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

    }

}

class TaskThree implements Runnable
{

    @Override
    public void run()
    {
        System.out.println( "Executing --> Task 3" );
        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

    }

}
