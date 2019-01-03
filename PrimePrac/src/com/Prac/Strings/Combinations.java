package com.Prac.Strings;

public class Combinations
{
    public static void main( String[] args )
    {
        String str = "ABCD";
        printCombinations( "", str );
    }

    private static void printCombinations( String combination,
                                           String remaining )
    {
        for( int i = 0; i < remaining.length(); i++ )
        {
            String comb = combination + remaining.charAt( i );
            System.out.println( "LEX : " + comb );
            String newremaining = remaining.substring( 0, i ) + remaining.substring( i + 1 );
            System.out.println( "newremaining : " + newremaining );
            printCombinations( comb, newremaining );

        }

    }

}
