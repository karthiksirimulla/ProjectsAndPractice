package com.Prac;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectCreation
{
    public static void main( String[] args ) throws CloneNotSupportedException,
                                             InstantiationException,
                                             IllegalAccessException,
                                             ClassNotFoundException,
                                             NoSuchMethodException,
                                             SecurityException,
                                             IllegalArgumentException,
                                             InvocationTargetException
    {
        Test t1 = new Test();

        Test t2 = (Test) t1.clone();

        Test t3 = Test.class.newInstance();

        Test t4 = (Test) Class.forName( "Test" ).newInstance();

        Constructor<Test> constructor = Test.class.getConstructor();

        Test t5 = constructor.newInstance();

    }

}

class Test implements Cloneable
{

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();

    }

}
