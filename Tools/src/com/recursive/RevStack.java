package com.recursive;

import java.util.Stack;

public class RevStack
{
    public static void main( String[] args )
    {
        Stack<Integer> s = new Stack<>();
        s.push( 1 );
        s.push( 2 );
        s.push( 3 );
        s.push( 4 );
        s.push( 5 );
        System.out.println( s.toString() );

        reverseStack( s );
        System.out.println( s.toString() );

    }

    private static void reverseStack( Stack<Integer> s )
    {
        if( s.isEmpty() )
            return;
        int a = s.pop();
        reverseStack( s );
        insertBottom( s, a );
    }

    private static void insertBottom( Stack<Integer> s,
                                      int a )
    {
        if( s.isEmpty() )
            s.push( a );
        else
        {
            int i = s.pop();
            insertBottom( s, a );
            s.push( i );

        }

    }

}
