package edu.coolschool;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, welcome to the Cool School Student Record System!");

        DateRecord studentDOB = new DateRecord.Builder()
                .setDay(15)
                .setMonth(MonthsEnum.MARCH)
                .setYear(2002)
                .build();

        DateRecord enrollmentDate = new DateRecord(1, 9, 2020);

        PersonInfo studentInfo = new PersonInfo.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setDateOfBirth(studentDOB)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        StudentRecord studentRecord = new StudentRecord.Builder()
                .setStudentInfo(studentInfo)
                .setStudentID("ABC123456")
                .setEnrollmentDate(enrollmentDate)
                .build();

        System.out.println(studentRecord);
    }
}

