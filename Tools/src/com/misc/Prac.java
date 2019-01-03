package com.misc;

public class Prac
{

    public static void main( String[] args )
    {
        String str = "kihtrak";
        String rev = reverseStrIt( str );
        System.out.println( rev );

        //-----------------------------------

        int[] arr = { 2, 10, 14, 19, 25, 36, 47, 54 };
        int k = 26;
        binarySearch( arr, k );
        printNFibo( 12 );
        Fibo( 12 );

    }

    private static void binarySearch( int[] arr,
                                      int k )
    {
        int low = 0;
        int high = arr.length - 1;

        while( low <= high )
        {
            int mid = ( low + high ) / 2;
            if( arr[mid] == k )
            {
                System.out.println( "Found" );
                return;
            }

            if( arr[mid] > k )
                high = mid - 1;
            else
                low = mid + 1;

        }
        System.out.println( "Not Found" );

    }

    private static String reverseStr( String str )
    {
        if( str.length() == 0 )
            return "";
        return str.charAt( str.length() - 1 ) + reverseStr( str.substring( 0, str.length() - 1 ) );
    }

    private static String reverseStrIt( String str )
    {
        if( str == null )
            return "";
        if( str.length() < 2 )
            return str;
        char[] c = str.toCharArray();

        int low = 0;
        int high = c.length - 1;

        while( low < high )
        {
            char temp = c[low];
            c[low] = c[high];
            c[high] = temp;
            low++;
            high--;
        }

        return String.valueOf( c );

    }

    static void printNFibo( int n )
    {
        if( n == 0 )
            return;
        if( n == 1 )
        {
            System.out.print( 0 );
            return;
        }

        int f = 0;
        int s = 1;

        System.out.println( f );

        for( int i = 1; i < n; i++ )
        {
            int sum = f + s;
            System.out.println( sum );
            f = s;
            s = sum;

        }
    }

    static void Fibo( int n )
    {
        if( n == 0 || n == 1 )
        {
            System.out.println( n );
            return;
        }

        int f = 0;
        int s = 1;
        int sum = 0;

        for( int i = 1; i < n; i++ )
        {
            sum = f + s;
            f = s;
            s = sum;
        }

        System.out.println( sum );

    }

}
