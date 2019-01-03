package com.misc;

enum Hello
{
 REPLY_TO;

}

public class TestEnumEquals
{
    public static void main( String[] args )
    {
        String res = "REPLY_TO";
        System.out.println( Hello.REPLY_TO.name().equals( res ) );
    }

}
