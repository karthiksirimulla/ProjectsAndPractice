package com.Prac.Trees;

public class ConstructTreeFromInPos
{
    static int posIndex = 0;

    public static void main( String[] args )
    {
        /**
         * Output : Root of below tree
                          1
                       /     \
                     2        3
                   /    \   /   \
                  4     5   6    7
                    \
                      8
         *
         */
        int[] in = { 4, 8, 2, 5, 1, 6, 3, 7 }; // LDR
        int[] pos = { 8, 4, 5, 2, 6, 7, 3, 1 }; // LRD

        Node posroot = buildTreeFromInPos( in, pos, 0, in.length - 1 );

        printInorder( posroot );

    }

    private static Node buildTreeFromInPos( int[] in,
                                            int[] pos,
                                            int inStr,
                                            int inEnd )
    {

        if( inStr > inEnd )
            return null;

        Node tNode = new Node( pos[in.length - 1 - ( posIndex++ )] );
        if( inStr == inEnd )
            return tNode;

        int iIndex = search( in, inStr, inEnd, tNode.data );

        tNode.right = buildTreeFromInPos( in, pos, iIndex + 1, inEnd );
        tNode.left = buildTreeFromInPos( in, pos, inStr, iIndex - 1 );

        return tNode;

    }

    private static int search( int[] in,
                               int inStr,
                               int inEnd,
                               int data )
    {
        for( int i = inStr; i <= inEnd; i++ )
        {
            if( in[i] == data )
                return i;
        }
        return inStr;
    }

    private static void printInorder( Node node )
    {
        if( node == null )
            return;
        printInorder( node.left );
        System.out.print( node.data + " " );
        printInorder( node.right );

    }

}
