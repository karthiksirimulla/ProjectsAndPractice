package com.Prac.Trees;

/**
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * 
 * 1. Anti-clockwise
 * 2. Clockwise
 *
 */
public class BoundaryTreeTraversal
{
    public static void main( String[] args )
    {
        Node root = getTree();

        boundaryTraversalAntiClockwise( root );

    }

    private static void boundaryTraversalAntiClockwise( Node node )
    {
        System.out.print( node.data + ", " );
        printLeftBoundary( node.left );
        printLeaves( node );
        printRightBoundary( node.right );
    }

    private static void printLeftBoundary( Node node )
    {
        if( node == null )
            return;
        if( node.left != null & node.right != null )
            System.out.print( node.data + ", " );
        printLeftBoundary( node.left );

    }

    private static void printLeaves( Node node )
    {
        if( node == null )
            return;
        printLeaves( node.left );
        if( node.left == null && node.right == null )
            System.out.print( node.data + ", " );
        printLeaves( node.right );

    }

    private static void printRightBoundary( Node node )
    {
        if( node == null )
            return;
        printRightBoundary( node.right );
        if( node.left != null & node.right != null )
            System.out.print( node.data + ", " );

    }

    public static Node getTree()
    {

        /**
         *        20
         *    4       22
         *  8   12  13    25
         *    10   14  
         */

        Node node20 = new Node( 20 );
        Node node4 = new Node( 4 );
        Node node8 = new Node( 8 );
        Node node22 = new Node( 22 );
        Node node12 = new Node( 12 );
        Node node25 = new Node( 25 );
        Node node10 = new Node( 10 );
        Node node14 = new Node( 14 );
        Node node13 = new Node( 13 );

        node20.left = node4;
        node20.right = node22;

        node4.left = node8;
        node4.right = node12;

        //  node22.left = node13;
        node22.right = node25;

        node12.left = node10;
        node12.right = node14;

        return node20;

    }

}
