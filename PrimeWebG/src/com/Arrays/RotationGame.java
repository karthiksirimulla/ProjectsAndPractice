package com.Arrays;

import java.util.Arrays;

/*
 * https://drive.google.com/open?id=1LfHYYCGHeCah506_PwNAEx3lGVHjgttE
 */
public class RotationGame
{
    public static void main( String[] args )
    {
        int[] workArr = { 1, 2, 3 };//{ 1, 2, 4, 3 };
        int[] rotArr = { 1, 2, 3, 4 };//{ 1, 3 };

        // [1,2,3] - 1 = [2,1,3] maxIndex = 2, moves = 1 ; res = 1 ; 
        // [1,2,3] - 2 = [3,1,2] maxIndex = 2, moves = 2 ; res = 0 ;
        // [1,2,3] - 3 = [1,2,3] maxIndex = 2, moves = 3 ; res = -1 ; 
        // 
        int[] op = playRotationGame( workArr, rotArr );
        System.out.println( Arrays.toString( op ) );

    }

    private static int[] playRotationGame( int[] workArr,
                                           int[] rotArr )
    {
        int[] op = new int[rotArr.length];

        int maxIndex = findMaxIndex( workArr );

        System.out.println( "MaxIndex : " + maxIndex );

        for( int i = 0; i < rotArr.length; i++ )
        {
            int move = rotArr[i];
            op[i] = getMaxEleIndex( move, workArr.length, maxIndex );
        }

        return op;
    }

    private static int getMaxEleIndex( int move,
                                       int arrLen,
                                       int maxIndex )
    {
        if( maxIndex - move >= 0 )
        {
            return maxIndex - move;
        }

        if( move == arrLen )
        {
            return maxIndex;
        }

        if( move > arrLen )
        {
            move = move % arrLen;
            return getMaxEleIndex( move, arrLen, maxIndex );
        }
        else
        // if( move < arrLen )
        {
            int remainingMoves = move - maxIndex;
            return getMaxEleIndex( remainingMoves, arrLen, maxIndex );
        }

    }

    private static int findMaxIndex( int[] workArr )
    {
        int maxIndex = -1;
        int max = -1;
        for( int i = 0; i < workArr.length; i++ )
        {
            if( workArr[i] > max )
            {
                max = workArr[i];
                maxIndex = i;
            }

        }
        return maxIndex;
    }

}
