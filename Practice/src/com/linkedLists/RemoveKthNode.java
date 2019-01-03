package com.linkedLists;

public class RemoveKthNode
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

        int k = 3;
        removeEveryKth( k, lList );
    }

    private static void removeEveryKth( int k,
                                        MyLinkedList lList )
    {
        Node temp = lList.head;
        int counter = k - 1;
        while( temp != null )
        {
            counter--;
            if( counter == 0 && temp.next != null && temp.next.next != null )
            {
                temp.next = temp.next.next;
                counter = k - 1;

            }

            temp = temp.next;

        }

        MyLinkedList.print( lList );

    }

}
