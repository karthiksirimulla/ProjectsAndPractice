package com.Prac.ExecutorFramework;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor
{
    // Pool Size
    private final int poolSize;

    // workers
    private final WorkerThread[] workers;

    // FIFO Ordering
    private final LinkedBlockingQueue<Runnable> queue;

    public CustomThreadPoolExecutor( int size )
    {
        this.poolSize = size;
        this.queue = new LinkedBlockingQueue<>();
        this.workers = new WorkerThread[size];

        for( int i = 0; i < poolSize; i++ )
        {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public void execute( Runnable task )
    {
        synchronized( queue )
        {
            queue.add( task );
            queue.notify();
        }
    }

    public void shutdown()
    {
        System.out.println( "Shutting down ....." );
        for( int i = 0; i < poolSize; i++ )
        {
            workers[i] = null;
        }
    }

    private class WorkerThread extends Thread
    {
        @Override
        public void run()
        {
            Runnable task;
            while( true )
            {
                synchronized( queue )
                {
                    while( queue.isEmpty() )
                    {
                        try
                        {
                            queue.wait();
                        }
                        catch( InterruptedException e )
                        {
                            e.printStackTrace();
                        }
                    }
                    task = (Runnable) queue.poll();
                }
                try
                {
                    task.run();
                    System.out.println( "----> " + Thread.currentThread().getName() );
                }
                catch( RuntimeException e )
                {
                    System.out.println( "Thread pool is interrupted due to an issue: " + e.getMessage() );
                }

            }
        }
    }
}
