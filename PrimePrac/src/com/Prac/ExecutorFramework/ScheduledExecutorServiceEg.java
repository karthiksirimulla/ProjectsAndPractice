package com.Prac.ExecutorFramework;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEg
{
    public static void main( String[] args )
    {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool( 2 );

        ScheduleTask task1 = new ScheduleTask( "Task 1 " );
        ScheduleTask task2 = new ScheduleTask( "Task 2 " );

        exec.schedule( task1, 1, TimeUnit.SECONDS );
        exec.schedule( task2, 2, TimeUnit.SECONDS );

        System.out.println( "start -> " + new Date() );

        try
        {
            exec.awaitTermination( 5, TimeUnit.SECONDS );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

        System.out.println( "end -> " + new Date() );
        exec.shutdown();

        System.out.println( " -------- Periodic Execution ---------------------" );

        ScheduledThreadPoolExecutor ex = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool( 1 );
        //ex.scheduleAtFixedRate( task1, 2, 5, TimeUnit.SECONDS );
        //ex.scheduleWithFixedDelay( task1, 2, 5, TimeUnit.SECONDS );
        ex.setExecuteExistingDelayedTasksAfterShutdownPolicy( true );

        try
        {
            ex.awaitTermination( 1, TimeUnit.SECONDS );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

        ex.shutdown();

        ScheduledExecutorService exService = Executors.newScheduledThreadPool( 1 );
        exService.scheduleAtFixedRate( task2, 2, 5, TimeUnit.SECONDS );

        try
        {
            exService.awaitTermination( 5, TimeUnit.SECONDS );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

        exService.shutdown();

    }

}

class ScheduleTask implements Runnable
{
    private String name;

    public ScheduleTask( String naam )
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
        System.out.println( "Doing Task -> " + name + " - Time - " + new Date() );

    }

}
