package com.Prac.DP;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubseq
{

    public static void main( String[] args )
    {
        String A = "nematodeknowledge";
        String B = "emptybottle";
        Set<Character> lst = new HashSet<>();

        int lcsLen = getLcsLen( A.toCharArray(), B.toCharArray(), A.length(), B.length() );
        System.out.println( "LongestCommonSubsequence : " + lcsLen );
        System.out.println( lst.size() );

        //for( Character c : lst )
        //   System.out.print( c + ", " );

    }

    private static int getLcsLen( char[] a,
                                  char[] b,
                                  int aL,
                                  int bL )
    {

        if( aL == 0 || bL == 0 )
            return 0;
        if( a[aL - 1] == b[bL - 1] )
        {
            return 1 + getLcsLen( a, b, aL - 1, bL - 1 );
        }

        return Math.max( getLcsLen( a, b, aL, bL - 1 ), getLcsLen( a, b, aL - 1, bL ) );
    }

}
