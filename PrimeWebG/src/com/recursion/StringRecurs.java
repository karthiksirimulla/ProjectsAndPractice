package com.recursion;

public class StringRecurs
{
    public static void main( String[] args )
    {
        String str = "xxhixx";
        String res = changeXY( str );
        //  System.out.println( res );

        String pi = "pipi";
        String piRes = changePi( pi );
        // System.out.println( piRes );

        String noX = "xaxb";
        String noXRes = noX( noX );
        //  System.out.println( noXRes );

        String rev = "abcde";
        String revres = reverse( rev );
        // System.out.println( "rev : " + revres );

        String per = "aeiou";
        int size = 1;
        //permute( "", per );
        recur( per );
        // beautifulStrings( per, size );
        // aa, ae, ai, ao, au, ee, ei, eo, eu, ii, io, iu, oo, ou, uu

        String lex = "abc";
        // permuteLexo( "", lex );

    }

    private static void beautifulStrings( String prefix,
                                          String per,
                                          int size )
    {
        /**
         * 
         * 
         */

        if( prefix.length() == size )
            System.out.println( per + ", " );
        else
        {
            for( int i = 0; i < per.length(); i++ )
            {

            }

        }

    }

    private static void recur( String per )
    {
        if( per.length() == 0 )
            return;
        else
        {
            for( int i = 0; i < per.length(); i++ )
            {
                System.out.print( per.charAt( 0 ) + per.substring( i, i + 1 ) + ", " );
            }
            recur( per.substring( 1 ) );
        }

    }

    private static void permuteLexo( String prefix,
                                     String str )
    {
        int n = str.length();
        if( n == 1 )
            System.out.println( prefix + ", " );
        else
        {
            for( int i = 0; i < n; i++ )
            {
                /*  System.out.println( "permute( "
                    + prefix
                    + str.charAt( i )
                    + " , "
                    + str.substring( 0, i )
                    + str.substring( i + 1, n )
                    + " )" );*/
                permuteLexo( prefix + str.charAt( i ), str.substring( i + 1, n ) );
            }
        }

    }

    private static void permute( String prefix,
                                 String str )
    {
        int n = str.length();
        if( n == 3 )
            System.out.print( prefix + ", " );
        else
        {
            for( int i = 0; i < n; i++ )
            {
                System.out.println( "permute( "
                    + prefix
                    + str.charAt( i )
                    + " , "
                    + str.substring( 0, i )
                    + str.substring( i + 1, n )
                    + " )" );
                permute( prefix + str.charAt( i ), str.substring( 0, i ) + str.substring( i + 1, n ) );
            }
        }

    }

    private static String changeXY( String str )
    {
        if( str.length() <= 0 )
            return "";
        if( str.charAt( 0 ) == 'x' )
            return 'y' + changeXY( str.substring( 1 ) );
        return str.charAt( 0 ) + changeXY( str.substring( 1 ) );
    }

    private static String changePi( String str )
    {
        if( str.length() <= 0 )
            return "";
        if( str.length() >= 2 && str.charAt( 0 ) == 'p' && str.charAt( 1 ) == 'i' )
            return "3.14" + changePi( str.substring( 2 ) );
        return str.charAt( 0 ) + changePi( str.substring( 1 ) );
    }

    private static String noX( String noX )
    {
        if( noX.length() <= 0 )
            return "";
        if( noX.charAt( 0 ) == 'x' )
            return "" + noX( noX.substring( 1 ) );
        return noX.charAt( 0 ) + noX( noX.substring( 1 ) );
    }

    private static String reverse( String str )
    {
        if( str.length() == 1 )
            return str;
        return str.charAt( str.length() - 1 ) + reverse( str.substring( 0, str.length() - 1 ) );
    }

}
