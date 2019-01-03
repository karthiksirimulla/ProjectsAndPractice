package com.tools;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.node.TreeNode;

public class MyBST
{
    public static TreeNode root;

    public void insert( TreeNode node )
    {
        if( root == null )
        {
            root = node;
            return;
        }
        TreeNode temp = root;
        TreeNode parent = root;
        while( true )
        {
            parent = temp;
            if( node.data > temp.data )
            {
                temp = temp.right;
            }
            else
            {
                temp = temp.left;
            }

            if( temp == null )
            {
                if( node.data > parent.data )
                {
                    parent.right = node;

                }
                else
                {
                    parent.left = node;
                }
                break;

            }
        }
    }

    public void insertComparable( TreeNode node )
    {
        if( root == null )
        {
            root = node;
            return;
        }
        TreeNode temp = root;
        TreeNode parent = root;
        while( true )
        {
            parent = temp;
            if( node.compareTo( temp ) > 0 )
                temp = temp.right;
            else
                temp = temp.left;

            if( temp == null )
            {
                if( node.compareTo( parent ) > 0 )
                    parent.right = node;
                else
                    parent.left = node;
                break;
            }
        }
    }

    public void insertRec( TreeNode node,
                           TreeNode insertnode )
    {
        if( root == null )
        {
            root = insertnode;
            return;
        }

        if( node == null )
        {

        }

        if( root.compareTo( insertnode ) < 0 )
        {
            node = root.right;
            insertRec( node, insertnode );
        }
        else
        {
            node = root.left;
            insertRec( node, insertnode );
        }

    }

    public void printInorder()
    {
        TreeNode node = root;
        Stack<TreeNode> s = new Stack<>();
        while( node != null )
        {
            s.push( node );
            node = node.left;
        }

        while( !s.isEmpty() )
        {
            node = s.pop();
            System.out.print( node.data + "," );
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
    }

    public static int getHeight( TreeNode node )
    {
        if( node == null )
            return -1;
        return Math.max( getHeight( node.left ), getHeight( node.right ) ) + 1;

    }

    public static void getHeightItr()
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add( root );
        int heightL = 0;
        int heightR = 0;
        while( !queue.isEmpty() )
        {
            TreeNode nd = queue.poll();
            System.out.print( nd.data + "," );
            if( null != nd.left )
            {
                queue.add( nd.left );
                heightL++;
            }
            if( null != nd.right )
            {
                queue.add( nd.right );
                heightR++;
            }

        }

        System.out.println( "heightL :" + heightL );
        System.out.println( "heightR :" + heightR );

    }

    public static void main( String[] args )
    {
        // creating nodes
        TreeNode n15 = new TreeNode( 15 );
        TreeNode n10 = new TreeNode( 10 );
        TreeNode n8 = new TreeNode( 8 );
        TreeNode n12 = new TreeNode( 12 );
        TreeNode n20 = new TreeNode( 20 );
        TreeNode n17 = new TreeNode( 17 );
        TreeNode n25 = new TreeNode( 25 );

        MyBST btree = new MyBST();
        btree.insert( n15 );
        btree.insert( n10 );
        btree.insert( n8 );
        btree.insert( n12 );
        btree.insert( n20 );
        btree.insert( n17 );
        btree.insert( n25 );

        btree.printInorder();
    }
}
