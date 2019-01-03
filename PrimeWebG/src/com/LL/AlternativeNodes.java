package com.LL;

import com.creator.LLCreator;
import com.node.LLNode;

public class AlternativeNodes
{
    public static void main( String[] args )
    {
        LLNode head = LLCreator.create();
        print( head );
        printAlternate( head );
        LLNode res = deleteAlterate( head );
        print( res );

    }

    private static void printAlternate( LLNode head )
    {
        LLNode temp = head;

        while( temp != null )
        {
            System.out.print( temp.data + ", " );
            if( temp.next == null || temp.next.next == null )
                break;
            temp = temp.next.next;

        }
        System.out.println();
    }

    private static void print( LLNode head )
    {
        LLNode temp = head;
        while( temp != null )
        {
            System.out.print( temp.data + ", " );
            temp = temp.next;
        }
        System.out.println();
    }

    private static LLNode deleteAlterate( LLNode head )
    {
        LLNode temp = head;
        while( temp != null )
        {
            if( temp.next == null || temp.next.next == null )
                break;
            LLNode tmp = temp.next.next;
            temp.next = temp.next.next;
            temp = tmp;

        }
        return head;
    }

}
