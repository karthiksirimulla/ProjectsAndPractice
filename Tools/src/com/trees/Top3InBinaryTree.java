package com.trees;

import java.util.Arrays;
import java.util.Stack;

import com.node.TreeNode;

public class Top3InBinaryTree
{
    public static void main( String[] args )
    {
        int[] top3 = new int[3];
        TreeNode root = constructTree();
        Arrays.fill( top3, -1 );

        findTop3( root, top3 );

    }

    private static void findTop3( TreeNode root,
                                  int[] top3 )
    {
        top3[0] = root.data;
        top3[1] = root.left.data;
        top3[2] = root.right.data;

        Arrays.sort( top3 );
        System.out.println( Arrays.toString( top3 ) );

        Stack<TreeNode> stack = new Stack<>();
        stack.push( root );

        while( !stack.isEmpty() )
        {
            TreeNode temp = stack.pop();
            int data = temp.data;
            if( data != top3[2] && data != top3[1] && data != top3[0] )
            {
                if( data > top3[2] )
                {
                    top3[0] = top3[1];
                    top3[1] = top3[2];
                    top3[2] = temp.data;

                }
                else if( data > top3[1] )
                {
                    top3[0] = top3[1];
                    top3[1] = temp.data;

                }
                else if( data > top3[0] )
                {
                    top3[0] = temp.data;

                }
            }
            if( null != temp.right )
                stack.push( temp.right );
            if( null != temp.left )
                stack.push( temp.left );
            System.out.println( Arrays.toString( top3 ) );
        }

    }

    private static TreeNode constructTree()
    {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node4;
        node3.right = node5;

        return node1;

    }

}
