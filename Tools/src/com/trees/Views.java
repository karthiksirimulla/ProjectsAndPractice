package com.trees;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import com.node.TreeNode;
import com.tools.MyBST;

public class Views
{
    public static void main( String[] args )
    {
        MyBST bst = new MyBST();
        constructTree( bst );

        TreeNode tc1 = testCase1Tree();
        TreeNode tc2 = testCase2Tree();

        /**
         *       8
         *    3     10
         *  1   6      14
         *    4   7  13
         */

        // printLeftView( bst.root );
        printRightView( bst.root );
        //  System.out.println();
        //printRightView( tc2 );

        //printBottomView( tc2 );

        //printTopView( bst.root );

    }

    private static void printLeftView( TreeNode root )
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add( root );

        while( true )
        {
            int nodeCount = q.size();
            if( nodeCount == 0 )
                break;
            System.out.print( q.peek().data + ", " );
            while( nodeCount > 0 )
            {
                TreeNode temp = q.poll();
                if( temp.left != null )
                    q.add( temp.left );
                if( temp.right != null )
                    q.add( temp.right );

                nodeCount--;
            }
        }

    }

    private static void printRightView( TreeNode root )
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add( root );

        while( true )
        {
            int nodeCount = q.size();
            if( nodeCount == 0 )
                break;
            System.out.print( q.peek().data + ", " );
            while( nodeCount > 0 )
            {
                TreeNode temp = q.poll();
                if( temp.right != null )
                    q.add( temp.right );
                if( temp.left != null )
                    q.add( temp.left );

                nodeCount--;
            }
        }
    }

    private static void printBottomView( TreeNode root )
    {
        Queue<TreeNode> q = new LinkedList<>();
        TreeMap<Integer, TreeNode> tMap = new TreeMap<>();

        int hd = 0;
        root.hd = hd;

        q.add( root );
        tMap.put( hd, root );

        while( !q.isEmpty() )
        {
            TreeNode temp = q.poll();
            if( temp.left != null )
            {
                temp.left.hd = temp.hd - 1;
                q.add( temp.left );
                tMap.put( temp.hd - 1, temp.left );
            }

            if( temp.right != null )
            {
                temp.right.hd = temp.hd + 1;
                q.add( temp.right );
                tMap.put( temp.hd + 1, temp.right );
            }
        }

        for( Entry<Integer, TreeNode> entry : tMap.entrySet() )
        {
            System.out.print( entry.getValue().data + ", " );

        }

    }

    private static void printTopView( TreeNode root )
    {
        Queue<TreeNode> q = new LinkedList<>();
        TreeMap<Integer, TreeNode> tMap = new TreeMap<>();

        int hd = 0;
        root.hd = hd;

        q.add( root );
        tMap.put( hd, root );

        while( !q.isEmpty() )
        {
            TreeNode temp = q.poll();
            if( temp.left != null )
            {
                temp.left.hd = temp.hd - 1;
                q.add( temp.left );
                if( tMap.get( temp.hd - 1 ) == null )
                    tMap.put( temp.hd - 1, temp.left );
            }

            if( temp.right != null )
            {
                temp.right.hd = temp.hd + 1;
                q.add( temp.right );
                if( tMap.get( temp.hd + 1 ) == null )
                    tMap.put( temp.hd + 1, temp.right );
            }
        }

        for( Entry<Integer, TreeNode> entry : tMap.entrySet() )
        {
            System.out.print( entry.getValue().data + ", " );

        }

        System.out.println();

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

        TreeNode node9 = new TreeNode( 9 );

        bst.insert( node8 );
        bst.insert( node3 );
        bst.insert( node10 );
        bst.insert( node1 );
        bst.insert( node6 );
        bst.insert( node4 );
        bst.insert( node7 );
        bst.insert( node14 );
        bst.insert( node13 );
        bst.insert( node9 );

    }

    private static TreeNode testCase1Tree()
    {

        /**
         *     1
             /   \
            2     3
             \   
              4  
               \
                5
                 \
                  6
         */
        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        TreeNode node6 = new TreeNode( 6 );

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        node4.right = node5;

        node5.right = node6;

        return node1;

    }

    private static TreeNode testCase2Tree()
    {

        /**
         *     4
             /   \
            5     2
                 / \
                3   1
               / \
              6   7
              
         */

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        TreeNode node6 = new TreeNode( 6 );
        TreeNode node7 = new TreeNode( 7 );

        node4.left = node5;
        node4.right = node2;

        node2.left = node3;
        node2.right = node1;

        node3.left = node6;
        node3.right = node7;

        return node4;

    }

}
