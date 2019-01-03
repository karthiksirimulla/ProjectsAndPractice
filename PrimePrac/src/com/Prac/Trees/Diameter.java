package com.Prac.Trees;

public class Diameter
{
    public static void main( String[] args )
    {
        Node rNode = GiveTree.getTree();
        int diameter = diameterCalc( rNode );
        System.out.println( "Diameter : " + diameter );
    }

    private static int diameterCalc( Node root )
    {
        return 1 + heightCalc( root.left ) + heightCalc( root.right );
    }

    static int heightCalc( Node node )
    {
        if( node == null )
            return 0;

        int heightL = heightCalc( node.left );
        int heightR = heightCalc( node.right );

        return 1 + Integer.max( heightL, heightR );

    }

}
