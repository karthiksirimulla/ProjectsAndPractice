package com.linkedLists;

public class InsertIntoSortedCircularLinkedList
{
    public static void main( String[] args )
    {
        MyLinkedList lList = new MyLinkedList();
        lList.insert( new Node( 5 ) );
        lList.insert( new Node( 8 ) );
        lList.insert( new Node( 11 ) );
        lList.insert( new Node( 13 ) );
        lList.insert( new Node( 17 ) );
        Node circ = new Node( 19 );
        circ.next = lList.head;
        lList.insert( circ );
        insert( new Node( 22 ), lList );

    }

    private static void insert( Node node,
                                MyLinkedList lList )
    {
        Node temp = lList.head;
        boolean flag = false;

        if( temp == null )
        {
            lList.head = node;
            node.next = node;
            return;
        }

        if( temp.next == null )
        {
            if( temp.data < node.data )
            {
                temp.next = node;
                node.next = temp;
            }
            else
            {
                lList.head = node;
                node.next = temp;
                temp.next = node;
            }
        }

        while( temp != null )
        {

            if( ( temp.data < node.data && node.data < temp.next.data ) )
            {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;

            if( temp.next.data == lList.head.data )
            {
                flag = true;
                break;
            }

        }

        if( flag )
        {
            node.next = temp.next;
            temp.next = node;

        }

        print( lList );

    }

    private static void print( MyLinkedList lList )
    {
        Node temp = lList.head;

        while( temp != null )
        {
            System.out.print( temp.data + "," );
            temp = temp.next;
            if( temp.data == lList.head.data )
                break;
        }

    }

}
