package com.Prac.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringExpressionEval
{
    public static void main( String[] args )
    {
        String str = "[{(}]";//"[({})]({[]})";

        Map<Character, Character> lMap = new HashMap<>();
        lMap.put( '}', '{' );
        lMap.put( ')', '(' );
        lMap.put( ']', '[' );

        char[] c = str.toCharArray();
        Stack<Character> st = new Stack<>();

        for( int i = 0; i < c.length; i++ )
        {
            if( lMap.containsKey( c[i] ) && lMap.get( c[i] ) == st.peek() )
            {
                st.pop();
            }
            else
            {
                st.push( c[i] );
            }

        }

        System.out.println( "----> " + st.size() );

        /*System.out.println( (int) '{' );
        System.out.println( (int) '}' );
        System.out.println( "--" );
        System.out.println( (int) '[' );
        System.out.println( (int) ']' );
        System.out.println( "--" );
        System.out.println( (int) '(' );
        System.out.println( (int) ')' );
        
        System.out.println( (char) 42 );*/

    }

}
