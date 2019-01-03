package com.arr;

import java.io.IOException;

public class solution
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        /*BufferedReader inp = new BufferedReader( new InputStreamReader( System.in ) );
        int T = Integer.parseInt( inp.readLine() );
        
        for( int i = 0; i < T; i++ )
        {
        
            String arrSizeCost = inp.readLine();
            String[] arrSizeCostArray = arrSizeCost.split( " " );
        
            int arrSize = Integer.parseInt( arrSizeCostArray[0] );
            int cost = Integer.parseInt( arrSizeCostArray[1] );
        
            String plots = inp.readLine();
            String[] plotsArr = plots.split( " " );
        
            int[] arr = new int[arrSize];
            for( int j = 0; j < arrSize; j++ )
            {
                arr[j] = Integer.parseInt( plotsArr[j] );
            }
            System.out.println( maxProfit( arr, cost ) );
        
        }*/

        int arr[] = { 9, 2, 4, 1, 4, 3, 8, 2, 2, 4, 5, 7, };

        StringBuilder str = new StringBuilder();
        int j = 0;
        while( j < arr.length )
        {
            str.append( arr[j] );
            j++;
        }

        System.out.println( str.toString() );
        int c = 4;
        getProfit( arr, c );
        maxProfit( arr, c );

    }

    static void getProfit( int[] arr,
                           int c )
    {

        int profit = 0;
        int tempProfit = 0;

        for( int i = 0; i < arr.length; i++ )
        {
            if( c - arr[i] >= 0 )
            {
                tempProfit = tempProfit + ( c - arr[i] );
                if( tempProfit > profit )
                    profit = tempProfit;
            }
            else
            {
                tempProfit = 0;
            }
        }

        System.out.println( "Max Profit : " + profit );

    }

    static int maxProfit( int a[],
                          int p )
    {
        int size = a.length;
        int max_profit = 0, temp_prof = 0;

        if( size == 0 )
            return max_profit;

        for( int i = 0; i < size; i++ )
        {
            temp_prof = temp_prof + ( p - a[i] );
            if( max_profit < temp_prof )
                max_profit = temp_prof;
            if( temp_prof < 0 )
                temp_prof = 0;
        }
        System.out.println( max_profit );
        return max_profit;
    }

}
