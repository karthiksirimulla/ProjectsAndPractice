package com.misc;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Student implements Comparable<Student>
{
    @Override
    public String toString()
    {
        return "Student [rollNo=" + rollNo + ", name=" + name + "]";
    }

    int rollNo;
    String name;

    public Student( int rollNo,
        String name )
    {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo()
    {
        return rollNo;
    }

    public void setRollNo( int rollNo )
    {
        this.rollNo = rollNo;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public static void main( String[] args )
    {
        TreeMap<Student, String> tMap = new TreeMap<>();
        tMap.put( new Student( 3, "c" ), "C" );
        tMap.put( new Student( 1, "a" ), "A" );
        tMap.put( new Student( 2, "b" ), "B" );
        tMap.put( new Student( 5, "e" ), "E" );
        tMap.put( new Student( 4, "d" ), "D" );

        for( Entry<Student, String> entry : tMap.entrySet() )
        {
            System.out.println( entry.getKey() );

        }
    }

    @Override
    public int compareTo( Student o )
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
