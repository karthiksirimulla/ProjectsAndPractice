package com.cave.hibernate;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person
{

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;
    private String name;
    @Embedded
    private int texId;

    public int getTexId()
    {
        return texId;
    }

    public void setTexId( int texId )
    {
        this.texId = texId;
    }

    public void speak()
    {
        System.out.println( "Im speaking ...." );
    }

    public Person( int id,
        String name )
    {
        super();
        this.id = id;
        this.name = name;
    }

}
