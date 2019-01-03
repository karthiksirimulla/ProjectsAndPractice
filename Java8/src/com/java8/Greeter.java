package com.java8;

public class Greeter
{
    public void wish( Greetable greetable )
    {
        greetable.greet();
    }

    public static void main( String[] args )
    {
        Greetable grt = new HelloGreeter();
        Greetable lambdaHello = () -> System.out.println( "Hello ..." );
        Greetable IndianHello = () -> System.out.println( "Namasthe ..." );

        lambdaHello.greet();
        IndianHello.greet();

    }

}
