package book.Sorts;

public class MaxSumSubArray
{
    public static void main( String[] args )
    {
        int[] arr = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
        int low = 0;
        int high = arr.length - 1;

        int res = maxSum( arr, low, high );
        System.out.println( res );
    }

    private static int maxSum( int[] arr,
                               int low,
                               int high )
    {
        if( low == high )
            return arr[high];

        int mid = ( low + high ) / 2;
        int leftSum = maxSum( arr, low, mid );
        int rightSum = maxSum( arr, mid + 1, high );

        return Math.max( Math.max( leftSum, rightSum ), maxCrossSum( arr, low, high, mid ) );

    }

    private static int maxCrossSum( int[] arr,
                                    int low,
                                    int high,
                                    int mid )
    {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for( int i = mid; i >= low; i-- )
        {
            sum = sum + arr[i];
            if( sum > leftSum )
            {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for( int i = mid + 1; i <= high; i++ )
        {
            sum = sum + arr[i];
            if( sum > rightSum )
            {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;

    }

}
