package com.Prac;

/**
 * Two words are anagrams of one another if their letters can be rearranged to form the other word.

   In this challenge, you will be given a string. You must split it into two contiguous substrings, then determine the minimum number of characters to change to make the two substrings into anagrams of one another.

   For example, given the string 'abccde', you would break it into two parts: 'abc' and 'cde'. 
   Note that all letters have been used, the substrings are contiguous and their lengths are equal. 
   Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams. 
   Two changes were necessary.
 * 
 * Sample Input - Output

    aaabbb - 3
    ab - 1
    abc - -1
    mnop - 2
    xyyx - 0
    xaxbbbxx - 1
 *
 */
public class Anagrams
{
    public static void main( String[] args )
    {
        String[] strList = { "aaabbb", "ab", "abc", "mnop", "xyyx", "xaxbbbxx" };

        for( String str : strList )
        {
            int len = str.length();
            if( len % 2 != 0 )
            {
                System.out.println( -1 );
                continue;
            }
            else
            {
                int res = anagramsDiff( str.substring( 0, len / 2 ), str.substring( len / 2 ) );
                System.out.println( res );

            }

        }

        System.out.println( anagramsDiff( "fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke" ) );

        System.out.println( " -->" + anagramsDiff( "bcadeh", "hea" ) );
    }

    static int anagramsDiff( String str1,
                             String str2 )
    {

        int[] arr1 = new int[256];
        int[] arr2 = new int[256];

        int diff = 0;

        for( int i = 0; i < str1.length(); i++ )
        {
            arr1[str1.charAt( i )]++;
        }

        for( int i = 0; i < str2.length(); i++ )
        {
            arr2[str2.charAt( i )]++;
        }

        for( int j = 0; j < 256; j++ )
        {
            if( arr1[j] != arr2[j] )
            {
                diff = diff + Math.abs( arr1[j] - arr2[j] );
            }

        }

        return diff;

    }

    static boolean areAnagrams( String str1,
                                String str2 )
    {
        if( str1.length() != str2.length() )
            return false;

        int[] arr1 = new int[256];
        int[] arr2 = new int[256];

        for( int i = 0; i < str1.length(); i++ )
        {
            arr1[str1.charAt( i )]++;
            arr2[str2.charAt( i )]++;
        }

        for( int j = 0; j < 256; j++ )
        {
            if( arr1[j] != arr2[j] )
                return false;
        }

        return true;

    }
}
