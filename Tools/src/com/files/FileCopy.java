package com.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;

public class FileCopy
{
    static int percentage = 0;
    public static final long ONE_KB = 1024;

    /**
     * The number of bytes in a kilobyte.
     *
     * @since 2.4
     */
    public static final BigInteger ONE_KB_BI = BigInteger.valueOf( ONE_KB );

    /**
     * The number of bytes in a megabyte.
     */
    public static final long ONE_MB = ONE_KB * ONE_KB;

    /**
     * The number of bytes in a megabyte.
     *
     * @since 2.4
     */
    public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply( ONE_KB_BI );

    /**
     * The file copy buffer size (30 MB)
     */
    private static final long FILE_COPY_BUFFER_SIZE = ONE_MB * 30;

    /**
     * The number of bytes in a gigabyte.
     */
    public static final long ONE_GB = ONE_KB * ONE_MB;

    public static void main( String[] args ) throws IOException
    {
        String fromDest = "C:/Users/sirimulla.karthik/Desktop/WENTBACK.txt";
        String toDest = "E:/Git";
        copy( fromDest, toDest );
        System.out.println( percentage );

    }

    @SuppressWarnings( "resource" )
    private static void copy( String fromDest,
                              String toDest ) throws IOException
    {
        File srcFile = new File( fromDest );
        File destFile = new File( toDest );
        if( destFile.isDirectory() )
            destFile = new File( destFile, srcFile.getName() );

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel input = null;
        FileChannel output = null;
        try
        {
            fis = new FileInputStream( srcFile );
            fos = new FileOutputStream( destFile );
            input = fis.getChannel();
            output = fos.getChannel();
            System.out.println( "Free memory (bytes): " + Runtime.getRuntime().freeMemory() );
            long freeMemory = Runtime.getRuntime().freeMemory();
            final long size = input.size();
            long pos = 0;
            long count = 0;
            while( pos < size )
            {
                final long remain = size - pos;
                count = remain > 1000 ? 1000
                    : remain;
                final long bytesCopied = output.transferFrom( input, pos, count );
                if( bytesCopied == 0 )
                { // IO-385 - can happen if file is truncated after caching the size
                    break; // ensure we don't loop forever
                }
                // System.out.println( "bytesCopied : " + bytesCopied );
                pos += bytesCopied;
                // System.out.println( "pos : " + pos );
                System.out.println( "Percentage ---> " + ( pos * 100 ) / size );
            }
        }
        finally
        {
        }

        final long srcLen = srcFile.length(); // TODO See IO-386
        final long dstLen = destFile.length(); // TODO See IO-386
        if( srcLen != dstLen )
        {
            throw new IOException( "Failed to copy full contents from '"
                + srcFile
                + "' to '"
                + destFile
                + "' Expected length: "
                + srcLen
                + " Actual: "
                + dstLen );

        }
    }

}
