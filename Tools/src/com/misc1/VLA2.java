package com.misc1;

import java.util.Arrays;
import java.util.Comparator;

public class VLA2 implements Comparator<VLA2>
{
    int dishSize;

    public static void main( String[] args )
    {
        VLA2[] va = { new VLA2( 40 ), new VLA2( 200 ), new VLA2( 60 ) };
        Arrays.sort( va, va[0] );
        System.out.println( Arrays.toString( va ) );
        int index = Arrays.binarySearch( va, new VLA2( 40 ), va[0] );
        //<VLA2> Arrays.binarySearch(VLA2[] a, VLA2 key, Comparator<? super VLA2> c)
        /*
         * index of the search key, if it is contained in the array; 
         * otherwise, (-(insertion point) - 1). The insertion point is 
         * defined as the point at which the key would be inserted into the array: 
         * the index of the first element greater than the key, or a.length 
         * if all elements in the array are less than the specified key. 
         * Note that this guarantees that the return value will be >= 0 
         * if and only if the key is found.
        
         */
        System.out.print( index + " " );
        index = Arrays.binarySearch( va, new VLA2( 201 ), va[0] );
        System.out.println( Arrays.toString( va ) );
        System.out.print( index );
    }

    public int compare( VLA2 a,
                        VLA2 b )
    {
        return b.dishSize - a.dishSize;
    }

    @Override
    public String toString()
    {
        return "" + dishSize + "";
    }

    VLA2( int d )
    {
        dishSize = d;
    }

}
