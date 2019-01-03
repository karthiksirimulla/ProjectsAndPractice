package com.javabrains.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author migue
 *
 */
public class DrawingApp
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {

        // Triangle triangle = new Triangle();
        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));

        AbstractApplicationContext context = new ClassPathXmlApplicationContext( "spring.xml" );
        context.registerShutdownHook();
        Shape shape = (Shape) context.getBean( "triangle" );
        shape.draw();

        // System.out.println( "-------------CALL TO DRAW METHOD..... --------------" );
        //triangle.draw();
    }

}
