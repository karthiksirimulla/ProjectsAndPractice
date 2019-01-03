package com.cave;

public class PersonFactory
{
    public Person createPerson( int id,
                                String name )
    {
        System.out.println( "****** Creating person using factory class" );
        return new Person( id, name );
    }

}
