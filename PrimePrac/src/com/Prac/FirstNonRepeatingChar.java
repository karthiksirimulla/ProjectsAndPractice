package com.Prac;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingChar
{
    public static void main( String[] args )
    {
        String str = "GeeksforGeeks";
        printFirstNonRepeatingChar( str );
    }

    private static void printFirstNonRepeatingChar( String str )
    {
        Map<Character, Integer> lMap = new LinkedHashMap<>();
        char[] arr = str.toCharArray();
        for( int i = 0; i < arr.length; i++ )
        {
            if( lMap.containsKey( arr[i] ) )
                lMap.put( arr[i], lMap.get( arr[i] ) + 1 );
            else
                lMap.put( arr[i], 1 );
        }

        for( Entry<Character, Integer> entry : lMap.entrySet() )
        {
            if( entry.getValue() == 1 )
            {
                System.out.println( "FNRC : " + entry.getKey().toString() );
                break;
            }
        }

    }

}
