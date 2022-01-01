package week6exceptions;

import java.util.Scanner;

/***********************************************
 * Example to show how exceptions are handled
 * In this code, the exceptions are handled in
 * the method where they occur
 *
 * @author Ana Posada
 * @version 1.0.0. February 2021
 *************************************************/
public class DateException {
    public void methodOne(){
        System.out.println("MethodOne begins");
        methodTwo();
        System.out.println("MethodOne ends");
    }

    public void methodTwo() {
        System.out.println("MethodTwo begins");
        methodThree();
        System.out.println("MethodTwo ends");
    }

    /************************************************
     * This method reads a date with the format
     * mm/dd/yy
     * handles the 3 possible exceptions:
     * NumberFormatException, IndexOutOfBoundsException
     * IllegalArgumentException
     **************************************************/
    public void methodThree() {
        Scanner scan = new Scanner (System.in);
        String dateStr;
        System.out.println("MethodThree begins");
        System.out.println("Enter a date with format mm/dd/yy");
        dateStr = scan.nextLine();
        String[] date = dateStr.split("/");
        try {
            int month = Integer.parseInt(date[0]);
            int day = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            if (month < 1 || month > 12)
                throw new IllegalArgumentException();
            if (day < 1 || day > 31)
                throw new IllegalArgumentException();
        }
        catch (NumberFormatException e) {
            System.out.println("date error - not valid number: " + dateStr);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("date error - format mm/dd/yy not found: " + dateStr);
        }
        catch (IllegalArgumentException e) {
            System.out.println("date error - invalid day or month " + dateStr);
        }
        System.out.println("MethodThree ends");
    }

    public static void main(String[] args) {
        DateException dateException = new DateException();
        System.out.println("Program begins");
        dateException.methodOne();
        System.out.println("Program ends");
    }
}
