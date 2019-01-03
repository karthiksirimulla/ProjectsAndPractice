package com.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tst
{

    public static void main( String[] args )
    {
        List<String> lList = new ArrayList<>();

        Set<String> lSet = new HashSet<>();
        lSet.add( "1" );
        lSet.add( "2" );
        lSet.add( "3" );
        lSet.add( "4" );
        lSet.add( "5" );

        lList.addAll( lSet );

        System.out.println( lList.size() );
    }

}
