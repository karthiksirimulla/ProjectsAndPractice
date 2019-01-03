package com.dp.Adapter;

public class ChargePhone
{

    public static void main( String[] args )
    {
        IPhone iPhone = new IPhone();
        iPhone.setCharge( new Adapter() );
        iPhone.chargePhone( "Charging..." );

    }

}
