package com.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Buffered
{

    public static void main( String[] args ) throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int noTestCases = Integer.parseInt( br.readLine() );
        String ssr = br.readLine();
        int[] arr = new int[noTestCases];
        String vals = br.readLine();
        String[] ss = vals.split( " " );
        int i = 0;
        for( String s : ss )
        {
            arr[i] = Integer.parseInt( s );
            i++;
        }
        System.out.println( noTestCases );
        System.out.println( Arrays.toString( arr ) );
        int k = 2;
        System.out.println( (int) Math.pow( 2, Math.pow( 2, k ) ) - 1 );

    }
}
