package com.cave.part2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2
{

    public static void main( String[] args )
    {
        /**
        *  ApplicationContext context = new FileSystemXmlApplicationContext( "src/main/java/com/cave/beans/beans.xml" );
        *  
        */

        ApplicationContext context = new ClassPathXmlApplicationContext( "com/cave/beans/beans-a.xml" );

        FruitBasket basket = (FruitBasket) context.getBean( "fruitBasket" );
        System.out.println( "-------> " + basket );

        ( (ClassPathXmlApplicationContext) context ).close();
    }

}
