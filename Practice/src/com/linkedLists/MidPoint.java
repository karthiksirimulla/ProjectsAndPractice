package com.linkedLists;

public class MidPoint
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
        lList.insert( new Node( 23 ) );
        lList.insert( new Node( 33 ) );
        lList.insert( new Node( 37 ) );
        MyLinkedList.print( lList );

        Node midNode = findMid( lList );

        System.out.println( "Mid :" + midNode.getData() );
    }

    private static Node findMid( MyLinkedList lList )
    {
        Node head = lList.head;
        Node fastNode = head;
        Node slowNode = head;

        while( fastNode != null && fastNode.next != null )
        {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

}
