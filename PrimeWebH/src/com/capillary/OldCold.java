package com.capillary;

public class OldCold
{
    public static void main( String[] args )
    {
        int[] arr = { 2, 4, 11, 7 };// { 9, 2, 10, 7, 11, 8, 11 };
        int low = 0;
        int high = 3;

        int res = getNoSteps( arr, low, high );
        System.out.println( "Res : " + res );

    }

    private static int getNoSteps( int[] arr,
                                   int low,
                                   int high )
    {
        int odds = 0;
        int even = 0;
        for( int i = low; i < high; i++ )
        {
            if( arr[i] % 2 == 0 )
            {
                even++;
            }
            else
            {
                odds++;
            }

        }

        if( odds == 0 )
        {
            return 0;
        }

        if( even > odds )
        {
            return 0;
        }
        else if( even == odds )
        {
            return 1;
        }
        else
        {
            return odds - even;
        }

    }

}
