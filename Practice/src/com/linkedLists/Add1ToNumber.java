package com.linkedLists;

public class Add1ToNumber
{
    public static void main( String[] args )
    {
        MyLinkedList lList = new MyLinkedList();
        lList.insert( new Node( 1 ) );
        lList.insert( new Node( 9 ) );
        lList.insert( new Node( 8 ) );
        lList.insert( new Node( 9 ) );

        increment( lList );
        System.out.print( "1989 : " );
        MyLinkedList.print( lList );

        lList = new MyLinkedList();
        lList.insert( new Node( 1 ) );
        lList.insert( new Node( 9 ) );
        lList.insert( new Node( 9 ) );
        lList.insert( new Node( 9 ) );
        increment( lList );
        System.out.print( "1999 : " );
        MyLinkedList.print( lList );

        lList = new MyLinkedList();
        lList.insert( new Node( 1 ) );
        lList.insert( new Node( 9 ) );
        lList.insert( new Node( 8 ) );
        lList.insert( new Node( 7 ) );
        increment( lList );
        System.out.print( "1987 : " );
        MyLinkedList.print( lList );

    }

    private static void increment( MyLinkedList lList )
    {
        reverse( lList );
        Node temp = lList.head;
        while( temp != null )
        {
            if( temp.data % 10 == temp.data && temp.data != 9 )
            {
                temp.data = temp.data + 1;
                break;
            }
            else if( temp.data == 9 )
            {
                temp.data = 0;
                temp = temp.next;
            }
            else
            {
                temp.data = temp.data % 10;
                temp = temp.next;
            }
        }

        reverse( lList );

    }

    private static void reverse( MyLinkedList lList )
    {
        Node prev = null;
        Node curr = lList.head;
        Node next = curr.next;

        while( curr != null )
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            if( next != null )
                next = next.next;
        }
        lList.head = prev;
    }

}
