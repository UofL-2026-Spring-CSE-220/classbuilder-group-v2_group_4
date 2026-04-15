package edu.coolschool;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, welcome to the Cool School Student Record System!");

        DateRecord studentDOB = new DateRecord.Builder()
                .setDay(15)
                .setMonth(3)
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

        PersonInfo fatherInfo = new PersonInfo.Builder()
                .setFirstName("Michael")
                .setLastName("Doe")
                .setDateOfBirth(new DateRecord(20, 5, 1970))
                .setCountryOfResidence(CountriesEnum.GB)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        PersonInfo motherInfo = new PersonInfo.Builder()
                .setFirstName("Sarah")
                .setLastName("Doe")
                .setDateOfBirth(new DateRecord(10, 8, 1975))
                .setCountryOfResidence(CountriesEnum.GB)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        StudentRecord studentRecord = new StudentRecord.Builder()
                .setStudentInfo(studentInfo)
                .setStudentID("123456789")
                .setFatherInfo(fatherInfo)
                .setMotherInfo(motherInfo)
                .setEnrollmentDate(enrollmentDate)
                .build();

        System.out.println(studentRecord);
    }
}




