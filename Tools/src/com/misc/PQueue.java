package com.misc;

import java.util.Iterator;
import java.util.PriorityQueue;

class Employee implements Comparable<Employee>
{
    public Employee( int age,
        int salary )
    {
        super();
        this.age = age;
        this.salary = salary;
    }

    int age;
    int salary;

    @Override
    public String toString()
    {
        return "Employee [age=" + age + ", salary=" + salary + "]";
    }

    @Override
    public int compareTo( Employee o )
    {
        return 0;
    }
}

public class PQueue
{

    public static void main( String[] args )
    {
        PriorityQueue<Employee> pQ = new PriorityQueue<Employee>();
        for( int i = 0; i < 11; i++ )
        {
            pQ.add( new Employee( i, i ) );
        }

        System.out.println( pQ );

        PriorityQueue<Integer> pQInt = new PriorityQueue<>();
        pQInt.add( 2 );
        pQInt.add( 9 );
        pQInt.add( 7 );
        pQInt.add( 5 );
        pQInt.add( 3 );
        System.out.println( pQInt );

        Iterator<Integer> it = pQInt.iterator();

        while( !pQInt.isEmpty() )
        {
            System.out.print( pQInt.poll() + "," );
        }

        while( it.hasNext() )
        {
            System.out.print( it.next() + "," );
        }

    }
}
