/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  Purpose       :  Provides a class defining methods for the Timer class
 *  @author       :  Anthony Modica
 *  Date written  :  2017-3-25
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  ExceptiosecondsJunque    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:         Reason for change/modification
 *           -----  ----------  ------------         ------------------------------------------------------
 *  @version 1.0.0  2017-03-25  Anthony Modica     Initial writing and release
 *  @version 2.0.0  2017-03-26  Anthony Modica     First Draft
 *  @version 2.1.0  2017-03-28  Anthony Modica     Second Draft
 *  @version 2.2.0  2017-04-02  Anthony Modica     Third Draft

 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Timer {
   double hours;
   double minutes;
   double seconds;
   double totalSeconds = 0;

   public Timer(double timeSlice) {
     seconds = 0;
     minutes = 0;
     hours = 0;
   }

   public double tick() {
     totalSeconds += 1;
     return totalSeconds;
   }

   /**
   *    Method to calculate the next tick from the time increment
   *    @return double-precision value of the current tick
   */

   public String timeToString() {
     double hours = totalSeconds / 3600.0;
     double timeJunque = totalSeconds % 3600;
     double minutes = timeJunque / 60.0;
     double seconds = timeJunque % 60;

     String hourString = Integer.toString( (int) hours );
     String minuteString = Integer.toString( (int) minutes );
     String secondString = Integer.toString( (int)seconds );

     return hourString + ":" + minuteString + ":" + secondString;
   }

 }
