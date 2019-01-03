package com.tools;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

abstract class Tool
{
    public abstract void hi();
}

public class Tool1
{

    ReentrantLock lck = new ReentrantLock();

    //1. find the min element in a rotated array
    public static void main( String[] args )
    {

        Tool t = new Tool()
        {

            @Override
            public void hi()
            {
                // TODO Auto-generated method stub

            }
        };
        int arr[] = { 1, 2, 3, 4 };
        String s;
        Integer obj;
        Object j;
        Long l;
        Queue<Integer> ss = new PriorityQueue<>();
        // findMin( arr, 0, arr.length - 1 );

        Comparator<Integer> valComparator = new Comparator<Integer>()
        {

            @Override
            public int compare( Integer o1,
                                Integer o2 )
            {
                return o1 - o2;
            }
        };

        PriorityQueue<Integer> pQueue = new PriorityQueue<>( valComparator );
        pQueue.offer( 10 );
        pQueue.offer( 5 );
        pQueue.offer( 6 );
        pQueue.offer( 9 );
        pQueue.offer( 2 );

        Deque<Integer> dQ = new LinkedList<>();

        System.out.println( pQueue );

        Executor exec = Executors.newCachedThreadPool();
        ExecutorService exes = Executors.newFixedThreadPool( 1 );
        ScheduledExecutorService exed = Executors.newScheduledThreadPool( 10 );
    }

    private static void findMin( int[] arr,
                                 int start,
                                 int end )
    {

        int mid = ( start + end + 1 ) / 2;
        if( arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1] )
        {
            System.out.println( "Min Element:" + arr[mid] );
            return;
        }

        if( arr[mid] > arr[start] )
        {
            // left array is sorted
            start = mid;
        }
        else
        {
            end = mid;
        }

        findMin( arr, start, end );

    }

}
