package com.tools;

public class GCScope
{
    GCScope t;
    static int i;

    public GCScope( int i )
    {
        this.i = i;
    }

    public static void main( String args[] )
    {
        GCScope t1 = new GCScope( 1 );
        GCScope t2 = new GCScope( 2 );
        GCScope t3 = new GCScope( 3 );

        // No Object Is Eligible for GC

        t1.t = t2; // No Object Is Eligible for GC
        t2.t = t3; // No Object Is Eligible for GC
        t3.t = t1; // No Object Is Eligible for GC

        t1 = null;
        // No Object Is Eligible for GC (t3.t still has a reference to t1)
        System.out.println( ( t3.t ).i );

        t2 = null;
        // No Object Is Eligible for GC (t3.t.t still has a reference to t2)

        t3 = null;
        // All the 3 Object Is Eligible for GC (None of them have a reference.
        // only the variable t of the objects are referring each other in a
        // rounded fashion forming the Island of objects with out any external
        // reference)
    }

    protected void finalize()
    {
        System.out.println( "Garbage collected from object" + i );
        i++;
    }
}