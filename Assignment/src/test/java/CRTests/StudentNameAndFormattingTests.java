package CRTests;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentNameAndFormattingTests {

    private DateRecord validDate;

    @BeforeEach
    public void setUp() {
        validDate = new DateRecord.Builder()
                .setDay(1)
                .setMonth(MonthsEnum.JANUARY)
                .setYear(2000)
                .build();
    }

    @Test
    @DisplayName("Validation: Null First Name should throw IllegalArgumentException")
    public void nullFirstNameTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setFirstName(null)
                    .setLastName("Knorr")
                    .setDateOfBirth(validDate)
                    .setCountryOfResidence(CountriesEnum.US)
                    .setCountryOfBirth(CountriesEnum.US)
                    .build();
        });
    }

    @Test
    @DisplayName("Validation: Student ID Length Check")
    public void studentIDValidationTest() {
        PersonInfo student = new PersonInfo.Builder()
                .setFirstName("Branden")
                .setLastName("Knorr")
                .setDateOfBirth(validDate)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        assertDoesNotThrow(() -> {
            new StudentRecord.Builder()
                    .setStudentInfo(student)
                    .setStudentID("123456789")
                    .setEnrollmentDate(validDate)
                    .build();
        });
    }
}