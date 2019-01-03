package com.Prac.Trees;

public class Node
{
    int data;
    Node left;
    Node right;
    int hd;

    public Node( int data )
    {
        this.data = data;
    }

    public static Node getTree()
    {

        /**
         *       8
         *    3     10
         *  1   6      14
         *    4   7  13
         */

        Node node8 = new Node( 8 );
        Node node3 = new Node( 3 );
        Node node10 = new Node( 10 );
        Node node1 = new Node( 1 );
        Node node6 = new Node( 6 );
        Node node4 = new Node( 4 );
        Node node7 = new Node( 7 );
        Node node14 = new Node( 14 );
        Node node13 = new Node( 13 );

        Node node9 = new Node( 9 );

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

    public static Node testCase1Tree()
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
        Node node1 = new Node( 1 );
        Node node2 = new Node( 2 );
        Node node3 = new Node( 3 );
        Node node4 = new Node( 4 );
        Node node5 = new Node( 5 );
        Node node6 = new Node( 6 );

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        node4.right = node5;

        node5.right = node6;

        return node1;

    }

    public static Node testCase2Tree()
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

        Node node1 = new Node( 1 );
        Node node2 = new Node( 2 );
        Node node3 = new Node( 3 );
        Node node4 = new Node( 4 );
        Node node5 = new Node( 5 );
        Node node6 = new Node( 6 );
        Node node7 = new Node( 7 );

        node4.left = node5;
        node4.right = node2;

        node2.left = node3;
        node2.right = node1;

        node3.left = node6;
        node3.right = node7;

        return node4;

    }

    public static Node getGeeksTree()
    {

        /**
         *         1
         *    3         2
         *           5    4
         *   
         */

        Node node1 = new Node( 1 );
        Node node2 = new Node( 2 );
        Node node3 = new Node( 3 );
        Node node4 = new Node( 4 );
        Node node5 = new Node( 5 );
        Node node6 = new Node( 6 );
        Node node7 = new Node( 7 );

        node1.left = node3;
        node1.right = node2;

        node2.left = node5;
        node2.right = node4;

        node3.left = node6;
        node3.right = node7;

        return node1;

    }

    public static Node getTree1()
    {
        /**
         *          1
            2               3
        9       6       4       5
          10  11      2   7
                    12
         */

        Node root = new Node( 1 );
        root.left = new Node( 2 );
        root.right = new Node( 3 );
        root.left.left = new Node( 9 );
        root.left.right = new Node( 6 );
        root.right.left = new Node( 4 );
        root.right.right = new Node( 5 );
        root.right.left.left = new Node( 12 );
        root.right.left.right = new Node( 7 );
        root.left.right.left = new Node( 11 );
        root.left.left.right = new Node( 10 );

        return root;
    }
}
