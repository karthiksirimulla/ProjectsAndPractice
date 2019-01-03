package com.strings;

import java.util.LinkedHashSet;

public class RemoveDups
{
    public static void main( String[] args )
    {
        String str = "aabcee";
        String result = removeDups( str );
        System.out.println( result );
    }

    private static String removeDups( String str )
    {
        char[] arr = str.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for( int i = 0; i < arr.length; i++ )
        {
            set.add( str.charAt( i ) );
        }

        int len = set.size();
        int i = 0;
        for( Character c : set )
        {
            arr[i] = c;
            i++;
        }
        return new String( arr, 0, len );
    }

}
