package com.cave;

public class Address
{
    private String street;
    private String postalCode;

    public Address( String street,
        String postalCode )
    {
        this.street = street;
        this.postalCode = postalCode;
    }

    public Address()
    {
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet( String street )
    {
        this.street = street;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode( String postalCode )
    {
        this.postalCode = postalCode;
    }

    @Override
    public String toString()
    {
        return "Address [street=" + street + ", postalCode=" + postalCode + "]";
    }

}
