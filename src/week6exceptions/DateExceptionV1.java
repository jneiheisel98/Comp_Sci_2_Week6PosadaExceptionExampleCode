package week6exceptions;

import java.util.Scanner;
/***********************************************
 * Example to show how exceptions are handled
 * In this code, the exceptions are not handled
 * where they occur.  The are handled in a method
 * that invoked the method that generates the
 * exceptions.
 * The exceptions propagate until they find the
 * methodOne that handles them.
 *
 * @author Ana Posada
 * @version 1.0.0. February 2021
 *************************************************/
public class DateExceptionV1 {
    public void methodOne(){
        System.out.println("MethodOne begins");
        try {
            methodTwo();
        }
        catch (IllegalArgumentException e) {
            System.out.println("date error - not valid number");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("date error - format mm/dd/yy not found: ");
        }
        System.out.println("MethodOne ends");
    }

    public void methodTwo() {
        System.out.println("MethodTwo begins");
        methodThree();
        System.out.println("MethodTwo ends");
    }

    public void methodThree() {
        Scanner scan = new Scanner (System.in);
        String dateStr;
        System.out.println("MethodThree begins");
        System.out.println("Enter date with format mm/dd/yy");
        dateStr = scan.nextLine();
        String[] date = dateStr.split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        if (month < 1 || month > 12)
            throw new IllegalArgumentException();
        if (day < 1 || day > 31)
            throw new IllegalArgumentException();
        System.out.println("MethodThree ends");
    }
    public static void main(String[] args) {
        DateExceptionV1 dateExceptionV1 = new DateExceptionV1();
        System.out.println("Program begins");
        dateExceptionV1.methodOne();
        System.out.println("Program ends");
    }
}
