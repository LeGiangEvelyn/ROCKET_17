package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.next().trim());
            } catch (Exception e) {
                System.err.println("Enter again:");
            }
        }
    }

    public static int inputIntPositive() {
        while (true) {
            try {
                int intPositive = Integer.parseInt(sc.next());
                if (intPositive >= 0) {
                    return intPositive;
                } else {
                    System.err.println("Enter again:");
                }
            } catch (Exception e) {
                System.err.println("Enter again:");
            }
        }
    }

    public static Float inputFloat(String mes) {
        while (true) {
            try {
                return Float.parseFloat(sc.next());
            } catch (Exception e) {
                System.err.println("Enter again:");
            }
        }
    }

    public static Double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (Exception e) {
                System.err.println("Enter again:");
            }
        }
    }

    public static String inputString() {
        while (true) {
            String string = sc.nextLine().trim();
            if (!string.isEmpty()) {
                return string;
            } else {
                System.err.println("Enter again:");
            }
        }
    }

    public static LocalDate inputLocalDate() {
        System.out.println("Enter by format yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            String localdate = sc.next().trim();
            try {
                if (format.parse(localdate) != null) {
                    LocalDate lc = LocalDate.parse(localdate);
                    return lc;
                }
            } catch (Exception e) {
                System.err.println("Enter again:");
            }
        }
    }
}
