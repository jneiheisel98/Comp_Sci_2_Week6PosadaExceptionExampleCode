package week6exceptions;//********************************************************************
//  CreatingExceptions.java       Java Foundations
//
//  Demonstrates the ability to define an exception via inheritance.
//********************************************************************

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreatingExceptions
{
    //-----------------------------------------------------------------
    //  Creates an exception object and possibly throws it.
    //-----------------------------------------------------------------
    public static void main(String[] args) throws OutOfRangeException
    {
        final int MIN = 25, MAX = 40;

        Scanner scan = new Scanner(System.in);

        OutOfRangeException problem =
                new OutOfRangeException("Input value is out of range.");

        System.out.print("Enter an integer value between " + MIN +
                " and " + MAX + ", inclusive: ");
      try {
            int value = scan.nextInt();

            //  Determine if the exception should be thrown
            if (value < MIN || value > MAX)
                throw problem;
      }
        catch (OutOfRangeException e){
            System.out.println("number not in range ");
        }
        catch (InputMismatchException e){
            System.out.println("error - not a number");
        }
        System.out.println("End of main method.");  // may never reach
    }
}
