package com.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Properties;

public class Prac
{
    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public static void main( String[] args )
    {
        PriorityQueue toDo = new PriorityQueue<>();
        toDo.add( "dishes" );
        toDo.add( "laun" );
        toDo.add( "bills" );
        //   toDo.add( "ashs" );
        //   toDo.offer( "bills" );
        //  toDo.add( "asht" );

        /* System.out.println( "dishes".compareTo( "bills" ) );
        
        System.out.println( "-->" + toDo );
        
        System.out.println( toDo.size()
            + ","
            + toDo.poll()
            + ","
            + toDo.peek()
            + ","
            + toDo.poll()
            + ","
            + toDo.poll()
            + ","
            + toDo.poll()
            + "," );*/

        String[] cities = { "Bangalore", "Pune", "San Francis Co", "New York City" };
        MySort ms = new MySort();
        System.out.println( Arrays.toString( cities ) );
        Arrays.sort( cities, ms );
        System.out.println( Arrays.toString( cities ) );
        System.out.println( "--> " + Arrays.binarySearch( cities, "New York City" ) );
        System.out.println( "-->bSearch : " + bSearch( cities, "New York City" ) );
        System.out.println( "--># " + Arrays.binarySearch( cities, "San Francis Co" ) );
        System.out.println( "!!! " + cities[2].compareTo( "New York City" ) );

        Properties p = System.getProperties();
        p.setProperty( "pirate", "scurvy" );
        String s = p.getProperty( "argProp" ) + " ";
        s += p.getProperty( "pirate" );
        String y = null;
        // System.out.println( s + y );

        mystery( 2437, 875 );

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add( 5 );
        pq.add( 3 );
        pq.add( 1 );
        pq.add( 7 );
        pq.add( 9 );
        System.out.println( "## PQ :" + pq );

    }

    private static int bSearch( Object[] a,
                                Object key )
    {
        return bSearch0( a, 0, a.length, key );
    }

    private static int bSearch0( Object[] a,
                                 int fromIndex,
                                 int toIndex,
                                 Object key )
    {
        int low = fromIndex;
        int high = toIndex - 1;

        while( low <= high )
        {
            int mid = ( low + high ) >>> 1;
            @SuppressWarnings( "rawtypes" )
            Comparable midVal = (Comparable) a[mid];
            @SuppressWarnings( "unchecked" )
            int cmp = midVal.compareTo( key );

            if( cmp < 0 )
                low = mid + 1;
            else if( cmp > 0 )
                high = mid - 1;
            else
                return mid; // key found
        }
        return -( low + 1 ); // key not found.
    }

    private static int mystery( int x,
                                int y )
    {
        if( x < 0 )
            return -1;
        if( y < 0 )
            return -1;
        if( x > y )
            x = x - y;
        else if( x < y )
            y = y - x;
        if( x == y )
        {
            //System.out.println( "-->" + x );
            return x;
        }
        return mystery( x, y );

    }

    static class MySort implements Comparator
    {

        @Override
        public int compare( Object o1,
                            Object o2 )
        {
            String a = (String) o1;
            String b = (String) o2;
            return a.compareTo( b );
        }
    }
}
