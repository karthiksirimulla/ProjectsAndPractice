package com.node;

public class LLNode
{
    public int data;
    public LLNode next;

    public LLNode( int data )
    {
        this.data = data;
    }

    public static void print( LLNode head )
    {
        LLNode temp = head;
        while( temp != null )
        {
            System.out.print( temp.data + ", " );
            temp = temp.next;
        }
        System.out.println();
    }

}
