package com.strings;

import java.util.Arrays;

public class StringPermutations
{
    public static void main( String[] args )
    {
        String[] arr = { "CAB", "CBA", "ABC", "ACB", "BAC", "BCA" };
        Arrays.sort( arr );
        System.out.println( Arrays.toString( arr ) );

        String str = "HELLO";
        System.out.println( str.substring( 0, 1 ) + "-" + str.substring( 1 ) );

    }

}
