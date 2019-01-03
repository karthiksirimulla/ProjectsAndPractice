package com.Prac.Strings;

public class LongestPalindromicSubstring
{
    public static void main( String[] args )
    {
        String str = "forgeeksskeegforl";
        System.out.println( "Length : " + str.length() );
        // geeksskeeg
        // Approach : For Odd String fix centre and expand
        //            For even string fix two centres and expand

        String res = getLongestPalindrome( str );
        System.out.println( "Result : " + res );
    }

    private static String getLongestPalindrome( String s )
    {
        if( s == null )
            return "";
        int len = s.length();
        if( len % 2 == 0 )
        {
            int hMid = len / 2;
            int lMid = hMid - 1;
            while( lMid > 0 && hMid < len )
            {
                if( s.charAt( lMid ) != s.charAt( hMid ) )
                {
                    return s.substring( lMid + 1, hMid );
                }
                lMid--;
                hMid++;
            }

        }
        else
        {
            int mid = len / 2;
            int low = mid - 1;
            int high = mid + 1;
            while( low > 0 && high < len )
            {
                if( s.charAt( mid ) != s.charAt( high ) )
                {
                    return s.substring( low + 1, high );
                }
                low--;
                high++;
            }

        }
        return s;
    }

    public static boolean checkIfPalindrome( String s,
                                             int low,
                                             int high )
    {
        if( low >= high )
            return true;
        if( s.charAt( low ) != s.charAt( high ) )
        {
            return false;
        }
        low++;
        high--;
        return checkIfPalindrome( s, low, high );

    }

}
