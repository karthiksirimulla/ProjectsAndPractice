package com.Rough;

class Aero
{

}

class Vehicle extends Aero
{
    public void shout()
    {
        System.out.println( "Vehicle" );
    }

    public Vehicle start()
    {
        return null;
    }
}

class Car extends Vehicle
{
    public void shout()
    {
        System.out.println( "car" );
    }

    public Bike start()
    {
        return null;
    }
}

class Bike extends Vehicle
{
    public void shout()
    {
        System.out.println( "bike" );
    }

    public Vehicle start()
    {
        return null;
    }

}

class Ciaz extends Car
{

}

class ChildException extends Exception
{
}

class ParentException extends ChildException
{
}

class GrandParentException extends ParentException
{
}

class GreatGrandParentException extends GrandParentException
{
}

class Serial
{

    public void publish() throws GrandParentException
    {
        throw new GrandParentException();
    }

    public Number getInt()
    {
        return 0;
    }
}

class SunSerial extends Serial
{
    public void publish() throws GreatGrandParentException
    {
        throw new GreatGrandParentException();
    }

    public Integer getInt()
    {
        return 1;
    }

}

public class TestJohnson
{
    public static void main( String[] args )
    {
        char c = 'd';
        // 97 --- 122
        System.out.println( (char) ( c ) + " -- " + (char) ( 'z' - ( c - 'a' ) ) );

        // 1 - 25
        // 2 - 24
        // 3 - 23
    }

}
