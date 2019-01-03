package com.DS.prac;

import java.util.Stack;

public class StackQueue
{
    public static void main( String[] args )
    {
        Stack<Integer> s = new Stack<>();
        s.push( 1 );
        s.push( 2 );
        s.push( 3 );
        s.push( 4 );
        s.push( 5 );

        int t = queueGet( s );
        System.out.println( t + "," + s.size() );

    }

    private static int queueGet( Stack<Integer> s )
    {
        int res = s.pop();
        if( s.isEmpty() )
        {
            return res;
        }
        else
        {
            int temp = queueGet( s );
            s.push( res );
            return temp;
        }

    }

}
