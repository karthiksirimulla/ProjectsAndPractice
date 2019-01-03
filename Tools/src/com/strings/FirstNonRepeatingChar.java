package com.strings;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingChar
{
    public static void main( String[] args )
    {
        String str = "geeksforgeeksandgeeksquizfor";
        char res = firstNonRepeating( str );
        System.out.println( "Result :" + res );

    }

    private static char firstNonRepeating( String str )
    {
        char[] stream = str.toCharArray();
        boolean[] repeated = new boolean[256];

        List<Character> charList = new ArrayList<Character>();

        for( int i = 0; i < stream.length; i++ )
        {
            char x = stream[i];
            if( !repeated[x] )
            {
                if( !charList.contains( x ) )
                {
                    charList.add( x );
                }
                else
                {
                    charList.remove( (Character) x );
                    repeated[x] = true;
                }
            }
        }

        if( !charList.isEmpty() )
            return charList.get( 0 );
        return 0;
    }

}
