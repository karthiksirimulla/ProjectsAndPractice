package com.DP;

import java.util.Arrays;

/*
 * Given two strings str1 and str2 and below operations that can performed on str1. 
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

    Insert
    Remove
    Replace
    All of the above operations are of equal cost.
    
    Examples:
    
    Input:   str1 = "geek", str2 = "gesek"
    Output:  1
    We can convert str1 into str2 by inserting a 's'.
    
    Input:   str1 = "cat", str2 = "cut"
    Output:  1
    We can convert str1 into str2 by replacing 'a' with 'u'.
    
    Input:   str1 = "sunday", str2 = "saturday"
    Output:  3
    Last three and first characters are same.  We basically
    need to convert "un" to "atur".  This can be done using
    below three operations. 
    Replace 'n' with 'r', insert t, insert a
 * 
 * 
 * 
 * 
 */
public class DiffStrings
{
    @SuppressWarnings( "unchecked" )
    public static void main( String[] args )
    {

        String str1 = "geek";
        String str2 = "gesek";

        int op = editDistDP( str1, str2, str1.length(), str2.length() );
        System.out.println( "O/P : " + op );

    }

    static int min( int x,
                    int y,
                    int z )
    {
        if( x <= y && x <= z )
            return x;
        if( y <= x && y <= z )
            return y;
        else
            return z;
    }

    static int editDist( String str1,
                         String str2,
                         int m,
                         int n )
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if( m == 0 )
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if( n == 0 )
            return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if( str1.charAt( m - 1 ) == str2.charAt( n - 1 ) )
            return editDist( str1, str2, m - 1, n - 1 );

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min( editDist( str1, str2, m, n - 1 ), // Insert
                        editDist( str1, str2, m - 1, n ), // Remove
                        editDist( str1, str2, m - 1, n - 1 ) // Replace     

        );
    }

    static int editDistDP( String str1,
                           String str2,
                           int m,
                           int n )
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for( int i = 0; i <= m; i++ )
        {
            for( int j = 0; j <= n; j++ )
            {
                // If first string is empty, only option is to
                // insert all characters of second string
                if( i == 0 )
                    dp[i][j] = j; // Min. operations = j

                // If second string is empty, only option is to
                // remove all characters of second string
                else if( j == 0 )
                    dp[i][j] = i; // Min. operations = i

                // If last characters are same, ignore last char
                // and recur for remaining string
                else if( str1.charAt( i - 1 ) == str2.charAt( j - 1 ) )
                    dp[i][j] = dp[i - 1][j - 1];

                // If the last character is different, consider all
                // possibilities and find the minimum
                else
                    dp[i][j] = 1 + min( dp[i][j - 1], // Insert 
                                        dp[i - 1][j], // Remove
                                        dp[i - 1][j - 1] ); // Replace
            }
        }

        /*
         *             g  e  s  e  k 
                    0  1  2  3  4  5
                  0[0, 1, 2, 3, 4, 5]
                g 1[1, 0, 1, 2, 3, 4]
                e 2[2, 1, 0, 1, 2, 3]
                e 3[3, 2, 1, 1, 1, 2]
                k 4[4, 3, 2, 2, 2, 1]
         * 
         */

        System.out.println( Arrays.deepToString( dp ) );
        return dp[m][n];
    }

}
