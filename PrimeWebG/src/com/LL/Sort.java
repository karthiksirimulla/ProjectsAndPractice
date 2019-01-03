package com.LL;

import java.util.Arrays;

import com.node.LLNode;

public class Sort
{
    public static void main( String[] args )
    {
        LLNode head = getLL();
        LLNode.print( head );

        sortByChangingData( head );
        LLNode.print( head );
        sortByChangingLinks( head );
    }

    private static void sortByChangingData( LLNode head )
    {
        int[] arr = new int[3];
        Arrays.fill( arr, 0 );

        LLNode tmp = head;

        while( tmp != null )
        {
            int data = tmp.data;
            arr[data] = arr[data] + 1;
            tmp = tmp.next;
        }

        System.out.println( Arrays.toString( arr ) );
        int i = 0;

        tmp = head;
        while( tmp != null )
        {
            if( arr[i] == 0 )
                i++;

            tmp.data = i;
            arr[i] = arr[i] - 1;
            tmp = tmp.next;
        }

        System.out.println( Arrays.toString( arr ) );

    }

    private static void sortByChangingLinks( LLNode head )
    {
        LLNode tmp = head;
        while( tmp != null )
        {
            int data = tmp.data;
            tmp = tmp.next;
        }

    }

    static LLNode getLL()
    {
        //  2->1->2->1->1->2->0->1->0
        LLNode head = new LLNode( 2 );

        LLNode node11 = new LLNode( 1 );
        LLNode node12 = new LLNode( 1 );
        LLNode node13 = new LLNode( 1 );
        LLNode node14 = new LLNode( 1 );

        LLNode node21 = new LLNode( 2 );
        LLNode node22 = new LLNode( 2 );

        LLNode node01 = new LLNode( 0 );
        LLNode node02 = new LLNode( 0 );

        head.next = node11;
        node11.next = node21;
        node21.next = node12;
        node12.next = node13;
        node13.next = node22;
        node22.next = node01;
        node01.next = node14;
        node14.next = node02;

        return head;

    }

}
