package com.BT;

import com.node.TreeNode;

public class AddGreaterValues
{
    static int add = 0;

    public static void main( String[] args )
    {
        TreeNode root = getTree();
        Traversals.inOrder( root );
        /**
         *    260
           /      \
          330      150
         /   \     /  \
        350   300 210   80
        
         */
        System.out.println();
        Sum S = new Sum();
        modifyBSTUtil( root, S );
        Traversals.inOrder( root );

    }

    public static void postOrder( TreeNode node )
    {
        if( node == null )
            return;
        postOrder( node.right );
        node.data = node.data + ( node.right == null ? 0
            : node.right.data );
        postOrder( node.left );

    }

    // Recursive function to add all greater values in
    // every node
    static void modifyBSTUtil( TreeNode node,
                               Sum S )
    {
        // Base Case
        if( node == null )
            return;

        // Recur for right subtree    
        modifyBSTUtil( node.right, S );

        // Now *sum has sum of nodes in right subtree, add
        // root->data to sum and update root->data
        S.sum = S.sum + node.data;
        node.data = S.sum;

        // Recur for left subtree
        modifyBSTUtil( node.left, S );
    }

    public static TreeNode getTree()
    {
        /**
         *
         *
              50
           /      \
          30        70
        /   \      /  \
        20    40  60   80 
        
         */

        TreeNode node50 = new TreeNode( 50 );
        TreeNode node30 = new TreeNode( 30 );
        TreeNode node70 = new TreeNode( 70 );
        TreeNode node20 = new TreeNode( 20 );
        TreeNode node40 = new TreeNode( 40 );
        TreeNode node60 = new TreeNode( 60 );
        TreeNode node80 = new TreeNode( 80 );

        node50.left = node30;
        node50.right = node70;

        node30.left = node20;
        node30.right = node40;

        node70.left = node60;
        node70.right = node80;

        return node50;

    }

}

class Sum
{
    int sum = 0;
}
