package Expense_Tracker;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExpenseObjectTest {
    @Test
    public void testTC17ExpenseGetters() {
        Expense expense = new Expense("2026-10-15", "Groceries", 49.99, "Food");

        assertEquals("2026-10-15", expense.getDate());
        assertEquals("Groceries", expense.getDescription());
        assertTrue(49.99 == expense.getAmount());
        assertEquals("Food", expense.getCategory());
    }

    @Test
    public void testTC18SmallPositiveAmount() {
        Expense expense = new Expense("2026-10-15", "Tip", 0.01, "Food");
        assertTrue(0.01 == expense.getAmount());
    }

    @Test
    public void testTC19NullCategory() {
        Expense expense = new Expense("2026-10-15", "Test", 25.0, null);
        String actual = expense.getCategory();
        assertTrue(actual == null);
    }

    @Test
    public void testTC20ZeroAmount() {
        Expense expense = new Expense("2026-10-15", "Free", 0.0, "Gift");
        assertTrue(0.0 == expense.getAmount());
    }

    @Test
    public void testTC21NegativeAmount() {
        Expense expense = new Expense("2026-10-15", "Refund", -5.00, "Return");
        assertTrue(-5.00 == expense.getAmount());
    }

    @Test
    public void testTC32ExpenseToString() {
        Expense expense = new Expense("2026-10-15", "Groceries", 49.99, "Food");
        assertEquals("Expense(date=2026-10-15, description=Groceries, amount=49.99, category=Food)", expense.toString());
    }
}
