package com.strings;

public class KAnagrams
{
    public static void main( String[] args )
    {
        String str1 = "anagram"; // a-3; n-1; g-1; r-1; m-1
        String str2 = "grammar"; // a-2; g-1; r-2; m-2;
        int k = 3;

        areKAnagrams( str1, str2, k );

    }

    /**
     * Two strings are called k-anagrams if following two conditions are true.
    
        a) Both have same number of characters.
        b) Two strings can become anagram by changing at most k characters in a string.
        
     * @param str1
     * @param str2
     * @param k
     */
    private static void areKAnagrams( String str1,
                                      String str2,
                                      int k )
    {
        int max_char = 26;
        int n = str1.length();

        if( n != str2.length() )
        {
            System.out.println( "No" );
            return;
        }

        int[] count1 = new int[max_char];
        int[] count2 = new int[max_char];

        for( int i = 0; i < n; i++ )
        {
            count1[str1.charAt( i ) - 'a']++;
            count2[str2.charAt( i ) - 'a']++;
        }

        int count = 0;

        for( int i = 0; i < max_char; i++ )
        {
            if( count1[i] > count2[i] )
                count = count + Math.abs( count1[i] - count2[i] );
        }

        if( count <= k )
        {
            System.out.println( "true" );
            return;
        }
        System.out.println( "false" );
    }

}
