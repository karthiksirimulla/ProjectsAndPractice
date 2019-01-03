package com.collection.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class App
{
    public static void main( String[] args )
    {
        Employee emp1 = new Employee( 1, "Usha" );
        Employee emp2 = new Employee( 2, "Karthik" );
        Employee emp3 = new Employee( 3, "Ravi" );
        Employee emp4 = new Employee( 4, "Dheeraj" );
        Employee emp5 = new Employee( 5, "Sandeep" );
        Employee emp6 = new Employee( 6, null );

        // HashSet
        HashSet<Employee> hashSet = new HashSet<>();
        hashSet.add( emp1 );
        hashSet.add( emp1 );
        hashSet.add( null );
        hashSet.add( emp6 );
        System.out.println( "HashSet : " + hashSet.size() );

        //HashMap
        HashMap<Employee, Integer> hashMap = new HashMap<>();
        hashMap.put( emp1, 1 );
        hashMap.put( emp2, 1 );
        hashMap.put( emp3, 1 );
        hashMap.put( emp4, 1 );
        hashMap.put( emp5, 1 );
        hashMap.put( emp6, 1 );
        hashMap.size();
        System.out.println( "HashMap : " + hashMap.size() );

        //HashTable
        Hashtable<Employee, Integer> hashtable = new Hashtable<>();
        //hashtable.put( null, null );

        // set
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        map.put( 1, 11 );
        map.put( 2, 21 );
        map.put( 3, 31 );
        map.put( 4, 41 );
        map.put( 5, 51 );
        map.put( 6, 61 );

        System.out.println( "--------- TreeMap ------------" );
        Entry<Integer, Integer> low = map.lowerEntry( 4 );
        Entry<Integer, Integer> floor = map.floorEntry( 10 );
        Integer high = map.ceilingKey( 0 );
        System.out.println( high );

        System.out.println( "------- LinkedHashMap-----------" );
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put( 1, 11 );
        linkedHashMap.put( 2, 21 );
        linkedHashMap.put( 5, 51 );
        linkedHashMap.put( 6, 61 );
        linkedHashMap.put( 3, 31 );
        linkedHashMap.put( 4, 41 );

        Set<Entry<Integer, Integer>> linkedEntrySet = linkedHashMap.entrySet();
        for( Entry<Integer, Integer> entry : linkedEntrySet )
        {
            System.out.println( entry.getKey() + "----" + entry.getValue() );

        }

        System.out.println( "--------- Priority Queue ------------" );
        Queue<Integer> pQueue = new PriorityQueue<>();
        pQueue.add( 2 );
        pQueue.add( 10 );
        pQueue.add( 4 );
        pQueue.add( 6 );
        pQueue.add( 8 );
        // [2, 10, 4, 6, 8]        
        // [2, 6, 4, 10, 8] -- MAX HEAP ; Children are always greater than parent
        // Left : 2i+1, Right : 2i+2
        System.out.println( pQueue );

        System.out.println( "The queue elements:" );
        while( !pQueue.isEmpty() )
            System.out.println( pQueue.poll() );

        System.out.println( "------------- Dequeue ------------------" );
        Deque<Integer> deque = new LinkedList<>();
        deque.add( 2 );
        deque.add( 10 );
        deque.add( 4 );
        deque.add( 6 );
        deque.add( 8 );

        System.out.println( deque.peekLast() );

        final List<Integer> arr = new ArrayList<>();
        Collections.unmodifiableCollection( arr );

    }

}
