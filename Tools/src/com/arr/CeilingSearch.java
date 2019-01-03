package com.arr;

public class CeilingSearch
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 1, 3, 3, 5, 5, 5, 5, 5, 9, 9, 11 };
        int ceilOf = 2;

        int ceil = ceilSearch( arr, 0, arr.length - 1, ceilOf );

        System.out.println( "Ceil : " + ceil );
    }

    static int ceilSearch( int arr[],
                           int low,
                           int high,
                           int x )
    {
        int mid;

        /* If x is smaller than or equal to the 
         first element, then return the first element */
        if( x < arr[low] )
            return arr[low];

        /* If x is greater than the last 
         element, then return -1 */
        if( x > arr[high] )
            return -1;

        /* get the index of middle element 
         of arr[low..high]*/
        mid = ( low + high ) / 2; /* low + (high - low)/2 */

        /* If x is same as middle element, 
         then return mid */
        if( arr[mid] == x )
        {
            while( mid <= high )
            {
                if( arr[mid] > x )
                {
                    break;
                }
                mid++;
            }
            if( mid > high )
                return -1;
            return arr[mid];

        }

        /* If x is greater than arr[mid], then 
         either arr[mid + 1] is ceiling of x or 
         ceiling lies in arr[mid+1...high] */
        else if( arr[mid] < x )
        {
            if( mid + 1 < high && x < arr[mid + 1] )
                return arr[mid + 1];
            else
                return ceilSearch( arr, mid + 1, high, x );
        }

        /* If x is smaller than arr[mid], 
         then either arr[mid] is ceiling of x 
         or ceiling lies in arr[mid-1...high] */
        else
        {
            if( mid - 1 > low && x > arr[mid - 1] )
                return arr[mid];
            else
                return ceilSearch( arr, low, mid - 1, x );
        }
    }

    private static int search( int[] arr,
                               int k )
    {
        int low = 0;
        int high = arr.length - 1;
        while( low <= high )
        {
            int mid = ( low + high ) / 2;

            if( arr[mid] == k )
            {
                return mid;
            }

            if( arr[mid] > k )
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }

        }

        return -1;

    }

}
