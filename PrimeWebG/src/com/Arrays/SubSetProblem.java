package com.Arrays;

public class SubSetProblem
{
    public static void main( String[] args )
    {
        int[] arr = { 0, 1, 3, 9, 2 };
        int n = arr.length;
        int sum = 12;
        boolean res = subsetSum( arr, sum );
        System.out.println( "Result :" + res );
        res = isSubsetSum( arr, n, sum );
        System.out.println( "Result :" + res );
    }

    static boolean isSubsetSum( int arr[],
                                int n,
                                int sum )
    {
        // Base Cases 
        if( sum == 0 )
            return true;
        if( n == 0 && sum != 0 )
            return false;

        // If last element is greater than  
        // sum, then ignore it 
        if( arr[n - 1] > sum )
            return isSubsetSum( arr, n - 1, sum );

        /* else, check if sum can be obtained 
         * by any of the following 
                excluding the last element    ||     including the last element */
        return isSubsetSum( arr, n - 1, sum ) || isSubsetSum( arr, n - 1, sum - arr[n - 1] );
    }

    private static boolean subsetSum( int[] input,
                                      int target )
    {
        boolean[][] dpTable = new boolean[input.length + 1][target + 1];
        //rows,cols

        // filling row 0, all cols
        for( int i = 1; i <= target; i++ )
        {
            dpTable[0][i] = false;
        }

        // filling col 0, all rows
        for( int i = 0; i <= input.length; i++ )
        {
            dpTable[i][0] = true;
        }

        for( int i = 1; i <= input.length; i++ )
        {
            for( int j = 1; j <= target; j++ )
            {
                //first copy data from the top
                dpTable[i][j] = dpTable[i - 1][j];

                // if dpTable[i][j] == false check if can be made
                if( dpTable[i][j] == false && j >= input[i - 1] )
                    dpTable[i][j] = dpTable[i][j] || dpTable[i - 1][j - input[i - 1]];
            }
        }

        return dpTable[input.length][target];
    }

}
