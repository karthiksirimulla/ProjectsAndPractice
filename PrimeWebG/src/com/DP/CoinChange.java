package com.DP;

/*
 * Given a value N, if we want to make change for N cents, and 
 * we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.

    For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
    So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: 
    {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange
{
    public static void main( String[] args )
    {
        int arr[] = { 1, 2, 3 };
        int len = arr.length;
        int sum = 4;
        System.out.println( count( arr, len, sum ) );
    }

    private static int count( int[] arr,
                              int len,
                              int sum )
    {
        if( sum < 0 )
            return 0;
        if( sum == 0 )
            return 1;
        if( len <= 0 && sum >= 1 )
            return 0;
        // count is sum of solutions 
        // (i) including arr[len-1] 
        // (ii) excluding arr[len-1]
        //      using the coin                      +  not using the coin
        return count( arr, len, sum - arr[len - 1] ) + count( arr, len - 1, sum );

        /*
         * C() --> count()
                                         C({1,2,3}, 5)                     
                                       /             \    
                                     /                 \                  
                         C({1,2,3}, 2)                 C({1,2}, 5)
                        /       \                      /      \         
                       /         \                    /         \   
            C({1,2,3}, -1)  C({1,2}, 2)        C({1,2}, 3)    C({1}, 5)
                           /    \             /     \           /     \
                         /       \           /       \         /        \
                #C({1,2},0)  C({1},2)   C({1,2},1) C({1},3)    C({1}, 4)  C({}, 5)
                               / \     / \        /\         /     \         
                              /   \   /   \     /   \       /       \  
                            .      .  .     .   .     .   C({1}, 3) C({}, 4)
                                                           / \ 
                                                          /   \   
                                                         .      .
         * 
         * 
         */
    }

}
