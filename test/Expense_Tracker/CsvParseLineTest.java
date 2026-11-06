package Expense_Tracker;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CsvParseLineTest {
    @Test
    public void testTC13SpecialFieldsRoundTrip() {
        List<String> actual = CsvUtil.parseLine(CsvUtil.toLine("2026-01-01", "comma, and \"quote\"", "9.99", "Food, drink"));
        assertEquals(4, actual.size());
        assertEquals("2026-01-01", actual.get(0));
        assertEquals("comma, and \"quote\"", actual.get(1));
        assertEquals("9.99", actual.get(2));
        assertEquals("Food, drink", actual.get(3));
    }

    @Test
    public void testTC14ParseThreePlainFields() {
        List<String> actual = CsvUtil.parseLine("a,b,c");
        assertEquals(3, actual.size());
        assertEquals("a", actual.get(0));
        assertEquals("b", actual.get(1));
        assertEquals("c", actual.get(2));
    }

    @Test
    public void testTC15ParseEmptyLine() {
        List<String> actual = CsvUtil.parseLine("");
        assertEquals(1, actual.size());
        assertEquals("", actual.get(0));
    }

    @Test
    public void testTC16ParseOneField() {
        List<String> actual = CsvUtil.parseLine("hello");
        assertEquals(1, actual.size());
        assertEquals("hello", actual.get(0));
    }

    @Test
    public void testTC33PlainFieldsRoundTrip() {
        List<String> actual = CsvUtil.parseLine(CsvUtil.toLine("2026-07-21", "plain", "1.0", "Cat"));
        assertEquals(4, actual.size());
        assertEquals("2026-07-21", actual.get(0));
        assertEquals("plain", actual.get(1));
        assertEquals("1.0", actual.get(2));
        assertEquals("Cat", actual.get(3));
    }

    @Test
    public void testTC36ParseLineWithOneComma() {
        List<String> actual = CsvUtil.parseLine(",");
        assertEquals(2, actual.size());
        assertEquals("", actual.get(0));
        assertEquals("", actual.get(1));
    }

    @Test
    public void testTC41QuotedFieldWithComma() {
        List<String> actual = CsvUtil.parseLine("a,\"b,c\",d");
        assertEquals(3, actual.size());
        assertEquals("a", actual.get(0));
        assertEquals("b,c", actual.get(1));
        assertEquals("d", actual.get(2));
    }

    @Test
    public void testTC43EscapedQuote() {
        List<String> actual = CsvUtil.parseLine(CsvUtil.toLine("b\""));
        assertEquals(1, actual.size());
        assertEquals("b\"", actual.get(0));
    }

    @Test
    public void testTC44QuotedAndTrailingEmptyFields() {
        List<String> actual = CsvUtil.parseLine("a,\"\",");
        assertEquals(3, actual.size());
        assertEquals("a", actual.get(0));
        assertEquals("", actual.get(1));
        assertEquals("", actual.get(2));
    }
}
