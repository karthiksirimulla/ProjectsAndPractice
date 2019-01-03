package com.Prac.Trees;

public class Mirroring
{
    public static void main( String[] args )
    {
        Node rNode = Node.getGeeksTree();
        mirrorTree( rNode );
        Node rcNode = Node.getGeeksTree();

        boolean op = checkIfMirrors( rNode, rcNode );
        System.out.println( "Are Mirrors : " + op );

    }

    private static boolean checkIfMirrors( Node n,
                                           Node m )
    {
        if( n == null && m == null )
            return true;
        if( n == null || m == null )
            return false;
        return n.data == m.data && checkIfMirrors( n.left, m.right ) && checkIfMirrors( n.right, m.left );

    }

    private static void mirrorTree( Node node )
    {
        if( node.left == null && node.right == null )
            return;

        mirrorTree( node.left );
        mirrorTree( node.right );

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

    }

}
