package edu.coolschool.students;

import edu.coolschool.utilities.ErrorStrings;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;

public record StudentRecord(
        PersonInfo studentInfo,
        String studentID,
        PersonInfo fatherInfo,
        PersonInfo motherInfo,
        DateRecord enrollmentDate
) {

    /**
     * Compact Constructor: This is where the validation happens.
     */
    public StudentRecord {
        // 1. Validate Student ID using ErrorStrings enum
        if (studentID == null || studentID.isBlank() || studentID.length() != 9) {
            // .getMessage() converts the Enum object into the actual String message
            throw new IllegalArgumentException(ErrorStrings.INVALID_STUDENT_ID.getMessage());
        }

        // 2. Validate Student Info
        if (studentInfo == null) {
            throw new IllegalArgumentException(ErrorStrings.NULL_STUDENT_INFO.getMessage());
        }

        // 3. Validate Enrollment Date
        if (enrollmentDate == null) {
            throw new IllegalArgumentException(ErrorStrings.NULL_ENROLLMENT_DATE.getMessage());
        }
    }

    @Override
    public String toString() {
        return toString(0);
    }

    /**
     * Formats the student record with indentation for better readability.
     */
    public String toString(int tabLevel) {
        String indent = "\t".repeat(tabLevel);
        String nestedIndent = "\t".repeat(tabLevel + 1);
        StringBuilder sb = new StringBuilder();

        sb.append(indent).append("Student ID: ").append(studentID).append("\n");
        sb.append(nestedIndent).append("Enrollment Date: ").append(enrollmentDate).append("\n");

        // Use the toString(int) methods of the nested objects
        sb.append(nestedIndent).append("Student Information:\n");
        sb.append(studentInfo.toString(tabLevel + 2));

        if (fatherInfo != null) {
            sb.append(nestedIndent).append("Father Information:\n");
            sb.append(fatherInfo.toString(tabLevel + 2));
        }

        if (motherInfo != null) {
            sb.append(nestedIndent).append("Mother Information:\n");
            sb.append(motherInfo.toString(tabLevel + 2));
        }

        sb.append("\n");

        return sb.toString();
    }

    public static class Builder {
        private PersonInfo studentInfo;
        private String studentID;
        private PersonInfo fatherInfo;
        private PersonInfo motherInfo;
        private DateRecord enrollmentDate;

        public Builder setStudentInfo(PersonInfo studentInfo) {
            this.studentInfo = studentInfo;
            return this;
        }

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setFatherInfo(PersonInfo fatherInfo) {
            this.fatherInfo = fatherInfo;
            return this;
        }

        public Builder setMotherInfo(PersonInfo motherInfo) {
            this.motherInfo = motherInfo;
            return this;
        }

        public Builder setEnrollmentDate(DateRecord enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
            return this;
        }

        public StudentRecord build() {
            return new StudentRecord(studentInfo, studentID, fatherInfo, motherInfo, enrollmentDate);
        }
    }
}