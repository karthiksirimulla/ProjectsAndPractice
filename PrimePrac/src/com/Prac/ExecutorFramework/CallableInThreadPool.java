package com.Prac.ExecutorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableInThreadPool
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool( 2 );
        List<Future<Integer>> collect = new ArrayList<>();

        Random r = new Random();

        for( int i = 0; i < 5; i++ )
        {
            int rt = r.nextInt( 10 );
            System.out.println( "calculating factorial for -->" + rt );
            collect.add( exec.submit( new FactCallable( rt ) ) );
        }

        for( Future<Integer> fut : collect )
        {
            try
            {
                System.out.println( fut.get() );
            }
            catch( Exception e )
            {
                System.out.println( "Exception : " );
            }

        }

        exec.shutdown();

    }

}

class FactCallable implements Callable<Integer>
{
    private int number;

    public FactCallable( int num )
    {
        this.number = num;
    }

    @Override
    public Integer call() throws Exception
    {
        int res = 1;
        if( number < 5 )
            throw new Exception();
        for( int i = 1; i <= number; i++ )
            res = res * i;
        TimeUnit.SECONDS.sleep( 5 );
        return res;
    }
}
