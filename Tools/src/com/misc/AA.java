package com.misc;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

interface Try
{
    int var = 10;
    String str = "hi";

    void draw();

}

interface Catch extends Try
{
    void play();

}

abstract class ABS implements Try
{
    public abstract void draw();

}

public class AA implements Catch, statInterface
{
    int var = 20;

    @Override
    public void draw()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + var;
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
            return true;
        if( obj == null )
            return false;
        if( getClass() != obj.getClass() )
            return false;
        AA other = (AA) obj;
        if( var != other.var )
            return false;
        return true;
    }

    @Override
    public void play()
    {
        // TODO Auto-generated method stub

    }

    public static void main( String[] args )
    {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        int res = makeAnagram( a, b );
        System.out.println( res );
        int s = Integer.max( 4, 8 );
        System.out.println( s );
        char c = 'a';
        int x = c;
        System.out.println( x );

        int i = 10;
        Long z = Long.valueOf( i );

        String si = "abe";
        int mid = si.length() / 2;
        System.out.println( si.charAt( 0 ) + "-----" + si.charAt( 2 ) );

        BigInteger sb = new BigInteger( "12121212" );

    }

    static int makeAnagram( String a,
                            String b )
    {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        Map<Character, Integer> lMap = new HashMap<>();
        for( Character c : a1 )
        {
            if( lMap.containsKey( c ) )
                lMap.put( c, lMap.get( c ) + 1 );
            else
                lMap.put( c, 1 );
        }

        System.out.println( lMap.size() + " ----" + a1.length );
        int counter = 0;
        for( Character d : b1 )
        {
            if( !lMap.containsKey( d ) )
            {
                counter++;
            }

        }
        return counter;

    }

}

interface statInterface
{
    static void canIHave()
    {
        System.out.println( "Can I Have" );
    }

}
