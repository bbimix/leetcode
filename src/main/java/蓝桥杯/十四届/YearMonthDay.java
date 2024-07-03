package 蓝桥杯.十四届;

import java.util.ArrayList;
import java.util.List;

public class YearMonthDay {

    private static Integer calNumber() {

        int[] monthDayList = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Integer res = 0;

        for (int i = 2000; i < 2000000; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                monthDayList[2] = 29;
            } else {
                monthDayList[2] = 28;
            }
            for (int j = 1; j <= 12; j++) {
                for (int k = 1; k <= monthDayList[j]; k++) {
                    if (i % j == 0 && i % k == 0) {
                        res++;
                    }
                }
            }
        }
        res++;
        return res;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    /**
     * 有问题，先别用
     * @return
     */
    private static Integer calNumberOptimized() {
        int[] monthDayList = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Integer res = 0;

        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= monthDayList[month]; day++) {
                // Calculate the LCM of month and day
                int yearLcm = lcm(month, day);
                // Find the starting year greater than or equal to 2000 that is a multiple of LCM
                int startYear = ((2000 + yearLcm - 1) / yearLcm) * yearLcm;
                for (int year = startYear; year < 2000000; year += yearLcm) {
                    if (month == 2 && day == 29) {
                        // Special case for February 29: check if it's a leap year
                        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                            res++;
                        }
                    } else {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        System.out.println(calNumberOptimized());
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
