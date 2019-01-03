package com.DyP;

public class ChildStairCase
{
    /**
     * 
     *  A child is running up a staircase with n steps and can hop either 1 step, 2 step or 3 steps at a time.
     *  Implement a method to count how many possible ways the child can run to the stairs.
     */
    public static void main( String[] args )
    {
        int steps = 5;
        int ways = countWays( steps );
        System.out.println( "No of Ways : " + ways );

    }

    private static int countWays( int n )
    {
        if( n < 0 )
            return 0;
        else if( n == 0 )
            return 1;
        else
            return countWays( n - 1 ) + countWays( n - 2 ) + countWays( n - 3 );
    }

}
