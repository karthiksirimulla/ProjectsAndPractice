package com.recursion;

public class Count7
{
    public static void main( String[] args )
    {
        int input = 717;
        int res = count( input );
        System.out.println( res );
        String str = "xxhiyy";
        str.length();
        System.out.println( "--> " + str.substring( 2 ) );
    }

    private static int count( int n )
    {
        if( n <= 0 )
            return 0;
        if( n % 10 == 7 )
            return 1 + count( n / 10 );
        return count( n / 10 );

    }

}
