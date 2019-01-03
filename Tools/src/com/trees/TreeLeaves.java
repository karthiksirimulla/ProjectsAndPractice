package com.trees;

import java.util.Stack;

import com.node.TreeNode;

public class TreeLeaves
{
    public static void main( String[] args )
    {
        TreeNode root = constructTree();

        preOrder( root );

        printLeaves( root );

        removeLeaves( root );

        preOrder( root );

    }

    private static void removeLeaves( TreeNode root )
    {
        Stack<TreeNode> stack = new Stack<>();
        stack.push( root );

        while( !stack.isEmpty() )
        {
            TreeNode temp = stack.pop();
            if( temp.left == null && temp.right == null )
            {
                temp = null;
                continue;
            }

            if( null != temp.right )
                stack.push( temp.right );
            if( null != temp.left )
                stack.push( temp.left );
        }
        System.out.println(  );

    }

    private static void printLeaves( TreeNode root )
    {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push( root );

        while( !stack.isEmpty() )
        {
            TreeNode temp = stack.pop();
            if( temp.left == null && temp.right == null )
            {
                System.out.print( temp.data + ", " );
                sum = sum + temp.data;
            }

            if( null != temp.right )
                stack.push( temp.right );
            if( null != temp.left )
                stack.push( temp.left );
        }

        System.out.println();
        System.out.println( "Sum : " + sum );

    }

    private static void preOrder( TreeNode root )
    {
        Stack<TreeNode> stack = new Stack<>();
        stack.push( root );

        while( !stack.isEmpty() )
        {
            TreeNode temp = stack.pop();
            System.out.print( temp.data + ", " );

            if( null != temp.right )
                stack.push( temp.right );
            if( null != temp.left )
                stack.push( temp.left );
        }
        System.out.println();
    }

    private static TreeNode constructTree()
    {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        TreeNode node6 = new TreeNode( 6 );
        TreeNode node7 = new TreeNode( 7 );
        TreeNode node8 = new TreeNode( 8 );
        TreeNode node9 = new TreeNode( 9 );
        TreeNode node10 = new TreeNode( 10 );

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node8;

        node5.left = node6;
        node5.right = node7;

        node8.left = node9;
        node8.right = node10;

        return node1;

    }

}
