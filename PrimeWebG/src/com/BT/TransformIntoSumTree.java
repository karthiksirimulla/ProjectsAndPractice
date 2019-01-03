package com.BT;

import java.util.Stack;

import com.node.TreeNode;

public class TransformIntoSumTree
{
    public static void main( String[] args )
    {
        TreeNode root = getTestCaseTree();
        Traversals.inOrder( root );
        System.out.println();
        //transformTree( root );
        int sum = getTreeSum( root );
        System.out.println( "Sum : " + sum );
        transformTree( root, sum );
        System.out.println();
        transformTreeReverseInOrder( root );

    }

    private static void transformTree( TreeNode node,
                                       int sum )
    {
        if( node == null )
            return;
        Stack<TreeNode> st = new Stack<>();
        while( node != null )
        {
            st.push( node );
            node = node.left;
        }

        while( !st.isEmpty() )
        {
            node = st.pop();
            node.data = sum - node.data;
            sum = node.data;
            System.out.print( node.data + ", " );
            node = node.right;
            if( node != null )
            {
                while( node != null )
                {
                    st.push( node );
                    node = node.left;
                }
            }
        }
    }

    private static void transformTreeReverseInOrder( TreeNode node )
    {
        if( node == null )
            return;
        Stack<TreeNode> st = new Stack<>();
        int sum = 0;
        while( node != null )
        {
            st.push( node );
            node = node.right;
        }
        while( !st.isEmpty() )
        {
            node = st.pop();
            node.data = sum;
            System.out.print( node.data + ", " );
            node = node.left;
            if( node != null )
            {
                while( node != null )
                {
                    st.push( node );
                    node = node.right;
                }
            }
        }
    }

    private static int getTreeSum( TreeNode node )
    {
        if( node == null )
            return 0;
        return node.data + getTreeSum( node.left ) + getTreeSum( node.right );

    }

    private static TreeNode getTestCaseTree()
    {

        /**
         *       11
         *    2      29
         *  1   7 15    40
         *            35
         */

        TreeNode node11 = new TreeNode( 11 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node1 = new TreeNode( 1 );
        TreeNode node7 = new TreeNode( 7 );
        TreeNode node29 = new TreeNode( 29 );
        TreeNode node15 = new TreeNode( 15 );
        TreeNode node40 = new TreeNode( 40 );
        TreeNode node35 = new TreeNode( 35 );

        node11.left = node2;
        node11.right = node29;

        node2.left = node1;
        node2.right = node7;

        node29.left = node15;
        node29.right = node40;

        node40.left = node35;

        return node11;
    }

}
