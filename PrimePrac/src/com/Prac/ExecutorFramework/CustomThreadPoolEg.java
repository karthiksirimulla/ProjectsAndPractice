package com.Prac.ExecutorFramework;

import java.util.concurrent.TimeUnit;

public class CustomThreadPoolEg
{
    public static void main( String[] args )
    {
        CustomThreadPoolExecutor exec = new CustomThreadPoolExecutor( 2 );

        for( int i = 1; i <= 5; i++ )
        {
            CustomTask task = new CustomTask( "Task " + i );
            System.out.println( "Created : " + task.getName() );

            exec.execute( task );
        }

        exec.shutdown();

    }

}

class CustomTask implements Runnable
{
    private String name;

    public CustomTask( String naam )
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
