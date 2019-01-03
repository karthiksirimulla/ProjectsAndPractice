package com.collection.framework;

public class Employee
{
    private int empNo;
    private String empName;

    public Employee( int empNo,
        String empName )
    {
        this.empNo = empNo;
        this.empName = empName;
    }

    public int getEmpNo()
    {
        return empNo;
    }

    public void setEmpNo( int empNo )
    {
        this.empNo = empNo;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName( String empName )
    {
        this.empName = empName;
    }

}
