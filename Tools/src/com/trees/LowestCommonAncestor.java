package com.trees;

import java.util.ArrayList;
import java.util.List;

import com.node.TreeNode;
import com.tools.MyBST;

public class LowestCommonAncestor
{
    public static void main( String[] args )
    {
        TreeNode root = constructTree();
        TreeNode bsRoot = constructBinarySearchTree();
        int n1 = 9;
        int n2 = 8;
        findLCA( root, n1, n2 );

        int bn1 = 1;
        int bn2 = 7;
        TreeNode res = findLCAinBST( bsRoot, bn1, bn2 );

        System.out.println( "bst -->" + res.data );
    }

    private static TreeNode findLCAinBST( TreeNode bsRoot,
                                        int bn1,
                                        int bn2 )
    {
        if( bsRoot == null )
            return null;

        if( ( bn1 > bsRoot.data && bn2 < bsRoot.data ) || ( bn1 < bsRoot.data && bn2 > bsRoot.data ) )
            return bsRoot;

        if( bsRoot.data > bn1 && bsRoot.data > bn2 )
            return findLCAinBST( bsRoot.left, bn1, bn2 );
        else
            return findLCAinBST( bsRoot.right, bn1, bn2 );

    }

    private static void findLCA( TreeNode root,
                                 int n1,
                                 int n2 )
    {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();

        findPath( s1, n1, root );
        findPath( s2, n2, root );

        int i = 0;
        while( s1.get( i ) == s2.get( i ) )
        {
            i++;
        }

        System.out.println( "res : " + s1.get( i - 1 ) );

    }

    private static boolean findPath( List<Integer> s,
                                     int n,
                                     TreeNode node )
    {
        if( node == null )
            return false;

        s.add( node.data );

        if( node.data == n )
            return true;

        if( node.left != null && findPath( s, n, node.left ) )
        {
            return true;
        }

        if( node.right != null && findPath( s, n, node.right ) )
        {
            return true;
        }

        s.remove( s.size() - 1 );
        return false;
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

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.right = node8;
        node4.left = node9;

        return node1;

    }

    private static TreeNode constructBinarySearchTree()
    {

        /**
         *       8
         *    3     10
         *  1   6      14
         *    4   7  13
         */

        MyBST bst = new MyBST();

        TreeNode node8 = new TreeNode( 8 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node10 = new TreeNode( 10 );
        TreeNode node1 = new TreeNode( 1 );
        TreeNode node6 = new TreeNode( 6 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node7 = new TreeNode( 7 );
        TreeNode node14 = new TreeNode( 14 );
        TreeNode node13 = new TreeNode( 13 );

        bst.insert( node8 );
        bst.insert( node3 );
        bst.insert( node10 );
        bst.insert( node1 );
        bst.insert( node6 );
        bst.insert( node4 );
        bst.insert( node7 );
        bst.insert( node14 );
        bst.insert( node13 );

        return bst.root;

    }

}
