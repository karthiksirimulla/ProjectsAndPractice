package com.LinkedLists;

import java.util.ArrayList;
import java.util.List;

import com.node.Node;

public class DetectAndRemoveLoop
{
    public static void main( String[] args )
    {

        Node head = buildLinkedList();

        hasLoop( head );

        detectSteps( head );

    }

    private static void detectSteps( Node head )
    {
        Node A = head;
        Node B = head;
        int steps = 1;

        A = A.next;
        B = B.next.next.next;

        while( A.data != B.data )
        {
            steps++;
            System.out.println( "( " + A.data + ", " + B.data + " )" );
            A = A.next;
            B = B.next.next;
        }

        System.out.println( "Meet Point : " + "( " + A.data + ", " + B.data + " )" );
        System.out.println( "Steps : " + steps );

    }

    private static void hasLoop( Node head )
    {
        Node sPtr = head;
        Node fPtr = sPtr;

        while( sPtr != null || fPtr != null )
        {
            if( sPtr.data == fPtr.data )
            {
                System.out.println( "Has Loop" );
                return;
            }

            sPtr = sPtr.next;
            fPtr = fPtr.next.next;

        }
        System.out.println( "No Loop" );
    }

    private static Node buildLinkedList()
    {

        List<Node> nodeList = new ArrayList<>();

        for( int i = 1; i < 13; i++ )
        {
            nodeList.add( new Node( i ) );
        }

        for( int i = 0; i < nodeList.size() - 1; i++ )
        {
            nodeList.get( i ).next = nodeList.get( i + 1 );
        }

        nodeList.get( nodeList.size() - 1 ).next = nodeList.get( 0 );

        return nodeList.get( nodeList.size() - 1 );

        /*Node node1 = new Node( 1 );
        Node node2 = new Node( 2 );
        Node node3 = new Node( 3 );
        Node node4 = new Node( 4 );
        Node node5 = new Node( 5 );
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        
        return node1;*/
    }

}
