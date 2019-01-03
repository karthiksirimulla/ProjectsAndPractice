package com.dp.Adapter;

public class Adapter implements Charge
{

    MicroUSBCharger charger = new MicroUSBCharger();

    @Override
    public void charging( String str )
    {
        charger.ChargePhone( str );

    }

}
