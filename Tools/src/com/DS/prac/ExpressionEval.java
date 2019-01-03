package com.DS.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionEval
{
    public static void main( String[] args )
    {
        String expr = "3 + 4 -5 + (6 * 4 - 5 * ( - 1 + 3 * 5))";
        List<Integer> openBrac = new ArrayList<>();
        List<Integer> closedBrac = new ArrayList<>();
        char[] chars = expr.toCharArray();
        for( int i = 0; i < expr.length(); i++ )
        {
            if( chars[i] == '(' )
                openBrac.add( i );
            if( chars[i] == ')' )
                closedBrac.add( i );
        }
        System.out.println( openBrac.toString() );
        System.out.println( closedBrac.toString() );

        String subString = expr.substring( openBrac.get( openBrac.size() - 1 ) + 1, closedBrac.get( 0 ) );

        System.out.println( expr.substring( openBrac.get( openBrac.size() - 1 ) + 1, closedBrac.get( 0 ) ) );

        Stack<Character> opStack = new Stack<>();
        Stack<Character> numStack = new Stack<>();

        char[] subChar = subString.toCharArray();

        if( subChar[0] != '-' )
            opStack.push( '+' );

    }

}
