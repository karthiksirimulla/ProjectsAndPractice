package com.Prac.Trees;

public class HeightOfTree
{

    public static void main( String[] args )
    {
        Node rNode = getTree();
        int height = getHeight( rNode, 0 );
        System.out.println( "height : " + height );

    }

    private static int getHeight( Node node )
    {
        if( node == null )
            return 0;

        int leftHeight = getHeight( node.left );
        int rightHeight = getHeight( node.right );

        System.out.println( "leftHeight : " + leftHeight );
        System.out.println( "rightHeight : " + rightHeight );
        System.out.println( " ---------------------------------" );

        return 1 + Integer.max( leftHeight, rightHeight );

    }

    private static int getHeight( Node node,
                                  int counter )
    {
        if( node == null )
            return 0;
        if( node != null )
            System.out.print( node.data + ", " );

        int leftHeight = getHeight( node.left, counter + 1 );
        int rightHeight = getHeight( node.right, counter + 1 );

        /* System.out.println( "leftHeight : " + leftHeight );
        System.out.println( "rightHeight : " + rightHeight );
        System.out.println( " ---------------------------------" );
        System.out.println( " ----> " + counter );*/
        return 1 + Integer.max( leftHeight, rightHeight );

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
