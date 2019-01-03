package com.Prac.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraversePrac
{
    public static void main( String[] args )
    {
        Node rNode = Node.getTree();
        System.out.println( "--- PreOrder ----" );
        preOrderRecursive( rNode );
        System.out.println();
        preOrderIterative( rNode );
        System.out.println( "\n8, 3, 1, 6, 4, 7, 10, 9, 14, 13\n" );
        System.out.println( "--- InOrder ----" );
        InorderRecursive( rNode );
        System.out.println();
        InOrderIterative( rNode );
        System.out.println( "\n1, 3, 4, 6, 7, 8, 9, 10, 13, 14, \n" );
        System.out.println( "--- PostOrder ----\n" );
        postOrderRecursive( rNode );
        System.out.println( "\n1, 4, 7, 6, 3, 9, 13, 14, 10, 8,\n" );
        System.out.println( "--- LevelOrder ----" );
        levelOrder( rNode );
        System.out.println( "\n8, 3, 10, 1, 6, 9, 14, 4, 7, 13,\n" );
        System.out.println( "--- Level Order in Levels ----" );
        levelOrderInLevels( rNode );
        System.out.println( "--- ZigZag----\n" );
        zigZag( rNode );

    }

    private static void zigZag( Node node )
    {
        Stack<Node> qt = new Stack<>();
        Stack<Node> st = new Stack<>();

        qt.add( node );

        while( true )
        {
            if( qt.isEmpty() && st.isEmpty() )
                break;

            while( !qt.isEmpty() )
            {
                Node tempNode = qt.pop();
                System.out.print( tempNode.data + ", " );
                if( tempNode.left != null )
                    st.push( tempNode.left );
                if( tempNode.right != null )
                    st.push( tempNode.right );
            }
            System.out.println();
            while( !st.isEmpty() )
            {
                Node tempNode = st.pop();
                System.out.print( tempNode.data + ", " );
                if( tempNode.right != null )
                    qt.push( tempNode.right );
                if( tempNode.left != null )
                    qt.push( tempNode.left );
            }
            System.out.println();
        }

    }

    private static void levelOrderInLevels( Node node )
    {
        Queue<Node> qOdd = new LinkedList<>();
        Queue<Node> qEven = new LinkedList<>();

        qOdd.add( node );

        while( true )
        {
            if( qOdd.isEmpty() && qEven.isEmpty() )
                break;
            while( !qOdd.isEmpty() )
            {
                Node tempNode = qOdd.poll();
                System.out.print( tempNode.data + ", " );
                if( tempNode.left != null )
                    qEven.add( tempNode.left );
                if( tempNode.right != null )
                    qEven.add( tempNode.right );
            }

            System.out.println();

            while( !qEven.isEmpty() )
            {
                Node tempNode = qEven.poll();
                System.out.print( tempNode.data + ", " );
                if( tempNode.left != null )
                    qOdd.add( tempNode.left );
                if( tempNode.right != null )
                    qOdd.add( tempNode.right );

            }
            System.out.println();
        }
    }

    public static void levelOrder( Node node )
    {
        Queue<Node> q = new LinkedList<>();
        q.add( node );

        while( !q.isEmpty() )
        {
            Node tempNode = q.poll();
            System.out.print( tempNode.data + ", " );
            if( tempNode.left != null )
                q.add( tempNode.left );
            if( tempNode.right != null )
                q.add( tempNode.right );

        }

    }

    private static void InOrderIterative( Node node )
    {
        Stack<Node> st = new Stack<>();
        Node tNode = node;
        while( tNode != null )
        {
            st.push( tNode );
            tNode = tNode.left;
        }

        while( !st.isEmpty() )
        {
            Node tempNode = st.pop();
            System.out.print( tempNode.data + ", " );
            if( tempNode.right != null )
            {
                tempNode = tempNode.right;
                while( tempNode != null )
                {
                    st.push( tempNode );
                    tempNode = tempNode.left;
                }
            }

        }

    }

    private static void preOrderIterative( Node node )
    {
        Stack<Node> st = new Stack<>();
        st.push( node );
        while( !st.isEmpty() )
        {
            Node tempNode = st.pop();
            System.out.print( tempNode.data + ", " );
            if( tempNode.right != null )
                st.push( tempNode.right );
            if( tempNode.left != null )
                st.push( tempNode.left );
        }

    }

    private static void postOrderRecursive( Node node )
    {
        // TODO LRD
        if( node == null )
            return;
        postOrderRecursive( node.left );
        postOrderRecursive( node.right );
        System.out.print( node.data + ", " );

    }

    private static void InorderRecursive( Node node )
    {
        // TODO LDR
        if( node == null )
            return;
        InorderRecursive( node.left );
        System.out.print( node.data + ", " );
        InorderRecursive( node.right );

    }

    private static void preOrderRecursive( Node node )
    {
        // DLR
        if( node == null )
            return;
        System.out.print( node.data + ", " );
        preOrderRecursive( node.left );
        preOrderRecursive( node.right );

    }

}
