package com.arrays;

public class SmallestSubArray
{
    // length of smallest sub-array greater than a given number
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 10, 3, 40, 18, 26 };
        int given = 71;

        int minLength = findMinLen( arr, given );
        System.out.println( minLength );

    }

    private static int findMinLen( int[] arr,
                                   int gvn )
    {
        int start = 0, end = 1;
        int currMin = 0;
        int tempSum = 0;
        int minIndex = 0;
        while( end < arr.length )
        {
            if( arr[start] > gvn || arr[end] > gvn )
                return 1;
            tempSum = getCurrSum( start, end, arr );
            if( tempSum > gvn )
            {
                currMin = end - start + 1;
                start++;
                tempSum = tempSum - arr[minIndex];
                minIndex++;
            }
            else
            {
                end++;
            }

        }
        return currMin;
    }

    private static int getCurrSum( int start,
                                   int end,
                                   int[] arr )
    {
        int sum = 0;
        while( start <= end )
        {
            sum = sum + arr[start];
            start++;
        }
        return sum;
    }

}
