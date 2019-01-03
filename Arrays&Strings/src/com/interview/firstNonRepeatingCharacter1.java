package com.interview;

import java.util.HashMap;

public class firstNonRepeatingCharacter1
{
    static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public static void main( String[] args )
    {
        String str = "geeksforgeeks";
        buildCharMap( str );
        int result = Integer.MAX_VALUE;
        System.out.println( map.size() );
        for( int i = 0; i < str.toCharArray().length; i++ )
        {
            if( map.get( str.charAt( i ) ) == 1 && result > i )
            {
                result = i;
            }
        }
        System.out.println( str.charAt( result ) );
    }

    private static void buildCharMap( String str )
    {
        for( int i = 0; i < str.toCharArray().length; i++ )
        {
            if( map.containsKey( str.charAt( i ) ) )
            {
                map.put( str.charAt( i ), map.get( str.charAt( i ) ) + 1 );
            }
            else
            {
                map.put( str.charAt( i ), 1 );
            }
        }

    }

}
