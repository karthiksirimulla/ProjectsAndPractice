package com.linkedLists;

public class MergePointOftwoLinkedLists
{
    public static void main( String[] args )
    {
        //2 - 3 - 5 - 7 - 9
        Node n2 = new Node( 2 );
        Node n3 = new Node( 3 );
        Node n5 = new Node( 5 );
        Node n7 = new Node( 7 );
        Node n9 = new Node( 9 );

        // 4 - 6 - 7 - 9 
        Node n4 = new Node( 4 );
        Node n6 = new Node( 6 );

        MyLinkedList l1 = new MyLinkedList();
        l1.insert( n2 );
        l1.insert( n3 );
        l1.insert( n5 );
        l1.insert( n7 );
        l1.insert( n9 );

        MyLinkedList l2 = new MyLinkedList();
        l2.insert( n4 );
        l2.insert( n6 );
        l2.insert( n7 );

        MyLinkedList.print( l1 );
        MyLinkedList.print( l2 );
        int res = getMergePoint( l1, l2 );
        System.out.println( "Merge Point :" + res );

        findIntersectionPoint( l1, l2 );

    }

    private static int getMergePoint( MyLinkedList l1,
                                      MyLinkedList l2 )
    {
        int len1 = l1.getLength();
        int len2 = l2.getLength();
        int diff = Math.abs( len1 - len2 );
        Node l1Head = l1.getHead();
        Node l2Head = l2.getHead();

        int result = 0;

        while( diff > 0 )
        {
            if( len1 > len2 )
            {
                l1Head = l1Head.next;
            }
            else
            {
                l2Head = l2Head.next;
            }
            diff--;
        }

        while( l1Head != null && l2Head != null )
        {
            if( l1Head.next.data == l2Head.next.data )
            {
                result = l1Head.next.data;
                break;
            }
            else
            {
                l1Head = l1Head.next;
                l2Head = l2Head.next;
            }

        }

        return result;

    }

    public static void findIntersectionPoint( MyLinkedList l1,
                                              MyLinkedList l2 )
    {
        int len1 = l1.getLength();
        int len2 = l2.getLength();

        int diff = Math.abs( len1 - len2 );

        while( diff > 0 )
        {
            if( len1 > len2 )
                l1.head = l1.head.next;
            else
                l2.head = l2.head.next;
            diff--;
        }

        while( l1.head != null && l2.head != null )
        {
            if( l1.head.data == l2.head.data )
            {
                System.out.println( "Intersection Point :" + l1.head.data );
                return;
            }

            l1.head = l1.head.next;
            l2.head = l2.head.next;

        }

    }

}
