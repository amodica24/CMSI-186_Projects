/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Anthony Modica
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2017-03-15  Anthony Modica First draft of code
 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Clock {
   /**
    *  Class field definintions go here
    */
    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
    private static final double INVALID_ARGUMENT_VALUE = -1.0;
    private static final double MAXIMUM_DEGREE_VALUE = 360.0;
    private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
    private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
    private static final double MAXIMUM_TIME_SLICE_IN_SECONDS = 1800.0;

    private int hour;
    private int minutes;
    private double seconds;
    private double totalSeconds;

  /**
   *  Constructor goes here
   */
   public Clock( int HOUR, int MINUTE, double SECONDS) {

      if ( HOUR > 11 || HOUR <= INVALID_ARGUMENT_VALUE || MINUTE > 59 || MINUTE <= INVALID_ARGUMENT_VALUE || SECONDS > MAXIMUM_TIME_SLICE_IN_SECONDS || SECONDS <= INVALID_ARGUMENT_VALUE ) {
        throw new IllegalArgumentException("\n Invalid values");
      } else {
        this.hour = HOUR;
        this.minutes = MINUTE;
        this.seconds = SECONDS;

        if ( this.hour < 11 && this.minutes > 59) {
          int oneHour = this.minutes / 60;
          this.minutes = this.minutes % 60;
          this.hour += oneHour;

        if ( this.seconds > 60.0 ) {
          double roundSeconds = Math.round(this.seconds);
          int oneMinute = (int)roundSeconds / 60;
          this.seconds %= 60;
          this.minutes += oneMinute;

          }
        }
      }
      this.totalSeconds = 0.0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick(double timeSlices) {
     if (timeSlices >= DEFAULT_TIME_SLICE_IN_SECONDS ) {
       throw new IllegalArgumentException ("\n Invalid value");
     } else {
       totalSeconds += timeSlices;
     }
     return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
     double angleArg = Double.parseDouble( argValue );

     if ( argValue.length() == 0 ) {
       angleArg = MAXIMUM_DEGREE_VALUE;
       return MAXIMUM_DEGREE_VALUE;
     }

     if ( angleArg > 0 && angleArg < MAXIMUM_DEGREE_VALUE ) {
       return angleArg;
     }
     return INVALID_ARGUMENT_VALUE;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
     double timeArgValue = Double.parseDouble( argValue );

     if ( argValue.length() == 0 ) {
       timeArgValue = DEFAULT_TIME_SLICE_IN_SECONDS;
       return DEFAULT_TIME_SLICE_IN_SECONDS;
     }

     if ( timeArgValue > 0 && timeArgValue < MAXIMUM_DEGREE_VALUE ) {
       return timeArgValue;
     }
     return INVALID_ARGUMENT_VALUE;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
     return this.hour;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
     return this.minutes;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     double angleBetween = Math.abs(getMinuteHandAngle() - getHourHandAngle());
     if (angleBetween > 180 ) {
       return 360 - angleBetween;
     }
     return angleBetween;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
     return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
     return this.hour + " : " + this.minutes + " : " + this.totalSeconds;
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {


      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock(60, 60, 60 );
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
}
