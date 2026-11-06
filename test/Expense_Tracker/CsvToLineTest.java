package Expense_Tracker;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CsvToLineTest {
    @Test
    public void testTC09OneFieldToLine() {
        assertEquals("hello", CsvUtil.toLine("hello"));
    }

    @Test
    public void testTC10MultipleFieldsToLine() {
        assertEquals("a,b,c", CsvUtil.toLine("a", "b", "c"));
    }

    @Test
    public void testTC11CommaInDescriptionToLine() {
        assertEquals("2026-01-01,\"lunch, coffee\",12.5,Food", CsvUtil.toLine(
                "2026-01-01", "lunch, coffee", "12.5", "Food"));
    }

    @Test
    public void testTC12QuotesInDescriptionToLine() {
        assertEquals("2026-01-01,\"say \"\"hi\"\"\",3.0,Misc", CsvUtil.toLine(
                "2026-01-01", "say \"hi\"", "3.0", "Misc"));
    }

    @Test
    public void testTC34NoFields() {
        assertEquals("", CsvUtil.toLine());
    }
}
