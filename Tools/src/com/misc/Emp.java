package com.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Emp implements Comparable<Emp>
{
    int id;
    String name;
    String deparment;

    static
    {
        System.out.println( "Statically ..............." );
    }

    public Emp( int id,
        String name,
        String deparment )
    {
        super();
        this.id = id;
        this.name = name;
        this.deparment = deparment;
    }

    public static void main( String[] args )
    {
        System.out.println( "First ............" );
        Emp emp1 = new Emp( 1, "A", "AA" );
        Emp emp2 = new Emp( 2, "B", "BB" );

        //emp1 = emp2;

        System.out.println( emp1.equals( emp2 ) );

        Map<Integer, Integer> m = new HashMap<>();
        Collections.synchronizedMap( m );

        List<Emp> empList = new ArrayList<>();
        Collections.sort( empList );

        List<Integer> lst = new LinkedList<>();

    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( deparment == null ) ? 0
            : deparment.hashCode() );
        result = prime * result + id;
        result = prime * result + ( ( name == null ) ? 0
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
        Emp other = (Emp) obj;
        if( deparment == null )
        {
            if( other.deparment != null )
                return false;
        }
        else if( !deparment.equals( other.deparment ) )
            return false;
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

    @Override
    public int compareTo( Emp o )
    {
        return this.id - o.id;
    }

}

class NameCompare implements Comparator<Emp>
{

    @Override
    public int compare( Emp o1,
                        Emp o2 )
    {
        return o1.name.compareTo( o2.name );
    }

}

class myException extends Throwable
{

}
