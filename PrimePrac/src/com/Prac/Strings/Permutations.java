package com.Prac.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Permutations
{
    /**
     * ALGO : 
     *  ->  First take out a single char and play on remaining string loop
     *  for instance  :  "ABC"
     *  1) 'A' , BC
     *     'AB' , C
     *     'ABC', '' --> ABC
     *  2) 'A' , BC
     *     'AC' , B
     *     'ACB', '' --> ACB
     *  ----
     *  3) 'B' , AC
     *     'BA' , C
     *     'BAC', '' --> BAC
     *  4) 'B' , AC
     *     'BC' , A
     *     'BCA', '' --> BCA
     *  ----
     *  5) 'C' , AB
     *     'CA' , B
     *     'CAB', '' --> CAB
     *  6) 'C' , AB
     *     'CB' , A
     *     'CBA', '' --> CBA
     *    
     */
    public static void main( String[] args )
    {
        String str = "123123";
        myPermutations( "", str );
        System.out.println( "#########################################" );
        printPermutations( "", str );
        Map<String, String> lMap = new HashMap<>();
        for( Entry<String, String> e : lMap.entrySet() )
        {
            System.out.println( e.getValue() );
        }
    }

    private static void myPermutations( String permutation,
                                        String str )
    {
        if( str.length() == 0 )
            System.out.println( " -- >" + permutation );

        for( int i = 0; i < str.length(); i++ )
        {
            permutation = permutation + str.charAt( i );
            str = str.substring( 0, i ) + str.substring( i + 1 );
            // System.out.println( "myPermutations( " + permutation + ", " + str + " ); " );
            myPermutations( permutation, str );
        }
    }

    private static void printPermutations( String candidate,
                                           String remaining )
    {
        if( remaining.length() == 0 )
            System.out.println( "--> " + candidate );

        for( int i = 0; i < remaining.length(); i++ )
        {
            //System.out.println( "candidate : " + candidate + " ---- " + "remaining : " + remaining );
            String newcandidate = candidate + remaining.charAt( i );
            String newremaining = remaining.substring( 0, i ) + remaining.substring( i + 1 );
            System.out.println( "new Candidate : " + newcandidate );

            // System.out.println( "newcandidate : " + newcandidate + " ---- " + "newremaining : " + newremaining );
            // System.out.println( "printPermutations( " + newcandidate + ", " + newremaining + " ); " );
            printPermutations( newcandidate, newremaining );
        }

    }

}
