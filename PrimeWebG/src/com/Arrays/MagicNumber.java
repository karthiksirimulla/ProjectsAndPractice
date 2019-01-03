package com.Arrays;

/*
 *
 *A magic number is a number that has two characteristics:
    No digits repeat.
    Beginning with the leftmost digit, take the value of the digit and move that number of digits to the right. Repeat the process again using the value of the current digit to move right again. Wrap back to the leftmost digit as necessary. A magic number will visit every digit exactly once and end at the leftmost digit.
    For example, consider the magic number 6231.
    Start with 6. Advance 6 steps to 3, wrapping around once (6→2→3→1→6→2→3).
    From 3, advance to 2.
    From 2, advance to 1.
    From 1, advance to 6. 
 * 
 * 
 * 
 */
public class MagicNumber
{
    public static void main( String[] args )
    {
        int number = 6231;
        //[6, 2, 3, 1]
        // 0  1  2  3

        boolean res = isMagicNumber( number );
        System.out.println( "Output : " + res );

        for( int i = 10; i < 101; i++ )
        {
            // if( isMagicNumber( i ) )
            //System.out.print( i + ", " );
        }

    }

    private static boolean isMagicNumber( int number )
    {
        if( isDigitRepeat( number ) )
        {
            return false;
        }

        int len = String.valueOf( number ).length();

        int[] arr = new int[len];
        int temp = number;

        int k = len - 1;

        while( temp > 0 )
        {
            arr[k] = temp % 10;
            temp = temp / 10;
            k--;
        }

        if( isMagic( arr ) )
        {
            return true;
        }

        return false;
    }

    private static boolean isMagic( int[] arr )
    {
        int counter = 0;
        int index = 0;
        int len = arr.length;
        int var = arr[index];

        while( counter != len )
        {
            int moves = 0;
            if( var >= len )
                moves = var % len;
            else
                moves = var;

            //[6, 2, 3, 1]
            // 0  1  2  3

            System.out.println( "Value : " + var );
            System.out.println( "Index : " + index );
            System.out.println( "Moves : " + moves );
            System.out.println( "---> " + ( index + moves ) % len );

            if( arr[( index + moves ) % len] == -1 )
                return false;

            var = arr[( index + moves ) % len];
            arr[( index + moves ) % len] = -1;
            index = ( index + moves ) % len;
            counter++;
        }
        return true;
    }

    private static boolean isDigitRepeat( int number )
    {
        int[] arr = new int[10];
        int temp = number;
        while( temp > 0 )
        {
            int index = temp % 10;
            if( arr[index] == 1 )
            {
                return true;
            }
            arr[index] = 1;
            temp = temp / 10;

        }

        return false;
    }
}
