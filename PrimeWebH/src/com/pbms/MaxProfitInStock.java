package com.pbms;

public class MaxProfitInStock
{
    public static void main( String[] args )
    {
        int[] arr = { 7, 2, 5, 1, 4, 6 };
        int res = maxProfit( arr );
        System.out.println( "Result :" + res );
        int resEff = maxProfitEff( arr );
        System.out.println( "Result Eff:" + resEff );
    }

    private static int maxProfit( int[] arr )
    {
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for( int i = 0; i < len; i++ )
        {
            int temp = arr[i];
            if( temp < min )
            {
                min = temp;
                minIndex = i;
            }
        }

        System.out.println( "Min : " + min + " at index : " + minIndex );

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for( int j = minIndex; j < len; j++ )
        {
            int temp = arr[j];
            if( temp > max )
            {
                max = temp;
                maxIndex = j;
            }
        }
        System.out.println( "Max : " + max + " at index : " + maxIndex );
        return max - min;
    }

    private static int maxProfitEff( int[] arr )
    {
        //{ 7, 2, 5, 1, 6, 4 };
        int lowestPriceTillThatDay = arr[0];
        int maxProfit = Integer.MIN_VALUE;
        for( int i = 0; i < arr.length; i++ )
        {
            int profit = 0;
            if( arr[i] > lowestPriceTillThatDay )
            {
                profit = arr[i] - lowestPriceTillThatDay;
                if( profit > maxProfit )
                {
                    maxProfit = profit;
                }
            }
            else
            {
                lowestPriceTillThatDay = arr[i];
            }
        }
        return maxProfit;
    }

}
