/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringFunctions.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  Anthony Modica
 *  Date          :  2017-02-09
 *  Description   :  The user inputs a string and the command prompt outputs the result of the six programs.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 *  @version 2.0.0  2017-02-09  Anthony Modica First draft
 *  @version 2.0.0  2017-02-09  Anthony Modica Second draftpublic class StringFunctions {
 */

  public static void main( String [] args ) {

  System.out.println( " Enter a string to find the following tests:" );

  System.out.println( "containsVowel" );
  System.out.println( "isPalindrome" );
  System.out.println( "evensOnly" );
  System.out.println( "oddsOnly" );
  System.out.println( "evensOnlyNoDupes" );
  System.out.println( "oddsOnlyNoDupes" );
  System.out.println( "reverse" );

  String input = new String ( "" );

    for( int i = 0; i < args.length; i++ ){
      input = input.concat( args[0] );

        System.out.println(StringStuff.containsVowel( input ));

        System.out.println(StringStuff.isPalindrome( input ));

        System.out.println(StringStuff.evensOnly( input ));

        System.out.println(StringStuff.oddsOnly( input ));

        System.out.println(StringStuff.evensOnlyNoDupes( input ));

        System.out.println(StringStuff.oddsOnlyNoDupes( input ));

        System.out.println(StringStuff.reverse( input ));
      }
    }
}
