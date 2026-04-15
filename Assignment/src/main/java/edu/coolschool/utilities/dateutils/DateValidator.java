package edu.coolschool.utilities.dateutils;

public class DateValidator {

    /**
     * Checks if a year is a leap year based on Gregorian calendar rules.
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else {
            return year % 400 == 0;
        }
    }

    public static int getDaysInMonth(MonthsEnum month, int year) {
        return getDaysInMonth(month.getMonthNumber(), year);
    }

    /**
     * Returns the maximum number of days in a given month.
     * Fixed: Added cases for 30-day months and leap year logic for February.
     */
    public static int getDaysInMonth(int month, int year) {
        return switch (month) {
            // Months with 31 days
            case 1, 3, 5, 7, 8, 10, 12 -> 31;

            // Months with 30 days
            case 4, 6, 9, 11 -> 30;

            // February: Uses the isLeapYear method to decide
            case 2 -> isLeapYear(year) ? 29 : 28;

            default -> throw new IllegalArgumentException("Invalid month number: " + month);
        };
    }

    /**
     * Validates if the day, month, and year combination is a real calendar date.
     */
    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        // Validates the day against the specific maximum for that month/year
        if (day < 1 || day > getDaysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    public static boolean isValidDate(int day, MonthsEnum month, int year) {
        return isValidDate(day, month.getMonthNumber(), year);
    }

    public static void main(String[] args) {
        // Testing the fixes
        System.out.println("Sept 15, 2026 valid? " + isValidDate(15, 9, 2026)); // Should be true now
        System.out.println("Feb 29, 2020 valid? " + isValidDate(29, 2, 2020)); // true (Leap)
        System.out.println("Feb 29, 2021 valid? " + isValidDate(29, 2, 2021)); // false (Not Leap)
        System.out.println("April 31, 2021 valid? " + isValidDate(31, 4, 2021)); // false (April has 30)
    }
}