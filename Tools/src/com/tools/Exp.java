package com.tools;

public class Exp
{
    public static void main( String[] args )
    {
        try
        {
            method();
            System.out.print( "A" );

        }
        catch( RuntimeException e )
        {
            System.out.print( "B" );
        }
        catch( Exception ex )
        {
            System.out.print( "C" );
        }
        finally
        {
            System.out.print( "D" );
        }
    }

    private static void method()
    {
        throw new RuntimeException();

    }

}
