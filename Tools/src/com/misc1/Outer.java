package com.misc1;

public class Outer
{
    public void someOuterMethod()
    {

    }

    public class Inner
    {

    }

    public static void main( String[] args )
    {
        Outer ot = new Outer();
        Inner in = ot.new Inner();
    }
}
