package com.LinkedLists;

import com.core.MLL;
import com.node.Node;

public class Multiply
{
    public static void main( String[] args )
    {
        MLL list = new MLL();
        list.insert( new Node( 9 ) );
        list.insert( new Node( 4 ) );
        list.insert( new Node( 6 ) );

        MLL list1 = new MLL();
        list1.insert( new Node( 8 ) );
        list1.insert( new Node( 4 ) );

        int num1 = formNumber( list );
        int num2 = formNumber( list1 );
        System.out.println( num1 * num2 );

        int num = num1 * num2;

        Node head = formLinkedList( num );

        while( head != null )
        {
            System.out.print( head.data + ", " );
            head = head.next;
        }
    }

    private static Node formLinkedList( int num )
    {
        int n = -1;
        int temp = num;

        while( temp > 0 )
        {
            temp = temp / 10;
            n++;
        }

        Node nHead = new Node( 0 );
        Node res = nHead;

        while( n >= 0 )
        {
            int tmp = num;
            int msb = tmp / (int) Math.pow( 10, n );
            num = num % (int) Math.pow( 10, n );
            n--;

            Node nTemp = new Node( msb );
            nHead.next = nTemp;
            nHead = nHead.next;

        }
        return res.next;
    }

    private static int formNumber( MLL list )
    {
        Node temp = list.head;

        if( temp == null )
            return 0;

        int num = 0;

        while( temp != null )
        {
            num = num * 10 + temp.data;
            temp = temp.next;

        }

        return num;
    }

}
