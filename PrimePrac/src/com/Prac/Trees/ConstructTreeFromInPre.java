package com.Prac.Trees;

public class ConstructTreeFromInPre
{
    Node root;
    static int preIndex = 0;

    /* Recursive function to construct binary of size len from 
    Inorder traversal in[] and Preorder traversal pre[]. 
    Initial values of inStrt and inEnd should be 0 and len -1. 
    The function doesn't do any error checking for cases where 
    inorder and preorder do not form a tree */
    static Node buildTreeWithPreOrder( int[] in,
                                       int[] pre,
                                       int inStrt,
                                       int inEnd )
    {
        if( inStrt > inEnd )
            return null;

        /* Pick current node from Preorder traversal using preIndex 
        and increment preIndex */
        Node tNode = new Node( pre[preIndex++] );

        /* If this node has no children then return */
        if( inStrt == inEnd )
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search( in, inStrt, inEnd, tNode.data );

        /* Using index in Inorder traversal, construct left and 
        right subtress */
        tNode.left = buildTreeWithPreOrder( in, pre, inStrt, inIndex - 1 );
        tNode.right = buildTreeWithPreOrder( in, pre, inIndex + 1, inEnd );

        return tNode;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of value in arr[start...end] 
    The function assumes that value is present in in[] */
    static int search( int[] in,
                       int strt,
                       int end,
                       int data )
    {
        int i;
        for( i = strt; i <= end; i++ )
        {
            if( in[i] == data )
                return i;
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    static void printInorder( Node node )
    {
        if( node == null )
            return;

        /* first recur on left child */
        printInorder( node.left );

        /* then print the data of node */
        System.out.print( node.data + " " );

        /* now recur on right child */
        printInorder( node.right );
    }

    // driver program to test above functions 
    public static void main( String args[] )
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
        int[] pre = { 1, 2, 4, 8, 5, 3, 6, 7 }; // DLR
        int[] pos = { 8, 4, 5, 2, 6, 7, 3, 1 }; // LRD
        int len = in.length;

        Node preroot = buildTreeWithPreOrder( in, pre, 0, len - 1 );

        // building the tree by printing inorder traversal 
        System.out.println( "Inorder traversal of constructed tree is : " );
        printInorder( preroot );
    }

}
