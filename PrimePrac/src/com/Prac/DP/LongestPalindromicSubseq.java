package com.Prac.DP;

public class LongestPalindromicSubseq
{

    public static void main( String[] args )
    {
        String str = "forgeeksskeegfors";//"ABBDCACB";

        int lpsLen = getLpsLen( str.toCharArray(), 0, str.length() - 1 );
        System.out.println( "LongestPalindromicSubseq Len : " + lpsLen );

        //---------

    }

    private static int getLpsLen( char[] c,
                                  int low,
                                  int high )
    {
        if( low > high )
            return 0;
        if( low == high )
            return 1;
        if( c[low] == c[high] )
            return 2 + getLpsLen( c, low + 1, high - 1 );

        return Math.max( getLpsLen( c, low + 1, high ), getLpsLen( c, low, high - 1 ) );
    }

}
