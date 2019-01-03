package com.BT;

import java.util.Stack;

import com.node.TreeNode;

public class PairWithGivenSum
{
    /**
     * Method 1 : Brute Force
     *      Store sorted elements in an array and check for pair-sum (code not written)
     *      
     * Method 2: Space and time optimized
     *       traverse the tree Inorder and Reverse Inorder. sum the elements
     *       if(sum == targetSum) return true;
     *       else if(sum>targetSum) move back in reverse inorder
     *       else if(sum<targetSum) move forth in inorder
     * @param args
     */
    public static void main( String[] args )
    {
        TreeNode root = TreeNode.getTree();
        int sum = 23;
        inOrder( root );
        reverseInOrder( root );

        pairSum( root, sum );
    }

    private static void pairSum( TreeNode node,
                                 int sum )
    {
        if( node == null )
            return;
        System.out.println( "----------- Pair Sum -------------" );
        int targetSum = sum;

        Stack<TreeNode> ioStack = new Stack<>();
        Stack<TreeNode> rioStack = new Stack<>();

        TreeNode ioNode = node;
        TreeNode riNode = node;

        while( ioNode != null )
        {
            ioStack.push( ioNode );
            ioNode = ioNode.left;
        }

        while( riNode != null )
        {
            rioStack.push( riNode );
            riNode = riNode.right;
        }

        int ioVal = ioStack.peek().data;
        int riVal = rioStack.peek().data;

        while( true )
        {
            if( ioStack.isEmpty() || rioStack.isEmpty() )
                break;

            if( targetSum == ( ioVal + riVal ) )
            {
                System.out.println( "Pair Sum exists : (" + ioVal + " , " + riVal + " )" );
                break;
            }
            else if( targetSum < ( ioVal + riVal ) )
            {
                riNode = rioStack.pop();
                System.out.print( riNode.data + ", " );
                riVal = riNode.data;
                if( riNode.left != null )
                {
                    riNode = riNode.left;
                    while( riNode != null )
                    {
                        rioStack.push( riNode );
                        riNode = riNode.right;
                    }
                }
            }
            else
            {
                ioNode = ioStack.pop();
                System.out.print( ioNode.data + ", " );
                ioVal = ioNode.data;
                if( ioNode.right != null )
                {
                    ioNode = ioNode.right;
                    while( ioNode != null )
                    {
                        ioStack.push( ioNode );
                        ioNode = ioNode.left;
                    }
                }
            }

        }

    }

    private static void inOrder( TreeNode node )
    {
        if( node == null )
            return;
        Stack<TreeNode> s = new Stack<>();
        System.out.println( "----------- InOrder Traversal -------------" );
        while( node != null )
        {
            s.push( node );
            node = node.left;
        }

        while( !s.isEmpty() )
        {
            node = s.pop();
            System.out.print( node.data + ", " );
            if( node.right != null )
            {
                node = node.right;
                while( node != null )
                {
                    s.push( node );
                    node = node.left;

                }
            }
        }
        System.out.println();
    }

    private static void reverseInOrder( TreeNode node )
    {
        if( node == null )
            return;
        Stack<TreeNode> s = new Stack<>();
        System.out.println( "----------- Reverse InOrder Traversal -------------" );
        while( node != null )
        {
            s.push( node );
            node = node.right;
        }

        while( !s.isEmpty() )
        {
            node = s.pop();
            System.out.print( node.data + ", " );
            if( node.left != null )
            {
                node = node.left;
                while( node != null )
                {
                    s.push( node );
                    node = node.right;

                }
            }
        }
        System.out.println();
    }

}
