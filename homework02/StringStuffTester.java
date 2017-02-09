/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuffTester.java
 *  Purpose       :  A test harness file for testing out the methods in the "StringStuff.java" class
 *  Author        :  Anthony Modica
 *  Date          :  2017-02-08
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  TEMPLATE FILE ONLY: Your job is to fill in as many test cases as you think are needed
 *                   to thoroughly and completely test your StringStuff class.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2017-02-08  Anthony Modica First draft of code
 *  @version 3.0.0  2017-02-08  Anthony Modica Second draft of code
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) {

      test_containsVowel();      // 5 tests
      test_isPalindrome();       // 5 tests
      test_evensOnly();          // 5 tests
      test_oddsOnly();           // 5 tests
      test_evensOnlyNoDupes();   // 5 tests
      test_oddsOnlyNoDupes();    // 5 tests
      test_reverse();            // 5 tests
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {

      System.out.println( " Five Tests For containsVowel():" );

      System.out.print( "   Test for Computer Science: " );
      try { System.out.println( StringStuff.containsVowel("Computer Science") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for iOS: " );
      try { System.out.println( StringStuff.containsVowel("iOS") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for lynx: " );
      try { System.out.println( StringStuff.containsVowel("lynx") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for gym: " );
      try { System.out.println( StringStuff.containsVowel("gym") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for ABCD1234: " );
      try { System.out.println( StringStuff.containsVowel("ABCD1234") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the isPalindrome method
   */

   public static void test_isPalindrome() {

      System.out.println( " Five Tests For isPalindrome():" );

      System.out.print( "   Test for racecar: " );
      try { System.out.println( StringStuff.isPalindrome("racecar") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for rac e car: " );
      try { System.out.println( StringStuff.isPalindrome("rac e car") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for solutomaattimittaamotulos: " );
      try { System.out.println( StringStuff.isPalindrome("solutomaattimittaamotulos") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for LMU: " );
      try { System.out.println( StringStuff.isPalindrome("LMU") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for 1234: " );
      try { System.out.println( StringStuff.isPalindrome("ABCD1234") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }
   }


  /**
   * test method to test out the operation of the evensOnly method
   */

   public static void test_evensOnly() {

     System.out.println( " Five Tests For evensOnly():" );

     System.out.print( "   Test for REHEARSAL: " );
     try { System.out.println(StringStuff.evensOnly("REHEARSAL")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for xylophones: " );
     try { System.out.println( StringStuff.evensOnly("xylophones")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for woof: " );
     try { System.out.println( StringStuff.evensOnly("woof")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for abcdefghijklmnopqrstuvwxyz: " );
     try { System.out.println( StringStuff.evensOnly("abcdefghijklmnopqrstuvwxyz")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for ABCD1234: " );
     try { System.out.println( StringStuff.evensOnly("ABCD1234")); }
     catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {
     System.out.println( " Five Tests For oddsOnly():" );

     System.out.print( "   Test for REHEARSAL: " );
     try { System.out.println(StringStuff.oddsOnly("REHEARSAL")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for xylophones: " );
     try { System.out.println( StringStuff.oddsOnly("xylophones")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for woof: " );
     try { System.out.println( StringStuff.oddsOnly("woof")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for abcdefghijklmnopqrstuvwxyz: " );
     try { System.out.println( StringStuff.oddsOnly("abcdefghijklmnopqrstuvwxyz")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for ABCD1234: " );
     try { System.out.println( StringStuff.oddsOnly("ABCD1234")); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {

     System.out.println( " Five Tests For evensOnlyNoDupes():" );

     System.out.print( "   Test for REHEARSAL: " );
     try { System.out.println(StringStuff.evensOnlyNoDupes("REHEARSAL")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for xylophones: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("xylophones")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for woof: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("woof")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for abba abba abba: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("abba abba abba")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for blah blah blah: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("blah blah blah")); }
     catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {
     System.out.println( " Five Tests For oddsOnlyNoDupes():" );

     System.out.print( "   Test for REHEARSAL: " );
     try { System.out.println(StringStuff.oddsOnlyNoDupes("REHEARSAL")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for xylophones: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("xylophones")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for woof: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("woof")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for babababa: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("babababa")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for amanaplanacanalpanama: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("amanaplanacanalpanama")); }
     catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {
     System.out.println( " Five Tests For reverse():" );

     System.out.print( "   Test for computer science: " );
     try { System.out.println( StringStuff.reverse("computer science")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for woof: " );
     try { System.out.println( StringStuff.reverse("woof")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for 1234: " );
     try { System.out.println( StringStuff.reverse("1234")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for xylophones: " );
     try { System.out.println( StringStuff.reverse("xylophones")); }
     catch( Exception e ) { System.out.println ( false ); }

     System.out.print( "   Test for ABCD1234: " );
     try { System.out.println( StringStuff.reverse("ABCD1234")); }
     catch( Exception e ) { System.out.println ( false ); }
   }
}
