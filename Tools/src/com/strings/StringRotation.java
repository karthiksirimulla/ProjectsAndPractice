package com.strings;

public class StringRotation
{
    public static void main( String[] args )
    {
        String str = "geeks";
        String rot = "eksge";

        System.out.println( isRotated( str, rot ) );
        System.out.println( reverse( str ) );
    }

    private static boolean isRotated( String str,
                                      String rot )
    {
        if( str.length() != rot.length() )
            return false;
        if( ( str + str ).indexOf( rot ) != -1 )
            return true;
        return false;

    }

    private static String reverse( String str )
    {
        if( ( str == null ) || ( str.length() <= 1 ) )
            return str;
        return reverse( str.substring( 1 ) ) + str.charAt( 0 );

    }

}
