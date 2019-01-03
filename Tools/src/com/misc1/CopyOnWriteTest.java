package com.misc1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Emp
{
    int id;
    String name;

    public Emp( int id,
        String name )
    {
        super();
        this.id = id;
        this.name = name;
    }

}

public class CopyOnWriteTest
{
    public static void main( String[] args )
    {
        List<Emp> lList = new ArrayList<>();

        for( int i = 0; i < 10; i++ )
        {
            lList.add( new Emp( i, "S" + i ) );
        }

        System.out.println( "Size: " + lList.size() );

        List<Emp> lCopyList = new CopyOnWriteArrayList<>();
        lCopyList.addAll( lList );

        for( Emp lObj : lCopyList )
        {
            if( lObj.id > 5 )
            {
                lCopyList.remove( lObj );
            }
        }

        System.out.println( "Copy Size: " + lCopyList.size() );

        System.out.println( "Final Size: " + lList.size() );

        removeFirst( lList );
        System.out.println( "Remove Size: " + lList.size() );

    }

    private static void removeFirst( List<Emp> lList )
    {
        lList.remove( 0 );

    }

}
