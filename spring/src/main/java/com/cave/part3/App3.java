package com.cave.part3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3
{

    public static void main( String[] args )
    {
        /**
        *  ApplicationContext context = new FileSystemXmlApplicationContext( "src/main/java/com/cave/beans/beans.xml" );
        *  
        */

        ApplicationContext context = new ClassPathXmlApplicationContext( "com/cave/beans/beans-c.xml" );

        Jungle jungle = (Jungle) context.getBean( "jungle" );
        System.out.println( "-------> " + jungle );

        ( (ClassPathXmlApplicationContext) context ).close();
    }

}
