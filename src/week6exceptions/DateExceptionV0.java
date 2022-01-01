package week6exceptions;

import java.util.Scanner;
/***********************************************
 * Example to show how exceptions are handled
 * In this code, the exceptions are NOT handled
 * at all in any of the methods
 * The exceptions propagate all the way to
 * the main method and then he program finishes
 * with a run-time error
 *
 * @author Ana Posada
 * @version 1.0.0. February 2021
 *************************************************/

public class DateExceptionV0 {
    public void methodOne() {
        System.out.println("MethodOne begins");
        methodTwo();
        System.out.println("MethodOne ends");
    }

    public void methodTwo() {
        System.out.println("MethodTwo begins");
        methodThree();
        System.out.println("MethodTwo ends");
    }

    public void methodThree() {
        Scanner scan = new Scanner(System.in);
        String dateStr;
        System.out.println("MethodThree begins");
        System.out.println("Enter date with format mm/dd/yy");
        dateStr = scan.nextLine();
        String[] date = dateStr.split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        System.out.println("MethodThree ends");
    }

    public static void main(String[] args) {
        DateExceptionV0 dateExceptionV0 = new DateExceptionV0();
        System.out.println("Program begins");
        dateExceptionV0.methodOne();
        System.out.println("Program ends");
    }
}
