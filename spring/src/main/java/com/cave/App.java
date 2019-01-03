package com.cave;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{

    public static void main( String[] args )
    {
        /**
        *  ApplicationContext context = new FileSystemXmlApplicationContext( "src/main/java/com/cave/beans/beans.xml" );
        *  
        */

        ApplicationContext context = new ClassPathXmlApplicationContext( "com/cave/beans/beans.xml" );

        Address addr = (Address) context.getBean( "address2" );
        System.out.println( "-------> " + addr );

        ( (ClassPathXmlApplicationContext) context ).close();
    }

}
