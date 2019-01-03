package com.linkedLists;

public class MyLinkedList
{
    private int length = 0;

    Node head;

    public MyLinkedList()
    {
        length = 0;
    }

    public synchronized Node getHead()
    {
        return head;
    }

    // insert
    // a. insertAtBegining
    public void insertAtBeginning( Node node )
    {
        if( getHead() == null )
        {
            head.setNext( node );
            head = node;
        }
        else
        {
            node.next = head;
            head = node;
        }
        length++;

    }

    // b. insertAtEnd
    public void insertAtEnd( Node node )
    {
        if( head == null )
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while( temp.next != null )
            {
                temp = temp.next;
            }

            temp.next = node;
        }
    }

    public void insert( Node node )
    {
        if( head == null )
        {
            head = node;
        }
        else
        {
            insertAtEnd( node );
        }

        length++;

    }

    // c. insertAtPos
    public void insert( Node node,
                        int pos )
    {
        int i = 1;

        if( pos == 1 )
        {
            head = node;
        }
        else if( pos > length )
        {
            Node temp = head;
            while( temp.next != null )
            {
                temp = temp.next;
            }
            temp.next = node;

        }
        else
        {
            Node temp = head;

            while( i < pos )
            {
                temp = temp.next;
                i++;
            }

            node.next = temp.next;
            temp.next = node;

        }

    }

    public int getLength()
    {
        int i = 1;
        Node temp = head;
        while( temp.next != null )
        {
            temp = temp.next;
            i++;
        }
        return i;
    }

    // get
    // a. getFirst
    // b. getLast
    // c. getAtPos

    // delete
    // a. removeFirst
    // b. removeLast
    // c. removeAtPos

    // size
    // a. getSize

    //print

    public static void print( MyLinkedList list )
    {
        Node temp = list.getHead();
        System.out.print( "[ " );
        while( temp != null )
        {
            System.out.print( temp.data + "," );
            temp = temp.next;
        }
        System.out.print( " ]" );
        System.out.println( "" );
    }

    public static void main( String[] args )
    {
        Node n1 = new Node( 5 );
        Node n2 = new Node( 7 );
        Node n3 = new Node( 9 );

        MyLinkedList list = new MyLinkedList();
        list.insert( n1 );
        list.insert( n2 );
        list.insert( n3 );

        print( list );

        Node n4 = new Node( 6 );

        list.insert( n4, 1 );

        print( list );

    }

}
