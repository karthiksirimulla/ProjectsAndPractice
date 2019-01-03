package com.misc;

import java.util.HashSet;
import java.util.Set;

interface stats
{
    static void print()
    {
        System.out.println( "Hey" );

    };
}

class Parent
{

}

class Child extends Parent
{

}

public class AMisc extends Thread implements stats
{

    public void run()
    {
        System.out.println( "Run ..." );
    }

    public void run( String s )
    {
        System.out.println( s );
    }

    public static void main( String[] args )
    {
        Parent p = new Parent();

        Child c = new Child();

        Parent pc = new Child(); // reference

        Child cc = (Child) new Parent();

        int n = 34589; // 98543  
        int i = 0;
        while( n != 0 )
        {
            n = n / 10;
            i++;
        }

        printFibo( 10 );

        Set<Integer> s = new HashSet<>();
        while( true )
        {
            s.add( 1 );
            if( s.contains( 1 ) )
                s.remove( 1 );

        }
    }

    static int revNum( int num,
                       int res,
                       int n )
    {
        if( num == 0 || n == 0 )
            return res;

        res = (int) ( res + ( ( num % 10 ) * Math.pow( 10, n ) ) );
        System.out.println( "@@@ res : " + res );

        return revNum( num / 10, res, n - 1 );
    }

    static void printFibo( int n )
    {
        int f1 = 0, f2 = 1, i;

        if( n < 1 )
            return;

        for( i = 1; i <= n; i++ )
        {
            System.out.print( f2 + " " );
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
    }

}
