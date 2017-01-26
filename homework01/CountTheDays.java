/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Provides a tester class to test the methods in the CalendarStuff class
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Anthony Modica
 *  Date          :  <01-26-17>
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework01 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  There are (presently) fifty-four separate tests. Successful (unsuccessful) tests
 *                   output an appropriate message for pass/fail.  If an exception is thrown, the test
 *                   simply outputs "false".  Tests for main() are not included; your professor and the
 *                   lab assistants can test that separately, using the daysBetween() tests, below.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-13  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2017-01-25  Anthony Modica First draft code
 *  @version 3.0.0  2017-01-26  Anthony Modica Second draft code
 */
 public class CountTheDays {
   public static void main( String args[] ) {
     long month1 = Long.parseLong(args[0]);
     long day1 = Long.parseLong(args[1]);
     long year1 = Long.parseLong(args[2]);
     long month2 = Long.parseLong(args[3]);
     long day2 = Long.parseLong(args[4]);
     long year2 = Long.parseLong(args[5]);

     if (CalendarStuff.isValidDate(month1, day1, year1) == false || CalendarStuff.isValidDate(month2, day2, year2) == false) {
       System.out.println("\n You entered an invalid date");
     } else {
       System.out.println(CalendarStuff.daysBetween(month1, day1, year1, month2, day2, year2));
     }
   }
 }
