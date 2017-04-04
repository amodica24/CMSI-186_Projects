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
 *  @version 2.3.0  2017-04-03  Anthony Modica     Fourth Draft

 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Timer {
   static double hours;
   static double minutes;
   static double seconds;
   double totalSeconds = 0;
   double timeSlice;

   public Timer(double timeSeconds) {
     seconds = 0;
     minutes = 0;
     hours = 0;
     timeSlice = timeSeconds;
   }

   public double tick() {
     totalSeconds += timeSlice;
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

   public static void main (String args[]) {
     System.out.println("Testing timer with a time slice of 1 second");
     Timer timer = new Timer(1);
     timer.tick();
     System.out.println(  timer.timeToString());
     timer.tick();
     System.out.println(  timer.timeToString());
     timer.tick();
     System.out.println(  timer.timeToString());
     timer.tick();
     System.out.println(  timer.timeToString());
     timer.tick();
     System.out.println(  timer.timeToString());

     System.out.println("Testing timer with a time slice of 10 seconds");
     Timer timer2 = new Timer(10);
     timer2.tick();
     System.out.println( timer2.timeToString());
     timer2.tick();
     System.out.println( timer2.timeToString());
     timer2.tick();
     System.out.println(  timer2.timeToString());
     timer2.tick();
     System.out.println(  timer2.timeToString());
     timer2.tick();
     System.out.println(  timer2.timeToString());
     timer2.tick();
     System.out.println(  timer2.timeToString());
     timer2.tick();
     System.out.println(  timer2.timeToString());

      System.out.println("Testing timer with a time slice of 30 seconds");
      Timer timer3 = new Timer(30);
      timer3.tick();
      System.out.println(  timer3.timeToString());
      timer3.tick();
      System.out.println(  timer3.timeToString());
      timer3.tick();
      System.out.println(  timer3.timeToString());
      timer3.tick();
      System.out.println(  timer3.timeToString());
      timer3.tick();
      System.out.println(  timer3.timeToString());
      timer3.tick();
      System.out.println(  timer3.timeToString());
      timer3.tick();      System.out.println(  timer3.timeToString());

      System.out.println("Testing timer with a time slice of 60 seconds");
      Timer timer4 = new Timer(60);
      timer4.tick();
      System.out.println(timer4.timeToString());
      timer4.tick();
      System.out.println( timer4.timeToString());
      timer4.tick();
      System.out.println(timer4.timeToString());
      timer4.tick();
      System.out.println(timer4.timeToString());
      timer4.tick();
      System.out.println(timer4.timeToString());
      timer4.tick();
      System.out.println(timer4.timeToString());
      timer4.tick();
      System.out.println(timer4.timeToString());

      System.out.println("Testing timer with a time slice of 100 seconds");
      Timer timer5 = new Timer(100);
      timer5.tick();
      System.out.println(timer5.timeToString());
      timer5.tick();
      System.out.println(timer5.timeToString());
      timer5.tick();
      System.out.println(timer5.timeToString());
      timer5.tick();
      System.out.println(timer5.timeToString());
      timer5.tick();
      System.out.println(  timer5.timeToString());
      timer5.tick();
      System.out.println(  timer5.timeToString());
      timer5.tick();
      System.out.println(  timer5.timeToString());

      System.out.println("Testing timer with a time slice of 120 seconds");
      Timer timer6 = new Timer(120);
      timer6.tick();
      System.out.println(  timer6.timeToString());
      timer6.tick();
      System.out.println(  timer6.timeToString());
      timer6.tick();
      System.out.println(  timer6.timeToString());
      timer6.tick();
      System.out.println(  timer6.timeToString());
      timer6.tick();
      System.out.println(  timer6.timeToString());
      timer6.tick();
      System.out.println(  timer6.timeToString());
      timer6.tick();
      System.out.println(  timer6.timeToString());
    }
  }
