package com.tools;

import com.core.MLL;
import com.node.Node;

public class findNodeFromLast
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

        findNthNodeFromLast( list, 3 );

    }

    private static void findNthNodeFromLast( MLL list,
                                             int i )
    {
        Node slow = list.head;
        Node fast = list.head;
        int count = i;
        while( count > 0 )
        {
            fast = fast.next;
            count--;
        }

        while( fast != null )
        {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println( slow.data );

    }

}
