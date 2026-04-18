package edu.coolschool.utilities;

public enum ErrorStrings {
    FIRST_NAME_BLANK("First name cannot be null or blank. Please provide a valid first name."),
    LAST_NAME_BLANK("Last name cannot be null or blank. Please provide a valid last name."),
    NULL_DATE("Date cannot be null. Please provide a valid date."),
    NULL_COUNTRY("Country cannot be null. Please provide a valid country."),
    NULL_COUNTRY_OF_BIRTH("Country of birth cannot be null. Please provide a valid country of birth."),
    INVALID_DATE("The date provided is not valid. Please enter a valid date."),
    NULL_STUDENT_INFO("Student information cannot be null. Please provide valid student information."),
    INVALID_STUDENT_ID("Student ID must be exactly 9 characters long and cannot be null or blank. Please provide a valid student ID."),
    NULL_ENROLLMENT_DATE("Enrollment date cannot be null. Please provide a valid enrollment date."),
    UNKNOWN_COUNTRY("The country provided is not recognized. Please contact support for assistance.");

    private final String message;

    ErrorStrings(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}