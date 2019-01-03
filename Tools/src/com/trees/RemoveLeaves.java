package com.trees;

import com.node.TreeNode;
import com.tools.MyBST;

public class RemoveLeaves
{

    static void removeLeaves( TreeNode node )
    {
        if( node == null )
            return;

        if( node.left == null && node.right == null )
            node = null;

        if( node.left != null )
            removeLeaves( node.left );

        if( node.right != null )
            removeLeaves( node.right );

    }

    public static void main( String[] args )
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

        MyBST bst = new MyBST();
        bst.insert( node8 );
        bst.insert( node3 );
        bst.insert( node10 );
        bst.insert( node1 );
        bst.insert( node6 );
        bst.insert( node4 );
        bst.insert( node7 );
        bst.insert( node14 );
        bst.insert( node13 );
        bst.printInorder();
        removeLeaves( bst.root );
        bst.printInorder();

    }

}
