package com.BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.node.TreeNode;

public class Traversals
{
    public static void main( String[] args )
    {
        TreeNode root = TreeNode.getTree();
        System.out.println( "------------PreOrder-------------" );
        preOrder( root );
        System.out.println( "" );
        System.out.println( "-----------Inorder--------------" );
        inOrder( root );
        System.out.println( "" );
        System.out.println( "-----------Reverse Inorder--------------" );
        reverseInOrder( root );
        System.out.println( "" );
        System.out.println( "-----------Postorder--------------" );
        postOrder( root );
        System.out.println( "" );
        System.out.println( "-----------Levelorder--------------" );
        levelOrder( root );
        System.out.println( "" );
        System.out.println( "-----------Levelorder - Levels--------------" );
        levelOrderLevels( root );
        System.out.println( "" );
        System.out.println( "-----------ZigZag--------------" );
        ZigZag( root );
        System.out.println( "" );
        System.out.println( "-----------nTh Node in inOrder Traversal--------------" );
        inOrderNth( root, new Sum(), 3 );
        System.out.println( "----------- Diagonal Print --------------" );
        diagonal( root );
    }

    public static void preOrder( TreeNode node )
    {
        //Root, Left, Right
        if( node == null )
            return;
        System.out.print( node.data + ", " );
        preOrder( node.left );
        preOrder( node.right );

    }

    public static void inOrder( TreeNode node )
    {
        //Left, Root, Right
        if( node == null )
            return;
        inOrder( node.left );
        System.out.print( node.data + ", " );
        inOrder( node.right );

    }

    public static void postOrder( TreeNode node )
    {
        //Left, Right, Root
        if( node == null )
            return;
        postOrder( node.left );
        postOrder( node.right );
        System.out.print( node.data + ", " );

    }

    public static void levelOrder( TreeNode node )
    {
        if( node == null )
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add( node );

        while( !q.isEmpty() )
        {
            TreeNode temp = q.poll();
            System.out.print( temp.data + ", " );
            if( temp.left != null )
                q.add( temp.left );
            if( temp.right != null )
                q.add( temp.right );
        }

    }

    public static void levelOrderLevels( TreeNode node )
    {
        if( node == null )
            return;
        Queue<TreeNode> sq = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        sq.add( node );

        while( true )
        {
            if( sq.isEmpty() && pq.isEmpty() )
                break;
            while( !sq.isEmpty() )
            {
                TreeNode temp = sq.poll();
                System.out.print( temp.data + ", " );
                if( temp.left != null )
                    pq.add( temp.left );
                if( temp.right != null )
                    pq.add( temp.right );
            }
            System.out.println();

            while( !pq.isEmpty() )
            {
                TreeNode temp = pq.poll();
                System.out.print( temp.data + ", " );
                if( temp.left != null )
                    sq.add( temp.left );
                if( temp.right != null )
                    sq.add( temp.right );

            }
            System.out.println();
        }
    }

    public static void ZigZag( TreeNode node )
    {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add( node );

        boolean flag = true;

        while( true )
        {
            if( s1.isEmpty() && s2.isEmpty() )
                break;

            if( flag )
            {
                while( !s1.isEmpty() )
                {
                    TreeNode temp = s1.pop();
                    System.out.print( temp.data + ", " );
                    if( temp.right != null )
                        s2.push( temp.right );
                    if( temp.left != null )
                        s2.push( temp.left );

                }
                System.out.println();
            }
            else
            {

                while( !s2.isEmpty() )
                {
                    TreeNode temp = s2.pop();
                    System.out.print( temp.data + ", " );
                    if( temp.left != null )
                        s1.add( temp.left );
                    if( temp.right != null )
                        s1.add( temp.right );

                }
                System.out.println();
            }
            flag = !flag;

        }
    }

    public static void inOrderNth( TreeNode node,
                                   Sum s,
                                   int n )
    {
        if( node == null )
            return;
        inOrderNth( node.left, s, n );
        s.sum = s.sum + 1;
        if( s.sum == n )
            System.out.println( node.data );
        inOrderNth( node.right, s, n );

    }

    private static void reverseInOrder( TreeNode node )
    {
        if( node == null )
            return;
        reverseInOrder( node.right );
        System.out.print( node.data + ", " );
        reverseInOrder( node.left );

    }

    private static void diagonal( TreeNode node )
    {
        if( node == null )
            return;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp = node;
        q.add( temp );
        while( !q.isEmpty() )
        {
            TreeNode n = q.poll();
            while( n != null )
            {
                System.out.print( n.data + ", " );
                if( n.left != null )
                    q.add( n.left );
                n = n.right;
            }
            System.out.println();
        }

    }

}
