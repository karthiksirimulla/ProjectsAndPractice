package com.Prac;

import java.util.Stack;

public class ExpressionEval
{
    public static void main( String[] args )
    {
        String str = "100 * 2 + 12";

        // char c = '0';
        //System.out.println( c - '0' );

        int res = eval( str );
        System.out.println( res );
    }

    private static int eval( String str )
    {
        char[] cArr = str.toCharArray();

        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operandStack = new Stack<>();
        StringBuffer stBuff = new StringBuffer();

        for( int i = 0; i < cArr.length; i++ )
        {

            char c = cArr[i];
            if( c == ' ' )
                continue;
            if( c - '0' >= 0 && c - '0' <= 9 )
            {
                stBuff.append( c );
            }
            else
            {
                int number = 0;
                if( !stBuff.toString().isEmpty() )
                {
                    number = Integer.valueOf( stBuff.toString() );
                    if( numberStack.isEmpty() )
                        numberStack.push( number );
                }
                stBuff = new StringBuffer();

                if( operandStack.isEmpty() )
                    operandStack.push( c );
                else
                {
                    char op1 = operandStack.peek();
                    char op2 = c;

                    if( checkPredence( op1, op2 ) )
                    {
                        int num1 = number;
                        int num2 = numberStack.pop();
                        numberStack.push( calculator( num1, num2, op1 ) );
                    }
                    else
                    {
                        numberStack.push( number );
                        operandStack.push( op2 );

                    }
                }
            }
        }

        int res = 0;

        while( operandStack.isEmpty() )
        {
            int num1 = numberStack.pop();
            int num2 = numberStack.pop();
            char op = operandStack.pop();
            res = res + calculator( num1, num2, op );

        }

        return res;
    }

    private static boolean checkPredence( char op1,
                                          char op2 )
    {
        if( ( op1 == '*' || op1 == '/' ) && ( op2 == '+' || op2 == '-' ) )
            return true;
        else
            return false;

    }

    private static int calculator( int a,
                                   int b,
                                   char c )
    {
        switch( c )
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if( b == 0 )
                    throw new UnsupportedOperationException();
                return a / b;

        }
        return 0;
    }

}
