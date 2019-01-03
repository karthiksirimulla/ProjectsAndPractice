package com.Prac;

/**
 * Longest Even Length Substring such that Sum of First and Second Half is same  

    Input: str = "123123"
    Output: 6
    The complete string is of even length and sum of first and second
    half digits is same

    Input: str = "1538023"
    Output: 4
    The longest substring with same first and second half sum is "5380"
 * 
 *
 */
public class LongestEvenSubStr
{
    public static void main( String[] args )
    {
        String str = "1538023";
        System.out.println( str.substring( 0 ) );

        printLexographicCombinationsRev( str );

    }

    private static void printLexographicCombinations( String str )
    {
        if( str.length() == 0 )
            return;
        String tempStr = str;
        String printStr = "";
        for( int i = 0; i < tempStr.length(); i++ )
        {
            printStr = printStr + tempStr.charAt( i );
            // if( printStr.length() % 2 == 0 )
            System.out.println( printStr );
        }
        printLexographicCombinations( str.substring( 1 ) );
    }

    private static void printLexographicCombinationsRev( String str )
    {
        if( str.length() == 0 )
            return;
        String printStr = str;
        for( int i = 0; i < printStr.length(); i++ )
        {
            String tempStr = printStr.substring( i, printStr.length() );
            //if( tempStr.length() % 2 == 0 )
            System.out.println( tempStr + " ---- " + tempStr.length() );
        }
        printLexographicCombinationsRev( str.substring( 1 ) );
    }
}
