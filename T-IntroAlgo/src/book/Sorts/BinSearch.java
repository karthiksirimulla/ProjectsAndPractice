package book.Sorts;

public class BinSearch
{

    public static void main( String[] args )
    {
        int[] arr = { 2, 5, 7, 12, 12, 16, 26, 26, 37, 48 };
        int key = 11;

        search( arr, key );
    }

    private static void search( int[] arr,
                                int key )
    {
        int low = 0;
        int high = arr.length;

        while( low <= high )
        {
            int mid = ( low + high ) / 2;
            if( arr[mid] == key )
            {
                System.out.println( "Found" );
                return;
            }

            if( arr[mid] > key )
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println( "Not Found" );

    }

}
