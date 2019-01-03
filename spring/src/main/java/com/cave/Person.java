package com.cave;

public class Person
{

    private int id;
    private String name;
    private int texId;
    private Address address;

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

    public Address getAddress()
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
    }

    public Person()
    {

    }

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", name=" + name + ", texId=" + texId + ", address=" + address + "]";
    }

    public void onCreate()
    {
        System.out.println( "Person created :" + this.toString() );
    }

    public void onDestroy()
    {
        System.out.println( "Person destroyed :" + this.toString() );
    }

    public void init()
    {
        System.out.println( "Person init : " + this.toString() );
    }

    public static Person getInstance( int id,
                                      String name )
    {
        System.out.println( "Creating Person using Factory Method" );
        return new Person( id, name );
    }

}
