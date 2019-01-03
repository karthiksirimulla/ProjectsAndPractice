package com.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.node.TreeNode;
import com.tools.MyBST;

public class RecursiveTraversals
{

    public static void main( String[] args )
    {
        MyBST bst = new MyBST();
        constructTree( bst );
        // Traversals.displayInOrder( bst );
        // printInorder( MyBST.root );
        // System.out.println( "---------" );
        // printPreorder( MyBST.root );
        // printSpiralorder( MyBST.root );
        // printDiagonalorder( MyBST.root );
        printLevelorder( MyBST.root );
        childrenSum( MyBST.root );
        printLevelorder( MyBST.root );
    }

    private static void printInorder( TreeNode node )
    {
        if( node == null )
            return;
        printInorder( node.left );
        System.out.print( node.data + ", " );
        printInorder( node.right );

    }

    private static void printPreorder( TreeNode node )
    {
        if( node == null )
            return;
        System.out.print( node.data + ", " );
        printPreorder( node.left );
        printPreorder( node.right );

    }

    private static void printLevelorder( TreeNode node )
    {
        if( node == null )
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add( node );

        while( true )
        {
            int nodeCount = queue.size();
            if( nodeCount == 0 )
                break;
            while( nodeCount > 0 )
            {
                TreeNode temp = queue.poll();
                System.out.print( temp.data + ", " );
                if( temp.left != null )
                    queue.add( temp.left );
                if( temp.right != null )
                    queue.add( temp.right );
                nodeCount--;
            }
            System.out.println();

        }

    }

    private static void printSpiralorder( TreeNode node )
    {
        int level = 1;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add( node );

        while( true )
        {
            int nodeStack1 = s1.size();
            int nodeStack2 = s2.size();

            if( nodeStack1 == 0 && nodeStack2 == 0 )
                break;

            if( level % 2 != 0 )
            {
                while( nodeStack1 > 0 )
                {
                    TreeNode temp = s1.pop();
                    System.out.print( temp.data + ", " );
                    if( temp.right != null )
                        s2.push( temp.right );
                    if( temp.left != null )
                        s2.push( temp.left );

                    nodeStack1--;
                }

            }
            else
            {

                while( nodeStack2 > 0 )
                {
                    TreeNode temp = s2.pop();
                    System.out.print( temp.data + ", " );
                    if( temp.left != null )
                        s1.add( temp.left );
                    if( temp.right != null )
                        s1.add( temp.right );

                    nodeStack2--;
                }

            }
            level++;
        }

    }

    private static void printDiagonalorder( TreeNode node )
    {
        TreeNode temp = node;
        Queue<TreeNode> q = new LinkedList<>();
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

        }
    }

    private static void childrenSum( TreeNode node )
    {
        if( node == null )
            return;
        if( node.left != null && node.right != null )
            node.data = node.left.data + node.right.data;
        childrenSum( node.left );
        childrenSum( node.right );

    }

    private static void leftSubtreeSum( TreeNode node )
    {

    }

    private static void constructTree( MyBST bst )
    {

        /**
         *       8
         *    3     10
         *  1   6      14
         *    4   7  13
         */

        TreeNode node8 = new TreeNode( 8 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node10 = new TreeNode( 10 );
        TreeNode node1 = new TreeNode( 1 );
        TreeNode node6 = new TreeNode( 6 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node7 = new TreeNode( 7 );
        TreeNode node14 = new TreeNode( 14 );
        TreeNode node13 = new TreeNode( 13 );

        bst.insert( node8 );
        bst.insert( node3 );
        bst.insert( node10 );
        bst.insert( node1 );
        bst.insert( node6 );
        bst.insert( node4 );
        bst.insert( node7 );
        bst.insert( node14 );
        bst.insert( node13 );

    }

}
