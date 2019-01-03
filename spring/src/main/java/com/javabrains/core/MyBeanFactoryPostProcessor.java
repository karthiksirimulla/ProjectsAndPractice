/**
 * 
 */
package com.javabrains.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author migue
 *
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{

    public void postProcessBeanFactory( ConfigurableListableBeanFactory beanFactory ) throws BeansException
    {
        System.out.println( "<<<<< My Bean Factory Post Processor called >>>>>" );

    }

}
