package com.core;

import com.node.Node;

public class MLL
{
    public Node head;

    public int length = 0;

    public void insert( Node n )
    {
        if( head == null )
        {
            head = n;
            length++;
            return;
        }

        Node temp = head;

        while( temp.next != null )
        {
            temp = temp.next;
        }

        temp.next = n;
        length++;
        return;

    }

    public void print()
    {
        Node temp = head;
        while( temp != null )
        {
            System.out.print( temp.data );
            temp = temp.next;
            System.out.print( "->" );
        }
        System.out.println();

    }

}
