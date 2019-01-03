package com.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.node.TreeNode;
import com.tools.MyBST;

public class Traversals
{

    static void displayInOrder( MyBST bst )
    {
        TreeNode node = MyBST.root;
        Stack<TreeNode> s = new Stack<>();
        System.out.println( "----------- InOrder Traversal -------------" );
        while( node != null )
        {
            s.push( node );
            node = node.left;
        }

        while( !s.isEmpty() )
        {
            node = s.pop();
            System.out.print( node.data + ", " );
            if( node.right != null )
            {
                node = node.right;
                while( node != null )
                {
                    s.push( node );
                    node = node.left;

                }
            }
        }
        System.out.println();
        System.out.println( "-------------------------" );
        System.out.println();
    }

    static void displayLevelOrder( MyBST bst )
    {
        TreeNode node = MyBST.root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add( node );

        System.out.println( "------ Level Traversal --------" );

        while( !q.isEmpty() )
        {
            node = q.poll();
            System.out.print( node.data + ", " );
            if( node.left != null )
            {
                q.add( node.left );
            }
            if( node.right != null )
            {
                q.add( node.right );
            }
        }
        System.out.println();
        System.out.println( "-------------------------" );
    }

    static void displayPreOrder( MyBST bst )
    {
        TreeNode node = MyBST.root;
        Stack<TreeNode> s = new Stack<>();
        /**
         *       8
         *    3     10
         *  1   6      14
         *    4   7  13
         */

        //DLR
        // 8,3,1,6,4,7,10,14,13

        s.push( node );
        while( !s.isEmpty() )
        {
            TreeNode temp = s.pop();
            System.out.print( temp.data + ", " );
            if( temp.right != null )
                s.push( temp.right );
            if( temp.left != null )
                s.push( temp.left );

        }
    }

    static void zigzagTraversal( MyBST bst )
    {
        TreeNode rootNode = bst.root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add( rootNode );
        boolean flag = true;
        System.out.println( "-------- ZizZag Traversal -------------" );
        while( !queue.isEmpty() )
        {
            TreeNode temp = queue.poll();
            System.out.print( temp.data + ", " );

            if( flag )
            {
                if( temp.left != null )
                {
                    queue.add( temp.left );
                }

                if( temp.right != null )
                {
                    queue.add( temp.right );
                }

            }
            else
            {

                if( temp.right != null )
                {
                    queue.add( temp.right );
                }

                if( temp.left != null )
                {
                    queue.add( temp.left );
                }

            }

            flag = !flag;
        }

        System.out.println();
        System.out.println( "-------------------------" );
        System.out.println();

    }

    static void heightUsingLevelOrder( MyBST bst )
    {
        TreeNode rootNode = bst.root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add( rootNode );
        int height = 0;
        while( !queue.isEmpty() )
        {
            TreeNode temp = queue.poll();

            if( temp == null )
            {
                height++;
            }

            if( temp.left != null )
            {
                queue.add( temp.left );
            }

            if( temp.right != null )
            {
                queue.add( temp.right );
            }

            queue.add( null );

        }

        System.out.println();
        System.out.println( "-------------------------" );
        System.out.println();

    }

    public static void main( String[] args )
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

        MyBST bst = new MyBST();
        bst.insert( node8 );
        bst.insert( node3 );
        bst.insert( node10 );
        bst.insert( node1 );
        bst.insert( node6 );
        bst.insert( node4 );
        bst.insert( node7 );
        bst.insert( node14 );
        bst.insert( node13 );

        // displayInOrder( bst );
        //displayLevelOrder( bst );
        zigzagTraversal( bst );
        // displayPreOrder( bst );
    }

}
