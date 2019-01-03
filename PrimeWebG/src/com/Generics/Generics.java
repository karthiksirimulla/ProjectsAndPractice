package com.Generics;

import java.util.HashSet;
import java.util.Set;

//A Simple Java program to show multiple
//type parameters in Java Generics

//We use < > to specify Parameter type
class GenericTest<T, U>
{
    T obj1; // An object of type T
    U obj2; // An object of type U

    // constructor
    GenericTest( T obj1,
        U obj2 )
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    // To print objects of T and U
    public void print()
    {
        System.out.println( obj1 + " -- " + obj1.getClass() );
        System.out.println( obj2 + " -- " + obj2.getClass() );
    }

    public void findMax( String str1,
                         String str2 )
    {
        int i = compared( str1, str2 );
        if( i > 0 )
            System.out.println( str1 );
        else if( i < 0 )
            System.out.println( str2 );
        else
            System.out.println( "Equal" );

    }

    public int compared( String str1,
                         String str2 )
    {
        int len1 = str1.toCharArray().length;
        int len2 = str2.toCharArray().length;
        int lim = Math.min( len1, len2 );
        char v1[] = str1.toCharArray();
        char v2[] = str2.toCharArray();

        int k = 0;
        while( k < lim )
        {
            char c1 = v1[k];
            char c2 = v2[k];
            if( c1 != c2 )
            {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
}

//Driver class to test above
public class Generics
{
    public static void main( String[] args )
    {
        GenericTest<String, Integer> obj = new GenericTest<String, Integer>( "21", 22 );
        obj.findMax( "21", "32" );
        // GenericTest<Integer, String> obj1 = new GenericTest<Integer, String>( 21, "REV" );
        int[] a = { 1, 1, 1, 2, 3, 4 };
        Set<Integer> h = new HashSet<>();
        h.add( 1 );
        for( Integer i : h )
        {
            System.out.println( i );
        }

        //  assertLessOrEqual( "21", 22 );

    }

    public static <T extends Comparable<? super T>> void assertLessOrEqual( T left,
                                                                            T right )
    {
        if( left == null || right == null || left.compareTo( right ) > 0 )
        {
            String msg = "[" + left + "] is not less than [" + right + "]";
            throw new RuntimeException( "assertLessOrEqual: " + msg );
        }
    }
}
