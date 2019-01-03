package com.node;

public class TreeNode
{

    public int data;
    public TreeNode left;
    public TreeNode right;
    public int hd;

    public TreeNode( int data )
    {
        this.data = data;
    }

    public static TreeNode getTree()
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

        node8.left = node3;
        node8.right = node10;

        node3.left = node1;
        node3.right = node6;

        node6.left = node4;
        node6.right = node7;

        node10.right = node14;
        node10.left = node9;

        node14.left = node13;

        return node8;

    }

    public static TreeNode testCase1Tree()
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

    public static TreeNode testCase2Tree()
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

    public static TreeNode getTree1()
    {
        /**
         *          1
            2               3
        9       6       4       5
          10  11      2   7
                    12
         */

        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.left.left = new TreeNode( 9 );
        root.left.right = new TreeNode( 6 );
        root.right.left = new TreeNode( 4 );
        root.right.right = new TreeNode( 5 );
        root.right.left.left = new TreeNode( 12 );
        root.right.left.right = new TreeNode( 7 );
        root.left.right.left = new TreeNode( 11 );
        root.left.left.right = new TreeNode( 10 );

        return root;
    }

}
