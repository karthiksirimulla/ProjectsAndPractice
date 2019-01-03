package com.dp.Adapter;

public class IPhone implements Cloneable
{
    private Charge charge;

    public Charge getCharge()
    {
        return charge;
    }

    public void setCharge( Charge charge )
    {
        this.charge = charge;
    }

    public void chargePhone( String str )
    {
        charge.charging( str );
    }

}
