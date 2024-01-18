
import static org.testng.Assert.assertEquals;
import org.junit.Test;


/**
 * Test class for Employee and Paycheck classes.
 */
public class EmployeeTest {

  @Test
  public void testAddHoursWorked() {
    Employee employee = new Employee("Nian Liu", "12345", 15.0);

    // Add hours
    employee.addHoursWorked(20);
    assertEquals(20, employee.getHoursWorked(), 0);

  }

  @Test
  public void testResetHoursWorked() {
    Employee employee = new Employee("Nian Liu", "12345", 15.0);

    // Add hours
    employee.addHoursWorked(30);

    // Reset hours
    employee.resetHoursWorked();
    assertEquals(0, employee.getHoursWorked(), 0);
  }

  @Test
  public void testGetWeeklyCheck() {
    Employee employee = new Employee("Nian Liu", "12345", 15.0);

    // Add hours
    employee.addHoursWorked(35);

    // Get weekly check
    Paycheck paycheck = employee.getWeeklyCheck();
    assertEquals(525.0, paycheck.getTotalPay(), 0);
  }

  @Test
  public void testGetPayAfterTaxes() {
    Paycheck paycheck1 = new Paycheck(15.0, 35);
    assertEquals(525.0, paycheck1.getPayAfterTaxes(), 0);

    Paycheck paycheck2 = new Paycheck(15.0, 45);
    assertEquals(712.5, paycheck2.getPayAfterTaxes(), 0);
  }

  @Test
  public void testToString() {
    Employee employee = new Employee("Nikki", "NEU-007", 15.0);
    employee.addHoursWorked(35);

    String expected = "Name: Nikki\nID: NEU-007\nPayment after taxes: $ 416.50";
    assertEquals(expected, employee.toString());
  }
}

