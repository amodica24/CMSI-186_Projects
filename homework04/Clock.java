/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Anthony Modica
 *  Date written  :  2017-03-15
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
 *  @version 2.2.0  2017-03-15  Anthony Modica Second draft of code
 *  @version 2.3.0  2017-03-15  Anthony Modica Third draft of code
 *  @version 2.4.0  2017-03-15  Anthony Modica Fourth draft of code
 *  @version 2.5.0  2017-03-15  Anthony Modica fifth draft of code

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
    private double sumSeconds;
    private double hourHandAngle;
    private double minuteHandAngle;

  /**
   *  Constructor goes here
   */
   public Clock() {
     this.hour = 0;
     this.minutes = 0;
     this.seconds = 0.0;
     this.hourHandAngle = 0;
     this.minuteHandAngle = 0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick(double timeSlices) {
     if (timeSlices >= MAXIMUM_TIME_SLICE_IN_SECONDS ) {
       throw new IllegalArgumentException ("\n Invalid time value");
     } else {
       sumSeconds += timeSlices;
     }
     if (minutes >= 60) {
        this.hour += 1;
        this.minutes -= this.minutes;
     }
     this.seconds %= this.seconds;

     if (hour == 12) {
        this.hour = 0;
     }
     return sumSeconds;
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

     if ( angleArg < 0 || angleArg > MAXIMUM_DEGREE_VALUE ) {
       throw new IllegalArgumentException("Invalid angle value");
     }
     return angleArg;
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

     if (timeArgValue > MAXIMUM_TIME_SLICE_IN_SECONDS || timeArgValue < 0) {
        throw new IllegalArgumentException("Invalid time slice");
     }
     return timeArgValue;
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
     double minuteHandAngle = sumSeconds * MINUTE_HAND_DEGREES_PER_SECOND;
     if (minuteHandAngle > 360) {
       minuteHandAngle %= 360;
     }
     if ( minuteHandAngle > 180 ) {
       minuteHandAngle = 360 - minuteHandAngle;
     }
     return minuteHandAngle;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     double hourHandAngle = sumSeconds * HOUR_HAND_DEGREES_PER_SECOND;
     double angleBetween = Math.abs(hourHandAngle - minuteHandAngle);
     return angleBetween;
  }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
     return sumSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
    String stringHour = Integer.toString(this.hour);
    String stringMinute = Integer.toString(this.minutes);
    String stringSecond = Double.toString(this.sumSeconds);
     return stringHour + " : " + stringMinute + " : " + stringSecond;
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
      Clock clock1 = new Clock();
      System.out.println( "    New clock created: " + clock1.toString() );
      System.out.println( "\n    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock1.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }


      Clock clock2 = new Clock();
      clock2.tick( 60 );
      System.out.println( "\n    Testing new clock with tick( 60 )....." );
      System.out.print( "      Testing getHourHandAngle()..... expecting 0.5" );
      System.out.println( ( 0.5 == clock2.getHourHandAngle() ? " - got 0.5" : " - no joy") );
      System.out.print( "      Testing getMinuteHandAngle()..... expecting 6.0" );
      System.out.println( ( 6.0 == clock2.getMinuteHandAngle() ? " - got 6.0" : " - no joy") );
      System.out.print( "      Testing getHandAngle()..... expecting 5.5 degrees" );
      System.out.println( ( 5.5 == clock2.getHandAngle() ? " - got 5.5" : " - no joy") );

      Clock clock3 = new Clock();
      clock3.tick( 120 );
      System.out.println( "\n    Testing new clock with tick( 120 )....." );
      System.out.print( "      Testing getHourHandAngle()..... expecting 1.0" );
      System.out.println( ( 1.0 == clock3.getHourHandAngle() ? " - got 1.0" : " - no joy") );
      System.out.print( "      Testing getMinuteHandAngle()..... expecting 12.0" );
      System.out.println( ( 12.0 == clock3.getMinuteHandAngle() ? " - got 12.0" : " - no joy") );
      System.out.print( "      Testing getHandAngle()..... expecting 11.0 degrees" );
      System.out.println( ( 11.0 == clock3.getHandAngle() ? " - got 11.0" : " - no joy") );

      /**
       *  Checks validity of the Angle Arg
       */

      System.out.print( "    Sending '0 degrees', expecting double value 0.0 " );
      try { System.out.println( (0.0 == clock1.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending' 360 degrees', expecting double value 360.0  " );
      try { System.out.println( (360.0 == clock1.validateAngleArg( "360.0" )) ? " - got 360.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '362 degrees', expecting double value 362.0  " );
      try { System.out.println( (362.0 == clock1.validateAngleArg( "362.0" )) ? " - got 362.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '359 degrees', expecting double value 359.0  " );
      try { System.out.println( (359.0 == clock1.validateAngleArg( "359.0" )) ? " - got 359.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '200 degrees', expecting double value 200.0  " );
      try { System.out.println( (200.0 == clock1.validateAngleArg( "200.0" )) ? " - got 200.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '20 degrees', expecting double value 20.0  " );
      try { System.out.println( (20.0 == clock1.validateAngleArg( "20.0" )) ? " - got 20.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '  -1 degrees  ', expecting double value  -1.0  " );
      try { System.out.println( (-1.0 == clock1.validateAngleArg( "-1.0" )) ? " - got -1.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '  180 degrees  ', expecting double value  180.0  " );
      try { System.out.println( (180.0 == clock1.validateAngleArg( "180.0" )) ? " - got 180.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '  -10.5 degrees  ', expecting double value  -10.5  " );
      try { System.out.println( (-10.5 == clock1.validateAngleArg( "-10.5" )) ? " - got -10.5" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      /**
       *  Checks validity of the TimeSlice Arg
       */

      System.out.println( "\n    Testing validateTimeSliceArg()....");
      System.out.print( "    Sending ' 0.0 seconds ', expecting double value 0.0  " );
      try { System.out.println( (0.0 == clock1.validateTimeSliceArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending ' -1.0 seconds ', expecting double value  -1.0  " );
      try { System.out.println( (-1.0 == clock1.validateTimeSliceArg( "-1.0" )) ? " - got -1.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending ' 10.0 seconds ', expecting double value  10.0  " );
      try { System.out.println( (10.0 == clock1.validateTimeSliceArg( "10.0" )) ? " - got 10.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending ' 100.975 seconds ', expecting double value  100.975  " );
      try { System.out.println( (100.975 == clock1.validateTimeSliceArg( "100.975" )) ? " - got 100.975" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending ' 1800.0 seconds ', expecting double value  1800.0  " );
      try { System.out.println( (1800.0 == clock1.validateTimeSliceArg( "1800.0" )) ? " - got 1800.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending ' 1800.1 seconds ', expecting double value  1800.1  " );
      try { System.out.println( ( 1800.1 == clock1.validateTimeSliceArg( "1800.1" )) ? " - got 1800.1" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    }
  }
