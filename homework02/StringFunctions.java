public class StringFunctions {
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
      input = input.concat( args[i] );

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
