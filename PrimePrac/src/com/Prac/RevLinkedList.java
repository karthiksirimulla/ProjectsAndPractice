package com.Prac;

public class RevLinkedList
{
    static Node head;

    public static void main( String[] args )
    {
        head = getLL();
        print( head );
        reverseRecursive( head );
        print( head );
        //1->2->3->4->5

    }

    private static void reverseRecursive( Node node )
    {
        if( node.next == null )
        {
            head = node;
            return;
        }
        reverseRecursive( node.next );
        Node nxt = node.next;
        nxt.next = node;
        node.next = null;
    }

    static void print( Node n )
    {
        while( n != null )
        {
            System.out.print( n.data + " " );
            n = n.next;
        }
        System.out.println();
    }

    static Node getLL()
    {
        Node n1 = new Node( 1 );
        Node n2 = new Node( 2 );
        Node n3 = new Node( 3 );
        Node n4 = new Node( 4 );
        Node n5 = new Node( 5 );

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;

    }
}

class Node
{
    int data;
    Node next;

    Node( int data )
    {
        this.data = data;
    }

}
