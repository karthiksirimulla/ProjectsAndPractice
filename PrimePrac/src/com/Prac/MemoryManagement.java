package com.Prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a list of id - memoryconsumed for frontEnd and BackEnd apis
 * Given available memory
 * Find the efficient use of the memory of front/Back end apis
 * 
 * result : print Ids
 * 
 * frontEnd : [1,3] [2,4] [3,9] [4,14]
 * BackEnd : [1,5] [2,6] [3,8] [4,12]
 * Memory : 18
 * result : [3,3] ;  [id of frontEndApi, id of backEndApi]
 * sum = frontEnd[3] + backEnd[3] = 17 ; This is efficient usage
 *
 */
public class MemoryManagement
{
    public static void main( String[] args )
    {
        List<List<Integer>> frontEndApis = new ArrayList<>();
        int[] frontEndMem = { 3, 4, 9, 14 };

        List<List<Integer>> backEndApis = new ArrayList<>();
        int[] backEndMem = { 5, 6, 8, 12 };

        buildList( frontEndApis, frontEndMem );
        buildList( backEndApis, backEndMem );

        int avalMem = 22;

        List<Integer> resList = findEfficientApis( frontEndApis, backEndApis, avalMem );
        System.out.println( resList.toString() );

    }

    private static List<Integer> findEfficientApis( List<List<Integer>> frontEndApis,
                                                    List<List<Integer>> backEndApis,
                                                    int avalMem )
    {
        List<Entry<Integer, Integer>> lFrontEntries = getEntries( frontEndApis );
        List<Entry<Integer, Integer>> lBackEntries = getEntries( backEndApis );

        // backEnd apis and fronEnd apis may not be in same number

        int iFront = 0;
        int iBack = 0;

        int frontRes = -1;
        int backRes = -1;

        List<Integer> resList = new ArrayList<>();

        while( iFront < lFrontEntries.size() - 1 && iBack < lBackEntries.size() - 1 )
        {
            if( lFrontEntries.get( iFront ).getValue() + lBackEntries.get( iBack ).getValue() <= avalMem )
            {
                frontRes = lFrontEntries.get( iFront ).getKey();
                backRes = lBackEntries.get( iBack ).getKey();
                break;

            }
            else
            {
                int iFrontPlusSum = lFrontEntries.get( iFront + 1 ).getValue() + lBackEntries.get( iBack ).getValue();
                int iBackPlusSum = lFrontEntries.get( iFront ).getValue() + lBackEntries.get( iBack + 1 ).getValue();

                if( iFrontPlusSum <= avalMem )
                {
                    frontRes = lFrontEntries.get( iFront + 1 ).getKey();
                    backRes = lBackEntries.get( iBack ).getKey();
                    break;
                }
                else if( iBackPlusSum <= avalMem )
                {
                    frontRes = lFrontEntries.get( iFront ).getKey();
                    backRes = lBackEntries.get( iBack + 1 ).getKey();
                    break;
                }
                else
                {
                    iFront++;
                    iBack++;
                }
            }
        }
        resList.add( frontRes );
        resList.add( backRes );

        return resList;

    }

    private static List<Entry<Integer, Integer>> getEntries( List<List<Integer>> apis )
    {
        Map<Integer, Integer> lMap = new HashMap<>();

        for( List<Integer> lList : apis )
        {
            lMap.put( lList.get( 0 ), lList.get( 1 ) );
        }

        List<Entry<Integer, Integer>> entries = new LinkedList<>( lMap.entrySet() );
        Collections.sort( entries, new Comparator<Entry<Integer, Integer>>()
        {

            @Override
            public int compare( Entry<Integer, Integer> o1,
                                Entry<Integer, Integer> o2 )
            {
                if( o1.getValue() < o2.getValue() )
                    return 1;
                return -1;
            }
        } );

        return entries;

    }

    private static void buildList( List<List<Integer>> apis,
                                   int[] mems )
    {
        for( int i = 0; i < mems.length; i++ )
        {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add( i + 1 );
            tmpList.add( mems[i] );
            apis.add( tmpList );

        }

    }

}
