package com.Prac;

/**
 * 
 * LargestNumber("1a2") = 2
 *
 */
public class LargestNumber
{

    public static void main( String[] args )
    {
        String str = "mk12gthwe56opik123qweqwe";
        findLargestNumber( str );
    }

    private static void findLargestNumber( String str )
    {
        char[] arr = str.toCharArray();

        int result = Integer.MIN_VALUE;
        String temp = "";

        for( int i = 0; i < arr.length; i++ )
        {
            if( (int) arr[i] < 97 )
            {
                temp = temp + arr[i];
            }
            else
            {
                if( !temp.isEmpty() && Integer.valueOf( temp ) > result )
                {
                    result = Integer.valueOf( temp );
                }
                temp = "";
            }
        }

        if( !temp.isEmpty() && Integer.valueOf( temp ) > result )
        {
            result = Integer.valueOf( temp );
        }

        System.out.println( result );

    }

}
