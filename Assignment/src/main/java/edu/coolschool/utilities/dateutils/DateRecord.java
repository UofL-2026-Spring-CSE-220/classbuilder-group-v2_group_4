package edu.coolschool.utilities.dateutils;

public record DateRecord(
        int dayInteger,
        int monthInteger,
        int yearInteger
) {
    // 1. COMPACT CONSTRUCTOR (Validation)
    public DateRecord {
        if (!DateValidator.isValidDate(dayInteger, monthInteger, yearInteger)) {
            throw new IllegalArgumentException("Invalid date: " + dayInteger + "/" + monthInteger + "/" + yearInteger);
        }
    }

    // 2. OVERLOADED CONSTRUCTOR (For Enums)
    public DateRecord(int day, MonthsEnum month, int year) {
        this(day, month.getMonthNumber(), year);
    }

    // 3. TOSTRING METHODS
    public String toString() {
        return toString(DateFormatOptionsEnum.MM_DD_YYYY);
    }

    public String toString(int tabLevel) {
        return "\t".repeat(tabLevel) + this.toString();
    }

    public String toString(DateFormatOptionsEnum format) {
        return switch (format) {
            case DD_MM_YYYY -> String.format("%02d/%02d/%04d", dayInteger, monthInteger, yearInteger);
            case MM_DD_YYYY -> String.format("%02d/%02d/%04d", monthInteger, dayInteger, yearInteger);
            case YYYY_MM_DD -> String.format("%04d/%02d/%02d", yearInteger, monthInteger, dayInteger);
            case MONTH_DD_YYYY -> {
                String monthName = MonthsEnum.fromMonthNumber(monthInteger).toString();
                yield String.format("%s %02d, %04d", monthName, dayInteger, yearInteger);
            }
        };
    }

    // 4. THE BUILDER CLASS
    // It must be 'static' so you can call 'new DateRecord.Builder()'
    public static class Builder {
        private int day;
        private int month;
        private int year;

        public Builder setDay(int day) {
            this.day = day;
            return this;
        }

        public Builder setMonth(int month) {
            this.month = month;
            return this;
        }

        // --- NEW METHOD ADDED HERE ---
        public Builder setMonth(MonthsEnum month) {
            this.month = month.getMonthNumber();
            return this;
        }
        // -----------------------------

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public DateRecord build() {
            return new DateRecord(day, month, year);
        }
    }
}