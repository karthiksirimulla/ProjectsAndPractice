package com.DP;

/**
 * https://www.geeksforgeeks.org/wp-content/uploads/dp2.png
 */

public class MinCost
{

    public static void main( String[] args )
    {
        int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
        /*
         *    {1, 2, 3},
              {4, 8, 2},
              {1, 5, 3} 
         */

        int op = findMinCostPath( cost );
        System.out.println( "Output : " + op );
    }

    private static int findMinCostPath( int[][] cost )
    {
        int rows = cost.length;
        int cols = cost[0].length;
        int i = 0, j = 0;

        int mincost = cost[i][j];

        while( i + 1 < rows && j + 1 < cols )
        {
            /*
             * {1, 2, 3},
               {4, 8, 2},
               {1, 5, 3} 
             */

            if( cost[i][j + 1] < cost[i + 1][j] && cost[i][j + 1] < cost[i + 1][j + 1] )
            {
                mincost = mincost + cost[i][j + 1];
                j = j + 1;
            }
            else if( cost[i + 1][j] < cost[i][j + 1] && cost[i + 1][j] < cost[i + 1][j + 1] )
            {
                mincost = mincost + cost[i + 1][j];
                i = i + 1;
            }
            else
            {
                mincost = mincost + cost[i + 1][j + 1];
                i++;
                j++;
            }

        }

        while( i + 1 < rows )
        {
            mincost = mincost + cost[i + 1][j];
            i++;
        }

        while( j + 1 < cols )
        {
            mincost = mincost + cost[i][j + 1];
            j++;
        }

        return mincost;
    }

}
