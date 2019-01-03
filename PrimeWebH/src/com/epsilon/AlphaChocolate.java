package com.epsilon;

public class AlphaChocolate
{
    public static void main( String[] args )
    {
        String str = "abCde";

        int result = getLexographicCombinationsWithVowels( str, 0 );
        System.out.println( "Result  : " + result );

    }

    private static int getLexographicCombinationsWithVowels( String str,
                                                             int counter )
    {
        if( str.length() == 0 )
            return counter;
        String tempStr = str;
        String printStr = "";
        for( int i = 0; i < tempStr.length(); i++ )
        {
            char c = tempStr.charAt( i );
            if( c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
                counter = counter + ( tempStr.length() - i );
            printStr = printStr + tempStr.charAt( i );
            //System.out.println( printStr );
        }
        return getLexographicCombinationsWithVowels( str.substring( 1 ), counter );
    }

}
