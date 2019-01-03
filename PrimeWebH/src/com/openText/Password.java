package com.openText;

public class Password
{
    public static void main( String[] args )
    {
        String password = "Chukku$45";
        /* System.out.println( Integer.valueOf( 'A' ) );
        System.out.println( Integer.valueOf( 'Z' ) );
        System.out.println( Integer.valueOf( 'a' ) );
        System.out.println( Integer.valueOf( 'z' ) );
        
        System.out.println( Integer.valueOf( '0' ) );
        System.out.println( Integer.valueOf( '9' ) );*/
        String res = checkPasswordStrength( password );
        System.out.println( res );

    }

    private static String checkPasswordStrength( String password )
    {
        if( password.length() < 6 )
            return "should more than 5 letters";
        if( password.length() > 15 )
            return "cannot be more than 15 letters";

        int count = 0;
        boolean cond1 = false;
        boolean cond2 = false;
        boolean cond3 = false;
        boolean cond4 = false;

        char[] arr = password.toCharArray();
        for( int i = 0; i < arr.length; i++ )
        {
            char c = arr[i];
            int ascii = Integer.valueOf( c );

            if( ascii >= 97 && ascii <= 122 && !cond1 )
            {
                cond1 = true;
                count++;
            }
            if( ascii >= 65 && ascii <= 90 && !cond2 )
            {
                cond2 = true;
                count++;
            }
            if( ascii >= 48 && ascii <= 57 && !cond3 )
            {
                cond3 = true;
                count++;
            }

            if( ( c == '$' || c == '#' || c == '*' || c == '!' ) && !cond4 )
            {
                cond4 = true;
                count++;
            }

            if( cond1 && cond2 && cond3 && cond4 )
            {
                break;
            }

        }

        switch( count )
        {
            case 1:
                return "Very Weak";
            case 2:
                return "Weak";
            case 3:
                return "Strong";
            case 4:
                return "Very strong";
            default:
                return "Password didnt meet parameters";
        }

    }

}
