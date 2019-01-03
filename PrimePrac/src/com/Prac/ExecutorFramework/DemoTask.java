package com.Prac.ExecutorFramework;

import java.util.concurrent.TimeUnit;

public class DemoTask implements Runnable
{
    private String name;

    public DemoTask( String naam )
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
