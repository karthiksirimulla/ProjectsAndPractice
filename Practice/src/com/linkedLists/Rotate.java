package com.linkedLists;

public class Rotate
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

        MyLinkedList.print( rotate( 2, lList ) );
    }

    private static MyLinkedList rotate( int times,
                                        MyLinkedList lList )
    {
        Node tail = null;
        Node tempHead = null;
        Node head = lList.head;
        Node temp = head;

        int i = times;

        while( temp.next != null )
        {
            if( i - 1 == 0 )
                tempHead = temp;
            temp = temp.next;
            i--;
        }

        tail = temp;
        lList.head = tempHead.next;
        tempHead.next = null;
        tail.next = head;

        return lList;

    }

}
