package com.misc;

import java.util.Arrays;
import java.util.Collection;

interface Morph
{
    public void show();
}

class Poly1 implements Morph
{

    @Override
    public void show()
    {
        System.out.println( "Poly - Morph" );

    }

    public void methodShow()
    {
        System.out.println( "Method - Show" );
    }

}

public class Poly
{

    public static void main( String[] args )
    {
        Morph mp = new Poly1();
        mp.show();

        Poly1 p1 = new Poly1();
        p1.methodShow();

        Collection<String> collctn = Arrays.asList( "11", "#", "WER", "12", "37", "24", "AC4" );
        int oddSum = 0;
        int evenSum = 0;

        for( String str : collctn )
        {
            try
            {
                int i = Integer.valueOf( str );
                if( i % 2 == 0 )
                    evenSum = evenSum + i;
                else
                    oddSum = oddSum + i;
            }
            catch( NumberFormatException e )
            {
                System.out.println( "Not a number : " + str );
            }
        }

        System.out.println( "Even sum : " + evenSum );
        System.out.println( "Odd sum : " + oddSum );

    }

}
