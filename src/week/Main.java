package week;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean calculateEnded = false;
        while(!calculateEnded) {
            try {
                CalculatorApp.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
