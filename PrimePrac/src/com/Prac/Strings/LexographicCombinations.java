package com.Prac.Strings;

public class LexographicCombinations
{
    public static void main( String[] args )
    {
        String str = "123123";
        // A + BCDE
        //System.out.println( str.charAt( 0 ) + str.substring( 1, str.length() - 1 ) + str.charAt( str.length() - 1 ) );
        printLexographicCombinations( str, 0 );

    }

    private static void printLexographicCombinationsInt( String str )
    {
        if( str.length() == 0 )
            return;
        String tempStr = str;
        String printStr = "";
        Integer k = 0;

        for( int i = 0; i < tempStr.length(); i++ )
        {
            printStr = printStr + tempStr.charAt( i );
            k = k + Integer.valueOf( String.valueOf( tempStr.charAt( i ) ) );
            System.out.println( printStr + " ---- " + k );
        }
        printLexographicCombinationsInt( str.substring( 1 ) );
    }

    private static void printLexographicCombinations( String str,
                                                      int counter )
    {
        if( str.length() == 0 )
            return;
        String tempStr = str;
        String printStr = "";
        for( int i = 0; i < tempStr.length(); i++ )
        {
            printStr = printStr + tempStr.charAt( i );
            if( printStr.length() % 2 == 0 )
                System.out.println( printStr );
        }
        printLexographicCombinations( str.substring( 1 ), counter );
    }

}
