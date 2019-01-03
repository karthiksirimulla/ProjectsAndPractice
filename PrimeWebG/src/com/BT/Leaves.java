package com.BT;

import java.util.Stack;

import com.node.TreeNode;

public class Leaves
{
    public static void main( String[] args )
    {
        TreeNode root = TreeNode.getTree();
        System.out.println( "--------- Print Leaves -----------" );
        printAllLeaves( root );
        System.out.println();
        System.out.println( "----- Right Leaves Sum ------------" );
        rightLeavesSum( root );
        System.out.println( "--------Range Print ----------------" );
        int k1 = 6;
        int k2 = 13;
        givenRangePrint( root, k1, k2 );
        System.out.println();
        System.out.println( "----- Non Leaf count ------------" );
        countNonLeaves( root );
        System.out.println();
        System.out.println( "----- Non Leaf count recursive ------------" );
        int sum = countNonLeavesRecursive( root, 0 );
        System.out.println( "Non-Leaf Recursive count  : " + sum );
    }

    private static void countNonLeaves( TreeNode node )
    {
        if( node == null )
            return;
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        while( node != null )
        {
            st.push( node );
            node = node.left;
        }

        while( !st.isEmpty() )
        {
            node = st.pop();
            if( node.right != null || node.left != null )
            {
                System.out.print( node.data + ", " );
                sum++;
            }
            if( node.right != null )
            {
                node = node.right;
                while( node != null )
                {
                    st.push( node );
                    node = node.left;
                }
            }

        }

        System.out.println( "Sum : " + sum );
    }

    private static int countNonLeavesRecursive( TreeNode node,
                                                int sum )
    {

        if( node == null )
            return 0;
        if( node.left == null || node.right == null )
        {
            System.out.print( node.data + ", " );
            sum++;
        }
        return countNonLeavesRecursive( node.left, sum ) + countNonLeavesRecursive( node.right, sum );

    }

    private static void givenRangePrint( TreeNode node,
                                         int k1,
                                         int k2 )
    {
        if( node == null )
            return;
        givenRangePrint( node.left, k1, k2 );
        if( node.data >= k1 && node.data <= k2 )
            System.out.print( node.data + ", " );
        givenRangePrint( node.right, k1, k2 );

    }

    private static void printAllLeaves( TreeNode node )
    {

        if( node == null )
            return;
        if( node.left == null && node.right == null )
            System.out.print( node.data + ", " );
        printAllLeaves( node.left );
        printAllLeaves( node.right );
    }

    private static void rightLeavesSum( TreeNode node )
    {
        if( node == null )
            return;
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        while( node != null )
        {
            st.push( node );
            node = node.left;
        }

        while( !st.isEmpty() )
        {
            node = st.pop();
            if( node.right != null && node.right.left == null && node.right.right == null )
                sum = sum + node.right.data;
            if( node.right != null )
            {
                node = node.right;
                while( node != null )
                {
                    st.push( node );
                    node = node.left;
                }
            }

        }

        System.out.println( "Sum : " + sum );
    }

}
