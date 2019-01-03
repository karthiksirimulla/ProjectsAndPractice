package com.Generics;

import java.util.Arrays;
import java.util.List;

/*
 * 
 * Write a generic method to find the maximal element in the range [begin, end) of a list.
 */
public class Ex3
{

    public static void main( String[] args )
    {
        List<String> strList = Arrays.asList( "S", "B", "L", "U" );
        String s = findMax( strList, 0, strList.size() - 1 );
        System.out.println( "strList : " + s );

        List<Double> dList = Arrays.asList( 1.1, 3.4, 5.3, 9.0, 8.7 );
        Double d = findMax( dList, 0, dList.size() - 1 );
        System.out.println( "dList : " + d );

    }

    private static <T extends Object & Comparable<? super T>> T findMax( List<? extends T> list,
                                                                         int begin,
                                                                         int end )
    {
        T max = list.get( begin );

        for( int i = begin + 1; i <= end; i++ )
        {
            if( max.compareTo( list.get( i ) ) < 0 )
                max = list.get( i );
        }

        return max;

    }

}
