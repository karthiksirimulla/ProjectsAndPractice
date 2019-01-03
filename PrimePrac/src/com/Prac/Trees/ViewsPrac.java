package com.Prac.Trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class ViewsPrac
{
    public static void main( String[] args )
    {
        Node rNode = Node.getTree();
        System.out.println( "--- Left View ---" );
        leftView( rNode );
        System.out.println( "\n--- Right View ---" );
        rightView( rNode );
        System.out.println( "\n--- Top View ---" );
        topView( rNode );
        System.out.println( "\n--- Bottom View ---" );
        bottomView( rNode );

    }

    private static void bottomView( Node node )
    {
        Stack<Node> st = new Stack<>();
        node.hd = 0;
        st.push( node );
        Map<Integer, Integer> map = new TreeMap<>();
        map.put( node.hd, node.data );

        while( !st.isEmpty() )
        {
            Node tempNode = st.pop();
            if( tempNode.right != null )
            {
                tempNode.right.hd = tempNode.hd + 1;
                st.push( tempNode.right );
                map.put( tempNode.right.hd, tempNode.right.data );
            }
            if( tempNode.left != null )
            {
                tempNode.left.hd = tempNode.hd - 1;
                st.push( tempNode.left );
                map.put( tempNode.left.hd, tempNode.left.data );
            }
        }

        for( Entry<Integer, Integer> eObj : map.entrySet() )
            System.out.print( eObj.getValue() + ", " );

    }

    private static void topView( Node node )
    {
        Stack<Node> st = new Stack<>();
        node.hd = 0;
        st.push( node );
        Map<Integer, Integer> map = new TreeMap<>();
        map.put( node.hd, node.data );

        while( !st.isEmpty() )
        {
            Node tempNode = st.pop();
            if( tempNode.right != null )
            {
                tempNode.right.hd = tempNode.hd + 1;
                st.push( tempNode.right );

                if( !map.containsKey( tempNode.right.hd ) )
                    map.put( tempNode.right.hd, tempNode.right.data );
            }
            if( tempNode.left != null )
            {
                tempNode.left.hd = tempNode.hd - 1;
                st.push( tempNode.left );
                if( !map.containsKey( tempNode.left.hd ) )
                    map.put( tempNode.left.hd, tempNode.left.data );
            }
        }

        for( Entry<Integer, Integer> eObj : map.entrySet() )
            System.out.print( eObj.getValue() + ", " );

    }

    private static void leftView( Node node )
    {
        Queue<Node> q = new LinkedList<>();
        q.add( node );

        while( true )
        {
            int nodeCount = q.size();
            if( nodeCount == 0 )
                break;
            System.out.print( q.peek().data + ", " );
            while( nodeCount > 0 )
            {
                Node tempNode = q.poll();
                if( tempNode.left != null )
                    q.add( tempNode.left );
                if( tempNode.right != null )
                    q.add( tempNode.right );
                nodeCount--;
            }
        }

    }

    private static void rightView( Node node )
    {
        Queue<Node> q = new LinkedList<>();
        q.add( node );

        while( true )
        {
            int nodeCount = q.size();
            if( nodeCount == 0 )
                break;
            System.out.print( q.peek().data + ", " );
            while( nodeCount > 0 )
            {
                Node tempNode = q.poll();
                if( tempNode.right != null )
                    q.add( tempNode.right );
                if( tempNode.left != null )
                    q.add( tempNode.left );
                nodeCount--;
            }
        }

    }

}
