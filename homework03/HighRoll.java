/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  High Roll Game where the user chooses from six options in rolling a dice. The mission is to get the
 *                   highest score.
 *  Author        :  Anthony Modica
 *  Date          :  2017-02-23
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-2-23  Anthony Modica First draft
 *  @version 1.2.0  2017-2-23  Anthony Modica Second draft
 


 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {


     private static StringBuffer sb = null;

        public static void main( String[] args ) {
          System.out.println( "\n   Welcome to the High Roll Game! Choose one of the options below:\n" );
          BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
          DiceSet ds = new DiceSet( 6, 6 );

          int HighScore = 0;

          while( true ) {
            System.out.println( " Option 1: ROLL ALL THE DICE" );
            System.out.println( " Option 2: ROLL A SINGLE DIE" );
            System.out.println( " Option 3: CALCULATE THE SCORE FOR THIS SET" );
            System.out.println( " Option 4: SAVE THIS SCORE AS HIGH SCORE" );
            System.out.println( " Option 5: DISPLAY THE HIGH SCORE" );
            System.out.println( " Option 6: ENTER 'Q' TO QUIT THE PROGRAM \n" );

            System.out.print( ">> " );
            String inputLine = null;

            try {
              inputLine = input.readLine();
              if( 0 == inputLine.length() ) {
                System.out.println("You did not enter a number between 1 and 6!");
                continue;
              } else if (inputLine.charAt(0) == '1') {
                ds.roll();
                System.out.println("You rolled " + ds.toString());
              }
              if (inputLine.charAt(0) == '2') {
              } else if (inputLine.charAt(0) == '2') {
                System.out.println( "\n Enter a number between 1 and 6:" );
                System.out.print(   "\n >>" );

                if (inputLine.charAt(0) == '1') {
                  ds.rollIndividual(0);
                } else if (inputLine.charAt(0) == '2') {
                 ds.rollIndividual(1);
                } else if (inputLine.charAt(0) == '3') {
                 ds.rollIndividual(2);
                } else if (inputLine.charAt(0) == '4') {
                 ds.rollIndividual(3);
                } else if (inputLine.charAt(0) == '5') {
                 ds.rollIndividual(4);
                } else if (inputLine.charAt(0) == '6') {
                 ds.rollIndividual(5);
                } else System.out.println( "\n You did not enter a number between 1 and 6!" );

                continue;

              } else if (inputLine.charAt(0) == '3') {
                System.out.println( "Your score of your dice is: " + ds.sum() + "\n" );
              } else if (inputLine.charAt(0) == '4') {
                System.out.println( "Your score is saved" + "\n" );
              } else if (inputLine.charAt(0) == '5') {
                HighScore = ds.sum();
                System.out.println( "Your high score is: " + HighScore + "\n" );
              } else if (inputLine.charAt(0) == 'Q') {
                System.out.println("\n Game Over! \n ");
                break;
              }
            }
            catch( IOException ioe ) {
              System.out.println( "IOException" );
            }
          }
        }
      }
