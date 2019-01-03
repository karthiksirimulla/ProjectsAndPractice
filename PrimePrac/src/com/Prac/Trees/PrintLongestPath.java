package com.Prac.Trees;

public class PrintLongestPath
{
    public static void main( String[] args )
    {
        Node root = GiveTree.getTree();
        longestPathPrinter( root );

    }

    private static int longestPathPrinter( Node node )
    {
        if( node == null )
            return 0;

        int leftHeight = longestPathPrinter( node.left );
        int rightHeight = longestPathPrinter( node.right );

        if( leftHeight == rightHeight )
            System.out.print( node.data + "," );
        return 1 + Integer.max( leftHeight, rightHeight );
    }

}
