package com.Prac.ExecutorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleTasksInSingleThread
{
    public static void main( String[] args )
    {

        List<Runnable> taskGroup = new ArrayList<Runnable>();
        taskGroup.add( new TaskOne() );
        taskGroup.add( new TaskTwo() );
        taskGroup.add( new TaskThree() );

        MultiRun run = new MultiRun( taskGroup );

        ExecutorService exec = Executors.newFixedThreadPool( 1 );

        exec.submit( run );
        exec.shutdown();
    }

}

class MultiRun implements Runnable
{
    private final List<Runnable> runnables;

    public MultiRun( List<Runnable> runnables )
    {
        this.runnables = runnables;
    }

    @Override
    public void run()
    {
        for( Runnable runnable : runnables )
        {
            new Thread( runnable ).start();
        }

    }

}
