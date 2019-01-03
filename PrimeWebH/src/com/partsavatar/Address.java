package com.partsavatar;

public class Address
{
    String city;
    String pincode;
    Warehouse warehouse;

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public Warehouse getWarehouse()
    {
        return warehouse;
    }

    public void setWarehouse( Warehouse warehouse )
    {
        this.warehouse = warehouse;
    }

    public String getPincode()
    {
        return pincode;
    }

    public void setPincode( String pincode )
    {
        this.pincode = pincode;
    }

}
