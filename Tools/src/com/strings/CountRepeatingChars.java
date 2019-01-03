package com.strings;

public class CountRepeatingChars
{
    public static void main( String[] args )
    {
        String str = "abcde";
        String res = reverse( str );//convertRepeatingChars( str );
        System.out.println( res );
    }

    private static String convertRepeatingChars( String str )
    {
        char[] arr = str.toCharArray();
        StringBuilder strB = new StringBuilder();
        int counter = 1;
        for( int i = 0; i < arr.length - 1; i++ )
        {
            if( arr[i] != arr[i + 1] )
            {
                strB.append( arr[i] );
                strB.append( counter );
                counter = 1;
            }
            else
            {
                counter++;
            }
        }
        strB.append( arr[arr.length - 1] );
        strB.append( counter );
        return strB.toString();
    }

    private static String reverse( String str )
    {
        char[] arr = str.toCharArray();
        int low = 0;
        int high = arr.length - 1;

        while( low < high )
        {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
        System.out.println( arr );

        return arr.toString();
    }

    private static String reverseRec( String str )
    {
        return null;
    }

}
