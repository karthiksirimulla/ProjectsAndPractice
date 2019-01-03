package com.trees;

import com.node.TreeNode;
import com.tools.MyBST;

public class Height
{
    public static void main( String[] args )
    {
        MyBST bst = new MyBST();
        bst.insert( new TreeNode( 3 ) );
        bst.insert( new TreeNode( 2 ) );
        bst.insert( new TreeNode( 1 ) );
        bst.insert( new TreeNode( 5 ) );
        bst.insert( new TreeNode( 4 ) );
        bst.insert( new TreeNode( 6 ) );
        bst.insert( new TreeNode( 7 ) );

        //  System.out.println( "height:" + MyBST.getHeight( MyBST.root ) );
        bst.getHeightItr();

    }

}
