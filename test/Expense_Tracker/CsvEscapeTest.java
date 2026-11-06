package Expense_Tracker;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CsvEscapeTest {
    @Test
    public void testTC01PlainText() {
        assertEquals("hello", CsvUtil.escape("hello"));
    }

    @Test
    public void testTC02FieldWithComma() {
        assertEquals("\"a,b\"", CsvUtil.escape("a,b"));
    }

    @Test
    public void testTC03FieldWithQuotes() {
        assertEquals("\"say \"\"hi\"\"\"", CsvUtil.escape("say \"hi\""));
    }

    @Test
    public void testTC04FieldWithNewline() {
        assertEquals("\"line1\nline2\"", CsvUtil.escape("line1\nline2"));
    }

    @Test
    public void testTC05FieldWithCarriageReturn() {
        assertEquals("\"line1\rline2\"", CsvUtil.escape("line1\rline2"));
    }

    @Test
    public void testTC06NullField() {
        assertEquals("", CsvUtil.escape(null));
    }

    @Test
    public void testTC07EmptyField() {
        assertEquals("", CsvUtil.escape(""));
    }

    @Test
    public void testTC08FieldWithCommaAndQuotes() {
        assertEquals("\"a,\"\"b\"\"\"", CsvUtil.escape("a,\"b\""));
    }
}
