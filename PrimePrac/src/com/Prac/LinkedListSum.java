package com.Prac;

import java.util.Stack;

public class LinkedListSum
{
    public static void main( String[] args )
    {
        String str1 = "1999";
        String str2 = "1";
        LLNode node1 = getLinkedList( str1 );
        LLNode node2 = getLinkedList( str2 );
        print( node1 );
        print( node2 );

        LLNode node = findSum( node1, node2 );
        System.out.println( "-------------> 1290780" );
        print( node );
    }

    private static LLNode findSum( LLNode node1,
                                   LLNode node2 )
    {
        Stack<LLNode> st1 = new Stack<>();
        Stack<LLNode> st2 = new Stack<>();

        LLNode tmp1 = node1;
        LLNode tmp2 = node2;

        StringBuilder stBuild = new StringBuilder();

        while( tmp1 != null )
        {
            st1.push( tmp1 );
            tmp1 = tmp1.next;
        }

        while( tmp2 != null )
        {
            st2.push( tmp2 );
            tmp2 = tmp2.next;
        }

        int carry = 0;

        while( !st1.isEmpty() && !st2.isEmpty() )
        {
            int t1 = st1.pop().data;
            int t2 = st2.pop().data;

            int sum = t1 + t2 + carry;

            if( sum <= 9 )
            {
                stBuild.append( sum );
                carry = 0;
            }
            else
            {
                stBuild.append( sum % 10 );
                carry = sum / 10;
            }
        }

        while( !st1.isEmpty() )
        {
            int sum = st1.pop().data + carry;
            if( sum <= 9 )
            {
                stBuild.append( sum );
                carry = 0;
            }
            else
            {
                stBuild.append( sum % 10 );
                carry = sum / 10;
            }
        }

        while( !st2.isEmpty() )
        {
            int sum = st2.pop().data + carry;
            if( sum <= 9 )
            {
                stBuild.append( sum );
                carry = 0;
            }
            else
            {
                stBuild.append( sum % 10 );
                carry = sum / 10;
            }
        }
        return getLinkedList( stBuild.reverse().toString() );
    }

    static LLNode getLinkedList( String str )
    {
        char[] c = str.toCharArray();
        LLNode head = new LLNode( Integer.valueOf( String.valueOf( c[0] ) ) );
        LLNode curr = head;
        for( int i = 1; i < c.length; i++ )
        {
            LLNode tmp = new LLNode( Integer.valueOf( String.valueOf( c[i] ) ) );
            curr.next = tmp;
            curr = tmp;
        }

        return head;
    }

    static void print( LLNode node )
    {
        while( node != null )
        {
            System.out.print( node.data + "" );
            node = node.next;
        }
        System.out.println();
    }

}

class LLNode
{
    int data;
    LLNode next;

    public LLNode( int data )
    {
        this.data = data;
    }
}
