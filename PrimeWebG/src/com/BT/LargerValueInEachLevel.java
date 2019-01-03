package com.BT;

import java.util.LinkedList;
import java.util.Queue;

import com.node.TreeNode;

public class LargerValueInEachLevel
{
    public static void main( String[] args )
    {
        TreeNode root = TreeNode.getTree();
        printLargeValues( root );
    }

    private static void printLargeValues( TreeNode node )
    {
        if( node == null )
            return;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> p = new LinkedList<>();
        q.add( node );
        int max = Integer.MIN_VALUE;
        while( true )
        {
            if( q.isEmpty() && p.isEmpty() )
                break;
            max = Integer.MIN_VALUE;
            while( !q.isEmpty() )
            {
                TreeNode temp = q.poll();
                if( temp.data > max )
                    max = temp.data;
                if( temp.left != null )
                    p.add( temp.left );
                if( temp.right != null )
                    p.add( temp.right );
            }
            System.out.print( max + ", " );

            max = Integer.MIN_VALUE;

            while( !p.isEmpty() )
            {
                TreeNode temp = p.poll();
                if( temp.data > max )
                    max = temp.data;
                if( temp.left != null )
                    q.add( temp.left );
                if( temp.right != null )
                    q.add( temp.right );

            }
            System.out.print( max + ", " );

        }

    }

}
