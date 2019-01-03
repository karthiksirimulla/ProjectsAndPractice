package com.Threads;

public class Printer
{
    public static void main( String[] args ) throws InterruptedException
    {
        Print p = new Print();

        Thread T1 = new Thread( new Runnable()
        {

            @Override
            public void run()
            {
                try
                {
                    p.printEven();
                }
                catch( InterruptedException e )
                {
                    e.printStackTrace();
                }

            }
        } );

        Thread T2 = new Thread( new Runnable()
        {

            @Override
            public void run()
            {
                try
                {
                    p.printOdd();
                }
                catch( InterruptedException e )
                {
                    e.printStackTrace();
                }

            }
        } );

        T1.start();
        T2.start();

        T1.join();
        T2.join();
    }

}
