package com.strings;

public class XFormat
{
    public static void main( String[] args )
    {
        String str = "geeksforgeeks";
        XFormatPrint( str );
    }

    private static void XFormatPrint( String str )
    {
        if( str.length() % 2 == 0 )
            return;

        char[] arr = str.toCharArray();
        int len = arr.length;

        for( int i = 0, j = len - 1; i < len && j >= 0; i++, j-- )
        {
            System.out.print( arr[i] );
            int temp = 2 * Math.abs( j - i );
            while( temp > 0 )
            {
                System.out.print( " " );
                temp--;
                temp--;
            }
            if( i != j )
                System.out.print( arr[j] );
            System.out.println();

        }
    }

}
