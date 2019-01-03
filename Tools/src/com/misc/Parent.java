package com.misc;

import java.util.HashSet;
import java.util.Set;

class Parent1
{
    int i = 10;

    static void method()
    {
        System.out.println( "Call Parent" );
    }

    static class Employee
    {
        int id;
        String name;

        public Employee( int id,
            String name )
        {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result
                + ( ( name == null ) ? 0
                    : name.hashCode() );
            return result;
        }

        @Override
        public boolean equals( Object obj )
        {
            if( this == obj )
                return true;
            if( obj == null )
                return false;
            if( getClass() != obj.getClass() )
                return false;
            Employee other = (Employee) obj;
            if( id != other.id )
                return false;
            if( name == null )
            {
                if( other.name != null )
                    return false;
            }
            else if( !name.equals( other.name ) )
                return false;
            return true;
        }

        public int getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }
    }

    public static void main( String[] args )
    {
        System.out.println( "HI" );
        Employee e1 = new Employee( 1, "Ram" );
        Employee e2 = new Employee( 1, "Ram" );

        Set<Employee> s = new HashSet<>();

        System.out.println( "Size:" + s.size() );

    }

}
