package com.interview;

import java.util.Arrays;

public class Anagram
{
    private static boolean isAnagram( String str1,
                                      String str2 )
    {
        if( str1.length() != str2.length() )
            return false;
        char[] aa = str1.toCharArray();
        Arrays.sort( aa );
        char[] bb = str2.toCharArray();
        Arrays.sort( bb );

        if( Arrays.toString( aa ).equals( Arrays.toString( bb ) ) )
            return true;
        return false;
    }

    public static void main( String[] args )
    {
        String str1 = "abcd";
        String str2 = "badc";

        Boolean result = isAnagram( str1, str2 );

        if( result )
            System.out.println( "Anagrams !!!" );
        else
            System.out.println( "Nope !!!" );
    }

}
