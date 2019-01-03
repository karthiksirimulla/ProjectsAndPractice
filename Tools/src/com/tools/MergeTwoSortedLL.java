package com.tools;

import com.core.MLL;
import com.node.Node;

public class MergeTwoSortedLL
{

    public static void main( String[] args )
    {
        MLL lst1 = new MLL();
        lst1.insert( new Node( 1 ) );
        lst1.insert( new Node( 3 ) );
        lst1.insert( new Node( 5 ) );
        lst1.insert( new Node( 7 ) );
        lst1.insert( new Node( 9 ) );

        MLL lst2 = new MLL();
        lst2.insert( new Node( 2 ) );
        lst2.insert( new Node( 4 ) );
        lst2.insert( new Node( 6 ) );
        lst2.insert( new Node( 8 ) );
        lst2.insert( new Node( 10 ) );
        lst2.insert( new Node( 11 ) );

        Node n = merge( lst1, lst2 );

        while( n != null )
        {
            System.out.print( n.data + "," );
            n = n.next;
        }

    }

    private static Node merge( MLL lst1,
                               MLL lst2 )
    {
        Node temp1 = lst1.head;
        Node temp2 = lst2.head;
        Node head = new Node( 0 );
        Node retHead = head;

        while( temp1 != null && temp2 != null )
        {
            if( temp1.data < temp2.data )
            {
                retHead.next = temp1;
                temp1 = temp1.next;
            }
            else
            {
                retHead.next = temp2;
                temp2 = temp2.next;

            }
            retHead = retHead.next;

        }

        if( temp1 != null )
        {
            retHead.next = temp1;
        }

        if( temp2 != null )
        {
            retHead.next = temp2;
        }

        return head.next;

    }

}
