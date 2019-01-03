package com.tools;

import java.util.Stack;

import com.core.MLL;
import com.node.Node;

public class RevLL
{
    public static void main( String[] args )
    {
        MLL list = new MLL();
        list.insert( new Node( 3 ) );
        list.insert( new Node( 5 ) );
        list.insert( new Node( 7 ) );
        list.insert( new Node( 9 ) );
        list.insert( new Node( 11 ) );
        list.insert( new Node( 15 ) );
        list.insert( new Node( 24 ) );

        list.print();

        //reverseLL( list );
        // RevStack( list );
        revRecursive( list.head );

    }

    private static void reverseLL( MLL list )
    {
        Node prev = null;
        Node nxt = null;
        Node current = list.head;

        while( current != null )
        {
            nxt = current.next;// stores next 
            current.next = prev;// link de-pointing
            prev = current;
            current = nxt;

        }
        list.head = prev;

        list.print();
    }

    private static void ReverseAcc( MLL list )
    {
        Node prev = null;
        Node nxt = null;
        Node temp = list.head;

        while( temp != null )
        {
            nxt = temp.next;
            temp.next = prev;// pointing to null
            prev = temp;// updating prev  to head & so on
            temp = nxt;//
        }

        list.head = prev;
        list.print();

    }

    private static void RevStack( MLL list )
    {
        Stack<Node> s = new Stack<>();
        Node head = list.head;

        while( head != null )
        {
            s.push( head );
            head = head.next;
        }

        list.head = s.peek();
        Node temp = null;

        while( true )
        {
            temp = s.pop();
            if( s.isEmpty() )
            {
                temp.next = null;
                break;
            }
            else
            {
                temp.next = s.peek();
            }
        }

        list.print();
    }

    private static void revRecursive( Node node )
    {
        if( node == null )
        {
            return;
        }

        revRecursive( node.next );
        System.out.print( node.data + "->" );

    }
}
