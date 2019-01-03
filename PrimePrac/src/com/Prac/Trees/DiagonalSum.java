package com.Prac.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DiagonalSum
{
    public static void main( String[] args )
    {
        Node root = Node.getTree1();
        printAllPaths( root, new ArrayList<>() );
        //printPaths( root, new ArrayList<>() );

    }

    private static void printAllPaths( Node node,
                                       List<Integer> arrList )
    {

        if( node == null )
            return;
        arrList.add( node.data );
        if( node.left == null && node.right == null )
        {
            Stream.of( arrList ).forEach( x -> x.forEach( y -> System.out.print( y+", " ) ) );
        }
        else
        {
            printAllPaths( node.left, arrList );
            printAllPaths( node.right, arrList );

        }
        arrList.remove( arrList.size() - 1 );

    }

}
