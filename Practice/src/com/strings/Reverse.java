package com.strings;

public class Reverse
{

    static String s = "";

    public static void main( String[] args )
    {
        String str = "string"; //gnirts

        // String op = reverseUsingSubString( str );
        reverseUsingFuncStk( str );
        System.out.println( s );
        // System.out.println( str.substring( 0, 1 ) );
        //  System.out.println( str.substring( 1, str.length() ) );

    }

    private static String reverseUsingSubString( String str )
    {

        if( str.length() == 1 )
        {
            s = s + str;
            return str;
        }
        else
        {
            s += str.charAt( str.length() - 1 );
            reverseUsingSubString( str.substring( 0, str.length() - 1 ) );
            return s;
        }
    }

    private static void reverseUsingFuncStk( String str )
    {
        int len = str.length();
        if( str.length() == 1 )
        {
            s = s + str;
            return;

        }
        s = s + str.substring( len - 1, len );//removing the chars from the end in each recursion
        str = str.substring( 0, len - 1 );
        reverseUsingFuncStk( str );

    }

}
