package edu.coolschool.utilities.dateutils;

import edu.coolschool.utilities.ErrorStrings;

public record DateRecord(int day, MonthsEnum month, int year) {

    public DateRecord {
        if (month == null) {
            throw new IllegalArgumentException(ErrorStrings.INVALID_DATE.getMessage());
        }
        if (!DateValidator.isValidDate(day, month, year)) {
            throw new IllegalArgumentException(ErrorStrings.INVALID_DATE.getMessage());
        }
    }

    public DateRecord(int day, int month, int year) {
        this(day, MonthsEnum.fromInt(month), year);
    }

    @Override
    public String toString() {
        return toString(DateFormatOptionsEnum.MM_DD_YYYY);
    }

    public String toString(DateFormatOptionsEnum format) {
        if (format == null) {
            format = DateFormatOptionsEnum.MM_DD_YYYY;
        }

        int monthNum = month.getMonthNumber();
        String mm = String.format("%02d", monthNum);
        String dd = String.format("%02d", day);
        String yyyy = String.format("%04d", year);

        return switch (format) {
            case DD_MM_YYYY -> dd + "/" + mm + "/" + yyyy;
            case MM_DD_YYYY -> mm + "/" + dd + "/" + yyyy;
            case YYYY_MM_DD -> yyyy + "/" + mm + "/" + dd;
            case MONTH_DD_YYYY -> month.getDisplayName() + " " + dd + ", " + yyyy;
        };
    }

    public static class Builder {
        private Integer day;
        private MonthsEnum month;
        private Integer year;

        public Builder setDay(int day) {
            this.day = day;
            return this;
        }

        public Builder setMonth(MonthsEnum month) {
            this.month = month;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public DateRecord build() {
            if (day == null || month == null || year == null) {
                throw new IllegalArgumentException(ErrorStrings.INVALID_DATE.getMessage());
            }
            return new DateRecord(day, month, year);
        }
    }
}