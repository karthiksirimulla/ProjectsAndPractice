package com.creator;

import com.node.LLNode;

public class LLCreator
{
    public static LLNode create()
    {
        LLNode node1 = new LLNode( 1 );
        LLNode node2 = new LLNode( 2 );
        LLNode node3 = new LLNode( 3 );
        LLNode node4 = new LLNode( 4 );
        LLNode node5 = new LLNode( 5 );
        LLNode node6 = new LLNode( 6 );
        LLNode node7 = new LLNode( 7 );

        //4, 5, 2, 6, 1, 3, 7

        node4.next = node5;
        node5.next = node2;
        node2.next = node6;
        node6.next = node1;
        node1.next = node3;
        node3.next = node7;

        return node4;

    }

}
