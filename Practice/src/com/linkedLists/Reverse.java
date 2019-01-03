package com.linkedLists;

public class Reverse
{
    public static void main( String[] args )
    {
        MyLinkedList lList = new MyLinkedList();
        // 5,8,11,13,17,19
        lList.insert( new Node( 5 ) );
        lList.insert( new Node( 8 ) );
        lList.insert( new Node( 11 ) );
        lList.insert( new Node( 13 ) );
        lList.insert( new Node( 17 ) );
        lList.insert( new Node( 19 ) );
        MyLinkedList.print( lList );

        ReverseLinkedList( lList );
        MyLinkedList.print( lList );
    }

    private static MyLinkedList ReverseLinkedList( MyLinkedList lList )
    {
        Node curr = lList.head;
        Node prev = null;
        Node next = null;

        while( curr != null )
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        lList.head = prev;
        return lList;
    }

    // recursive way to reverse linked list
}
