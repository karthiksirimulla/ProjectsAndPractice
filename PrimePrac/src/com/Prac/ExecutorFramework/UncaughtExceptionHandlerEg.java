package com.Prac.ExecutorFramework;

public class UncaughtExceptionHandlerEg
{
    public static void main( String[] args )
    {
        Reader r = new Reader();
        Thread t = new Thread( r );
        t.start();
    }

}

class Reader implements Runnable
{

    @Override
    public void run()
    {
        Thread.currentThread().setUncaughtExceptionHandler( new UncaughtExceptionService() );
        System.out.println( Integer.valueOf( "11" ) );
        System.out.println( Integer.valueOf( "23" ) );
        System.out.println( Integer.valueOf( "34" ) );
        System.out.println( Integer.valueOf( "SER" ) );
        System.out.println( Integer.valueOf( "#" ) );
        System.out.println( Integer.valueOf( "90" ) );
        System.out.println( Integer.valueOf( "56" ) );

    }

}