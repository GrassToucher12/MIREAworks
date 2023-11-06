package ru.mirea.kvbo0422.task18;

import java.util.Scanner;

public class TryCatch {
    TryCatch(){
        exceptionDemo();
    }
    public void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer( not a zero ): ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println( 2/i );
            }
        catch (NumberFormatException e) {
            System.out.format("%s is not an integer!", intString);
        }
        catch (ArithmeticException e){
            System.out.format("%s is zero!", intString);
        }
    }
    public static void main(String[] args) {
        new TryCatch();
    }


}
