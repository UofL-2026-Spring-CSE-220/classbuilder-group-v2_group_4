package edu.coolschool.utilities.dateutils;

public final class DateValidator {

    private DateValidator() {
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }

    public static int getDaysInMonth(MonthsEnum month, int year) {
        if (month == null) {
            throw new IllegalArgumentException("Month cannot be null.");
        }
        return getDaysInMonth(month.getMonthNumber(), year);
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1) {
            return false;
        }
        return day <= getDaysInMonth(month, year);
    }

    public static boolean isValidDate(int day, MonthsEnum month, int year) {
        if (month == null) {
            return false;
        }
        return isValidDate(day, month.getMonthNumber(), year);
    }
}