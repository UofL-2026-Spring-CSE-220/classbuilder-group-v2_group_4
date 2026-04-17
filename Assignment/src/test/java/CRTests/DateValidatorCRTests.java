package CRTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.coolschool.utilities.dateutils.DateValidator;
import edu.coolschool.utilities.dateutils.MonthsEnum;

public class DateValidatorCRTests {

    @Test
    @DisplayName("isLeapYear returns true for leap years")
    public void testIsLeapYearTrue() {
        assertTrue(DateValidator.isLeapYear(2000));
        assertTrue(DateValidator.isLeapYear(2024));
        assertTrue(DateValidator.isLeapYear(2020));
    }

    @Test
    @DisplayName("isLeapYear returns false for non-leap years")
    public void testIsLeapYearFalse() {
        assertFalse(DateValidator.isLeapYear(1900));
        assertFalse(DateValidator.isLeapYear(2023));
        assertFalse(DateValidator.isLeapYear(2100));
    }

    @Test
    @DisplayName("getDaysInMonth returns correct days for 31-day months")
    public void testGetDaysInMonth31() {
        assertEquals(31, DateValidator.getDaysInMonth(1, 2023));
        assertEquals(31, DateValidator.getDaysInMonth(3, 2023));
        assertEquals(31, DateValidator.getDaysInMonth(5, 2023));
        assertEquals(31, DateValidator.getDaysInMonth(7, 2023));
        assertEquals(31, DateValidator.getDaysInMonth(8, 2023));
        assertEquals(31, DateValidator.getDaysInMonth(10, 2023));
        assertEquals(31, DateValidator.getDaysInMonth(12, 2023));
    }

    @Test
    @DisplayName("getDaysInMonth returns correct days for 30-day months")
    public void testGetDaysInMonth30() {
        assertEquals(30, DateValidator.getDaysInMonth(4, 2023));
        assertEquals(30, DateValidator.getDaysInMonth(6, 2023));
        assertEquals(30, DateValidator.getDaysInMonth(9, 2023));
        assertEquals(30, DateValidator.getDaysInMonth(11, 2023));
    }

    @Test
    @DisplayName("getDaysInMonth returns 28 for February in non-leap year")
    public void testGetDaysInMonthFebNonLeap() {
        assertEquals(28, DateValidator.getDaysInMonth(2, 2023));
    }

    @Test
    @DisplayName("getDaysInMonth returns 29 for February in leap year")
    public void testGetDaysInMonthFebLeap() {
        assertEquals(29, DateValidator.getDaysInMonth(2, 2024));
    }

    @Test
    @DisplayName("getDaysInMonth throws IllegalArgumentException for invalid month")
    public void testGetDaysInMonthInvalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> DateValidator.getDaysInMonth(13, 2023));
        assertThrows(IllegalArgumentException.class, () -> DateValidator.getDaysInMonth(0, 2023));
    }

    @Test
    @DisplayName("getDaysInMonth with MonthsEnum works correctly")
    public void testGetDaysInMonthEnum() {
        assertEquals(31, DateValidator.getDaysInMonth(MonthsEnum.JANUARY, 2023));
        assertEquals(29, DateValidator.getDaysInMonth(MonthsEnum.FEBRUARY, 2024));
        assertEquals(30, DateValidator.getDaysInMonth(MonthsEnum.APRIL, 2023));
    }

    @Test
    @DisplayName("isValidDate returns true for valid dates")
    public void testIsValidDateTrue() {
        assertTrue(DateValidator.isValidDate(15, 9, 2026));
        assertTrue(DateValidator.isValidDate(29, 2, 2020));
        assertTrue(DateValidator.isValidDate(31, 12, 2023));
        assertTrue(DateValidator.isValidDate(30, 4, 2023));
    }

    @Test
    @DisplayName("isValidDate returns false for invalid dates")
    public void testIsValidDateFalse() {
        assertFalse(DateValidator.isValidDate(31, 4, 2023)); // April has 30
        assertFalse(DateValidator.isValidDate(29, 2, 2023)); // Not leap
        assertFalse(DateValidator.isValidDate(32, 1, 2023)); // Day too high
        assertFalse(DateValidator.isValidDate(0, 1, 2023)); // Day too low
        assertFalse(DateValidator.isValidDate(1, 13, 2023)); // Month too high
        assertFalse(DateValidator.isValidDate(1, 0, 2023)); // Month too low
    }

    @Test
    @DisplayName("isValidDate with MonthsEnum works correctly")
    public void testIsValidDateEnum() {
        assertTrue(DateValidator.isValidDate(15, MonthsEnum.SEPTEMBER, 2026));
        assertFalse(DateValidator.isValidDate(31, MonthsEnum.APRIL, 2023));
    }
}
