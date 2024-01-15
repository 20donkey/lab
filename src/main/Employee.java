//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.text.DecimalFormat;

public class Employee {
  private String name;
  private String id;
  private double hours;
  private double payRate;

  /**
   * Constructor to initialize an Employee object.
   *
   * @param name    The name of the employee.
   * @param id      The employee ID.
   * @param payRate The pay rate per hour.
   */
  Employee(String name, String id, double payRate) {
    this.name = name;
    this.id = id;
    this.hours = 0.0;
    this.payRate = payRate;
  }

  /**
   * Adds the specified hours to the total hours worked for the week.
   *
   * @param hourWorked The hours to be added. Can be negative.
   *                   hours can not be negative.
   */

  public void addHoursWorked(double hourWorked) {
    this.hours += hourWorked;
    if (this.hours < 0.0) {
      System.out.print("Total hours worked can not be negative");
    }
  }

  /**
   * Resets the total hours worked for the week to zero.
   */
  public void resetHoursWorked() {
    this.hours = 0.0;
  }

  /**
   * Gets the total hours worked for the week.
   *
   * @return The total hours worked.
   */
  public double getHoursWorked() {
    return this.hours;
  }

  /**
   * @return A new Paycheck object.
   */
  public Paycheck getWeeklyCheck() {
    return new Paycheck(this.payRate, this.hours);
  }

  /**
   * @return A string representation of the Employee.
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");
    return "Name: " + this.name + "\nID: " + this.id + "\nPayment after taxes: $ "
            + df.format(getWeeklyCheck().getPayAfterTaxes());
  }
}

class Paycheck {
  private double rate;
  private double hoursWorked;

  /**
   * Constructor to initialize a Paycheck object.
   *
   * @param rate        The pay rate per hour.
   * @param hoursWorked The total hours worked for the week.
   */
  public Paycheck(double rate, double hoursWorked) {
    this.rate = rate;
    this.hoursWorked = hoursWorked;
  }

  /**
   * Calculates the total pay for the week.
   *
   * @return The total pay for the week.
   */
  public double getTotalPay() {
    double regularPay;
    double overtimePay = 0.0;

    if (this.hoursWorked <= 40) {
      regularPay = this.rate * this.hoursWorked;
    } else {
      regularPay = this.rate * 40;
      overtimePay = this.rate * 1.5 * (this.hoursWorked - 40);
    }

    return regularPay + overtimePay;
  }

  /**
   * Calculates the payment after deducting taxes based on the specified scale.
   *
   * @return The payment after taxes.
   */
  public double getPayAfterTaxes() {
    double totalPay = getTotalPay();

    if (totalPay < 400) {
      return totalPay - (totalPay * 0.1);
    } else {
      return totalPay - (totalPay * 0.15);
    }
  }

  /**
   * Returns a formatted string representation of the payment after taxes.
   *
   * @return A string representation of the payment after taxes.
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");
    return "Payment after taxes: $ " + df.format(getPayAfterTaxes());
  }
}