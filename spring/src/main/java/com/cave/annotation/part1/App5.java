package com.cave.annotation.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App5
{

    public static void main( String[] args )
    {
        /**
        *  ApplicationContext context = new FileSystemXmlApplicationContext( "src/main/java/com/cave/beans/beans.xml" );
        *  
        */

        ApplicationContext context = new ClassPathXmlApplicationContext( "com/cave/beans/beans-annotation.xml" );
        LoggerAnnotation logger = (LoggerAnnotation) context.getBean( "logger" );

        System.out.println( "-----------------------------------------------" );

        logger.writeToConsole( "Hii" );
        logger.writeToFile( "Hello" );

        System.out.println( "-----------------------------------------------" );

        ( (ClassPathXmlApplicationContext) context ).close();
    }

}
