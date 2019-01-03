package book.Sorts;

import java.util.Arrays;

public class InsertionSort
{

    public static void main( String[] args )
    {
        int[] arr = { 5, 4, 3, 2, 1 };

        iSort( arr );

    }

    private static void iSort( int[] arr )
    {
        int len = arr.length;

        for( int i = 1; i < len; i++ )
        {
            int j = 0;
            while( j <= i )
            {
                if( arr[i] < arr[j] )
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }

            System.out.println( Arrays.toString( arr ) );

        }

    }
}
