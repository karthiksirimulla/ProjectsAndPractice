package com.DP;

import java.util.Arrays;

/*
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 
 * So a string of length n has 2^n different possible subsequences.
 * 
 * 
 */
public class LCS
{
    public static void main( String[] args )
    {

        /*
         * if(lastChar == similar)
         *     lcs(str1.substring(str1.length()), str2.substring(str2.length())
         * else
         *     max(lcs(str1.substring(str1.length()), str2), lcs(str1, str2.substring(str2.length())))
         */

        String str1 = "hackerranks";//"AGGTAB";
        String str2 = "hackers";//"GXTXAYB";

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        int c1 = char1.length;
        int c2 = char2.length;

        int res = getLCSLength( char1, char2, c1, c2 );
        System.out.println( "Output : " + res );

        res = getLCSLengthTabulation( char1, char2, c1, c2 );
        System.out.println( "Output : " + res );

    }

    /*
     * Worst time complexity : 2 POW N
     */
    private static int getLCSLength( char[] char1,
                                     char[] char2,
                                     int c1,
                                     int c2 )
    {
        if( c1 == 0 || c2 == 0 )
            return 0;
        if( char1[c1 - 1] == char2[c2 - 1] )
            return 1 + getLCSLength( char1, char2, c1 - 1, c2 - 1 );
        else
            return Integer.max( getLCSLength( char1, char2, c1 - 1, c2 ), getLCSLength( char1, char2, c1, c2 - 1 ) );
    }

    private static int getLCSLengthTabulation( char[] X,
                                               char[] Y,
                                               int m,
                                               int n )
    {
        int L[][] = new int[m + 1][n + 1];

        System.out.println( "X length : " + Arrays.toString( X ) + "---> " + X.length + " ----" + m );
        System.out.println( "Y length : " + Arrays.toString( Y ) + "---> " + Y.length + " ----" + n );

        System.out.println( "Rows : " + L.length );
        System.out.println( "Cols : " + L[0].length );

        /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for( int i = 0; i <= m; i++ )
        {
            for( int j = 0; j <= n; j++ )
            {
                if( i == 0 || j == 0 )
                    L[i][j] = 0;
                else if( X[i - 1] == Y[j - 1] )
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Integer.max( L[i - 1][j], L[i][j - 1] );
            }
        }

        System.out.println( Arrays.deepToString( L ) );
        return L[m][n];
    }

}
