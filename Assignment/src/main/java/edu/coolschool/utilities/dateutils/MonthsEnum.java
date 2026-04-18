package edu.coolschool.utilities.dateutils;

public enum MonthsEnum {
    JANUARY(1, "January"),
    FEBRUARY(2, "February"),
    MARCH(3, "March"),
    APRIL(4, "April"),
    MAY(5, "May"),
    JUNE(6, "June"),
    JULY(7, "July"),
    AUGUST(8, "August"),
    SEPTEMBER(9, "September"),
    OCTOBER(10, "October"),
    NOVEMBER(11, "November"),
    DECEMBER(12, "December");

    private final int monthNumber;
    private final String displayName;

    MonthsEnum(int monthNumber, String displayName) {
        this.monthNumber = monthNumber;
        this.displayName = displayName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static MonthsEnum fromInt(int month) {
        for (MonthsEnum m : values()) {
            if (m.monthNumber == month) {
                return m;
            }
        }
        throw new IllegalArgumentException("Invalid month: " + month);
    }

    @Override
    public String toString() {
        return displayName;
    }
}
