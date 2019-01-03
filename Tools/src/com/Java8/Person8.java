package com.Java8;

interface Named
{
    default String getName()
    {
        System.out.println( "Named" );
        return "Named";
    }

}

interface Student
{
    String getName();
}

public class Person8 implements Student, Named
{

    @Override
    public String getName()
    {
        // TODO Auto-generated method stub
        return Named.super.getName();
    }

}
