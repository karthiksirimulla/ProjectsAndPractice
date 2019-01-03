package com.Prac.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins
{
    public static void main( String[] args )
    {
        Node rNode = getTree();
        int data = 5;
        printCousins( rNode, data );
        //printer( rNode );
    }

    private static void printCousins( Node node,
                                      int data )
    {
        if( node.data == data )
        {
            System.out.println( "No Cousins" );
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add( node );

        boolean flag = false;
        boolean print = false;

        while( true )
        {
            if( q.isEmpty() )
                break;
            int nodeCount = q.size();
            while( nodeCount > 0 )
            {
                Node tempNode = q.poll();
                if( tempNode.left != null )
                    q.add( tempNode.left );
                if( tempNode.right != null )
                    q.add( tempNode.right );
                if( tempNode.left.data == data || tempNode.right.data == data )
                    flag = true;

                nodeCount--;
            }

            if( flag )
            {
                for( Node nq : q )
                {
                    if( nq.data == data )
                    {
                        print = true;
                        continue;
                    }
                    if( print )
                        System.out.print( nq.data + ", " );
                }

                break;

            }

        }

    }

    private static void printer( Node node )
    {
        if( node == null )
            return;

        Queue<Node> q = new LinkedList<>();
        q.add( node );

        while( true )
        {
            if( q.isEmpty() )
                break;
            int nodeCount = q.size();
            while( nodeCount > 0 )
            {
                Node tempNode = q.poll();
                System.out.print( tempNode.data + ", " );
                if( tempNode.left != null )
                    q.add( tempNode.left );
                if( tempNode.right != null )
                    q.add( tempNode.right );
                nodeCount--;
            }
            System.out.println();
        }

    }

    private static Node getTree()
    {
        /*
         *  1
           /   \
          2     3
        /   \  /  \
        4    5  6   7
         */
        Node node1 = new Node( 1 );
        Node node2 = new Node( 2 );
        Node node3 = new Node( 3 );
        Node node4 = new Node( 4 );
        Node node5 = new Node( 5 );
        Node node6 = new Node( 6 );
        Node node7 = new Node( 7 );

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        return node1;
    }

}
