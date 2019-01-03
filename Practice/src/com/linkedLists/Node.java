package com.linkedLists;

public class Node
{
    int data;
    Node next;

    public Node( int data )
    {
        this.data = data;
    }

    public Node( int data,
        Node n )
    {
        this.data = data;
        this.next = n;
    }

    public int getData()
    {
        return data;
    }

    public void setData( int data )
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext( Node node )
    {
        this.next = node;
    }

}
