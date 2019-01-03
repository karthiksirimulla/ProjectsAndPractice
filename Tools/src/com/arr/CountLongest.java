package com.arr;

import java.util.ArrayList;
import java.util.List;

public class CountLongest
{

    public static void main( String[] args )
    {
        String str = "101101110110";
        int k = 1;
        longStrings( str, k );
    }

    private static void longStrings( String str,
                                     int k )
    {
        char[] arr = str.toCharArray();
        int len = arr.length;
        int t = k;

        List<Integer> arrList = new ArrayList<>();

        for( int i = 0; i < len; i++ )
        {
            if( arr[i] == '0' )
            {
                arrList.add( i );
            }
        }

        for( int i = 0; i < arrList.size(); i++ )
        {
            // System.out.println( arrList.toString() );
        }

        System.out.println( arrList.toString() );
    }

}
