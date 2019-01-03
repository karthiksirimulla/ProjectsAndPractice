package com.node;

public class TreeNode implements Comparable<TreeNode>
{

    public int data;
    public TreeNode left;
    public TreeNode right;
    public int hd;

    public TreeNode( int data )
    {
        this.data = data;
    }

    @Override
    public int compareTo( TreeNode o )
    {
        return this.data - o.data;
    }

}
