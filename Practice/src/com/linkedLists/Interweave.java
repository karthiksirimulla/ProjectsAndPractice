package com.linkedLists;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Interweave
{
    public static void main( String[] args )
    {
        MyLinkedList lList = new MyLinkedList();
        lList.insert( new Node( 5 ) );
        lList.insert( new Node( 8 ) );
        lList.insert( new Node( 11 ) );
        lList.insert( new Node( 13 ) );
        lList.insert( new Node( 17 ) );
        lList.insert( new Node( 19 ) );
        // lList.insert( new Node( 23 ) );
        // lList.insert( new Node( 33 ) );
        // lList.insert( new Node( 37 ) );
        MyLinkedList.print( lList );
        // 5>19>8>17>11>13

        interWeaveUsingDequeue( lList );

    }

    private static void interWeave( MyLinkedList list )
    {
        int len = list.getLength();
        int mid = len / 2;
        int midL = mid;
        Node curr = list.head;
        Node next = curr.next;
        Node temp = list.head;
        Node tempTail = null;

        Stack<Node> nodeStack = new Stack<>();
        while( temp != null )
        {
            nodeStack.push( temp );
            if( mid == 0 )
                tempTail = temp;
            temp = temp.next;
            mid--;

        }

        while( midL > 0 )
        {
            Node node = nodeStack.pop();
            curr.next = node;
            node.next = next;
            curr = next;
            next = next.next;
            if( next.data == tempTail.data )
                next.next = null;
            midL--;
        }

        MyLinkedList.print( list );

    }

    private static void interWeaveUsingDequeue( MyLinkedList list )
    {
        Deque<Node> dNode = new LinkedList<>();
        Node temp = list.head;

        while( temp != null )
        {
            dNode.add( temp );
            temp = temp.next;
        }

        while( !dNode.isEmpty() )
        {
            Node first = dNode.pollFirst();
            Node next = dNode.peekFirst();
            Node last = dNode.pollLast();

            last.next = null;
            first.next = null;
            if( dNode.peekFirst() == null )
                next.next = null;

            first.next = last;
            last.next = next;

        }

        MyLinkedList.print( list );

    }

}
