package com.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.omg.SendingContext.RunTime;

/**
 *
 * @author
 */
public class Employee implements Comparable<Employee>
{
    private int id;
    private String name;
    private int salary;
    private int age;
    private Date dateOfJoining;

    public Employee()
    {

    }

    public static final Comparator<Employee> AgeComparator = new Comparator<Employee>()
    {

        @Override
        public int compare( Employee o1,
                            Employee o2 )
        {
            return o1.age - o2.age; // This will work because age is positive integer
        }

    };

    public static final Comparator<Employee> SalaryComparator = new Comparator<Employee>()
    {

        @Override
        public int compare( Employee o1,
                            Employee o2 )
        {
            return o1.salary - o2.salary; // salary is also positive integer
        }

    };

    public static final Comparator<Employee> NameComparator = new Comparator<Employee>()
    {

        @Override
        public int compare( Employee o1,
                            Employee o2 )
        {
            return o1.name.compareTo( o2.name );
        }

    };

    public static final Comparator<Employee> DOJComparator = new Comparator<Employee>()
    {

        @Override
        public int compare( Employee o1,
                            Employee o2 )
        {
            return o1.dateOfJoining.compareTo( o2.dateOfJoining );
        }

    };

    public Employee( int id,
        String name,
        int salary,
        int age,
        Date dateOfJoining )
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString()
    {
        return "Employee{"
            + "id="
            + id
            + ", name="
            + name
            + ", salary="
            + salary
            + ", age="
            + age
            + ", dateOfJoining="
            + dateOfJoining
            + '}';

    }

    @Override
    public int compareTo( Employee o )
    {
        return this.id - o.id;
    }

    @Override
    public boolean equals( Object obj )
    {
        if( obj == null )
        {
            return false;
        }
        if( getClass() != obj.getClass() )
        {
            return false;
        }
        final Employee other = (Employee) obj;
        if( this.id != other.id )
        {
            return false;
        }
        if( ( this.name == null ) ? ( other.name != null )
            : !this.name.equals( other.name ) )
        {
            return false;
        }
        if( this.salary != other.salary )
        {
            return false;
        }
        if( this.age != other.age )
        {
            return false;
        }
        if( this.dateOfJoining != other.dateOfJoining
            && ( this.dateOfJoining == null || !this.dateOfJoining.equals( other.dateOfJoining ) ) )
        {

            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + ( this.name != null ? this.name.hashCode()
            : 0 );
        hash = 47 * hash + this.salary;
        hash = 47 * hash + this.age;
        hash = 47 * hash + ( this.dateOfJoining != null ? this.dateOfJoining.hashCode()
            : 0 );
        return hash;
    }

    @SuppressWarnings( "deprecation" )
    public static void main( String[] args ) throws InstantiationException,
                                             IllegalAccessException,
                                             CloneNotSupportedException,
                                             NoSuchMethodException,
                                             SecurityException,
                                             IllegalArgumentException,
                                             InvocationTargetException
    {
        Employee e1 = new Employee( 1, "A", 1000, 32, new Date( 2011, 10, 1 ) );
        Employee e2 = new Employee( 2, "AB", 1300, 22, new Date( 2012, 10, 1 ) );
        Employee e3 = new Employee( 3, "B", 10, 42, new Date( 2010, 11, 3 ) );
        Employee e4 = new Employee( 4, "CD", 100, 23, new Date( 2011, 10, 1 ) );
        Employee e5 = new Employee( 5, "AAA", 1200, 26, new Date( 2011, 10, 1 ) );

        List<Employee> listOfEmployees = new ArrayList<Employee>();
        listOfEmployees.add( e1 );
        listOfEmployees.add( e2 );
        listOfEmployees.add( e3 );
        listOfEmployees.add( e4 );
        listOfEmployees.add( e5 );
        System.out.println( "Unsorted List : " + listOfEmployees );

        Collections.sort( listOfEmployees ); //Sorting by natural order
        System.out.println( "natural order : " + listOfEmployees );

        Collections.sort( listOfEmployees, Employee.NameComparator );
        System.out.println( "Name order : " + listOfEmployees );

        Collections.sort( listOfEmployees, Employee.AgeComparator );
        System.out.println( "AgeComparator order : " + listOfEmployees );

        Collections.sort( listOfEmployees, Employee.SalaryComparator );
        System.out.println( "SalaryComparator order : " + listOfEmployees );

        Collections.sort( listOfEmployees, Employee.DOJComparator );
        System.out.println( "DOJComparator order : " + listOfEmployees );

        /** Object Creation **/

        Employee eA = new Employee();
        Employee eB = Employee.class.newInstance();
        Employee eC = (Employee) eA.clone();
        Employee eD = null; // Using Deserialization
        Constructor<Employee> constructor = Employee.class.getConstructor();
        Employee eE = constructor.newInstance();

        RunTime rt = (RunTime) Runtime.getRuntime();

    }

}
