package com.Prac;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Count Possible Decodings of a given Digit Sequence
   Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence,
   count the number of possible decodings of the given digit sequence.

    Examples:
    
    Input:  digits[] = "121"
    Output: 3
    // The possible decodings are "ABA", "AU", "LA"
    
    Input: digits[] = "1234"
    Output: 3
    // The possible decodings are "ABCD", "LCD", "AWD"
 *
 */
public class DecodesInArray
{
    public static void main( String[] args )
    {
        String digit = "121";
        int i = 1;

        System.out.println( (char) ( i + 64 ) );
        String[] res = getCombinations( digit );

    }

    private static String[] getCombinations( String digit )
    {
        List<String> strList = new ArrayList<>();
        makesCombinations( digit, 0, 1, 1, strList );
        System.out.println( strList.toString() );

        return null;
    }

    private static void makesCombinations( String digit,
                                           int initIndex,
                                           int endIndex,
                                           int permCount,
                                           List<String> strList )
    {
        if( permCount > 2 )
            return;
        if( endIndex > digit.length() )
        {
            makesCombinations( digit, 0, permCount + 1, permCount + 1, strList );
        }
        else
        {
            String temp = digit.substring( initIndex, endIndex );
            Integer val = Integer.valueOf( temp );
            if( val < 26 )
                strList.add( String.valueOf( (char) ( val + 64 ) ) );
            makesCombinations( digit, initIndex + 1, endIndex + 1, permCount, strList );
        }

    }

}
