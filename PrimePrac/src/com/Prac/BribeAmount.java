package com.Prac;

import java.util.Arrays;

/*
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! 
 * There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. 
 * Initial positions increment by  from  at the front of the line to  at the back.
 * Any person in the queue can bribe the person directly in front of them to swap positions. 
 * If two people swap positions, they still wear the same sticker denoting their original places in line. 
 * One person can bribe at most two others. 
 * For example, if n=8 and Person 5 bribes Person 4, the queue will look like this: 1,2,3,5,4,6,7,8.
 * Complete the function minimumBribes in the editor below. 
 * It must print an integer representing the minimum number of bribes necessary, or Too chaotic 
 * if the line configuration is not possible.
 */

public class BribeAmount
{
    public static void main( String[] args )
    {
        int[] q = { 2, 1, 5, 3, 4 };//{ 1, 2, 5, 3, 7, 8, 6, 4 };
        int numberToCheck = q.length;
        int totalBribe = 0;
        boolean isChaotic = false;

        for( int i = q.length - 1; i > 0; i-- )
        {
            if( q[i] == numberToCheck )
            {
                numberToCheck--;
                continue;
            }

            int bribeAmt = calculateBribe( q, numberToCheck, i );
            System.out.println( Arrays.toString( q ) );

            if( bribeAmt == -1 )
            {
                System.out.println( "Too Chaotic" );
                isChaotic = true;
                break;
            }
            else
            {
                totalBribe = totalBribe + bribeAmt;
            }
            numberToCheck--;

        }
        if( !isChaotic )
            System.out.println( totalBribe );

    }

    private static int calculateBribe( int[] arr,
                                       int numberToCheck,
                                       int index )
    {
        int bribe = -1;
        int curr = -1;
        if( ( index - 2 ) >= 0 && arr[index - 2] == numberToCheck )
        {
            bribe = 2;
            curr = index - 2;

        }
        if( ( index - 1 ) >= 0 && arr[index - 1] == numberToCheck )
        {
            bribe = 1;
            curr = index - 1;
        }

        if( bribe != -1 )
        {
            int cnt = bribe;
            while( cnt > 0 )
            {
                arr[curr] = arr[curr + 1];
                cnt--;
                curr++;
            }

            arr[index] = numberToCheck;
        }

        return bribe;
    }

}
