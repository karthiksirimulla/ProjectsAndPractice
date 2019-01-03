package com.linkedLists;

public class PairWiseSwap
{
    public static void main( String[] args )
    {
        MyLinkedList lList = new MyLinkedList();
        lList.insert( new Node( 1 ) );
        lList.insert( new Node( 2 ) );
        lList.insert( new Node( 3 ) );
        lList.insert( new Node( 4 ) );
        lList.insert( new Node( 5 ) );
        lList.insert( new Node( 6 ) );
        lList.insert( new Node( 7 ) );
        lList.insert( new Node( 8 ) );
        MyLinkedList.print( lList );

        pairSwap( lList );
        //lList.head = swapPairs( lList.head );

        MyLinkedList.print( lList );
    }

    private static void pairSwap( MyLinkedList list )
    {
        Node head = list.head;
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        while( next != null && next.next != null )
        {
            // 1 -> 2 -> 3 -> 4 -> 5 -> 6 ->7 ->8
            curr.next = next.next;
            next.next = curr;
            if( prev == null )
            {
                prev = next;
                list.head = prev;
                prev = prev.next;
            }
            else
            {
                prev.next = next;
                prev = prev.next.next;
            }

            curr = curr.next;
            next = next.next.next.next;
        }

    }

    public static Node swapPairs( Node head )
    {
        if( head == null )
            return null;
        if( head.next == null )
            return head;
        Node previous = null;
        Node current = head;
        Node runner = head.next;
        while( runner != null && runner != current )
        {
            current.next = runner.next;
            runner.next = current;
            if( previous == null )
            {
                previous = runner;
                head = previous;
                previous = previous.next;
            }
            else
            {
                previous.next = runner;
                previous = previous.next.next;
            }
            current = current.next;
            if( current == null )
                break;
            runner = runner.next.next.next;

        }

        return head;
    }

}
