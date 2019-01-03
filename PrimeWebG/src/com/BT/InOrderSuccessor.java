package com.BT;

import java.util.Stack;

import com.node.TreeNode;

public class InOrderSuccessor
{
    public static void main( String[] args )
    {
        TreeNode root = TreeNode.getTree();
        int data = 10;
        System.out.println( "1, 3, 4, 6, 7, 8, 9, 10, 13, 14 " );
        inSuccessor( root, data );

    }

    private static void inSuccessor( TreeNode node,
                                     int data )
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
            int temp = node.data;
            if( node.right != null )
            {
                node = node.right;
                while( node != null )
                {
                    st.push( node );
                    node = node.left;
                }
            }
            if( temp == data )
            {
                System.out.print( st.peek().data + ", " );
            }

        }

    }

}
