package com.Prac.ExecutorFramework;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorEg
{
    public static void main( String[] args )
    {
        ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool( 2 );

        RejectExecHandler lHandler = new RejectExecHandler();
        exec.setRejectedExecutionHandler( lHandler );
        for( int i = 0; i < 5; i++ )
            exec.execute( new DemoTask( "Task " + ( i + 1 ) ) );

        exec.shutdown();

        for( int i = 5; i < 10; i++ )
            exec.execute( new DemoTask( "Task " + ( i + 1 ) ) );

        List<Runnable> taskList = lHandler.getRejectedTaskList();
        for( Runnable r : taskList )
            System.out.println( "Rejected -->" + ( (DemoTask) r ).getName() );

    }

}

class RunTask implements Runnable
{
    private String name;

    public RunTask( String naam )
    {
        this.name = naam;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void run()
    {
        System.out.println( "Executing Thread --> " + getName() );
        try
        {
            TimeUnit.SECONDS.sleep( 1 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
    }

}
