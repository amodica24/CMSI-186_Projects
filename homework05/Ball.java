/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class defining methods for the Ball class
 *  @author       :  Anthony Modica
 *  Date written  :  2017-3-25
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:         Reason for change/modification
 *           -----  ----------  ------------         ------------------------------------------------------
 *  @version 1.0.0  2017-03-25  Anthony Modica     Initial writing and release
 *  @version 2.0.0  2017-03-25  Anthony Modica     First Draft
 *  @version 2.1.0  2017-03-27  Anthony Modica     Second Draft
 *  @version 2.2.0  2017-03-25  Anthony Modica     Third Draft
 *  @version 2.3.0  2017-04-02  Anthony Modica     Fourth Draft
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Ball {

   /**
    *   Class field definitions
    */
    private static final double BALL_WEIGHT = 1.0;
    private static final double DEFAULT_TIME_SLICE_SECONDS = 1.0;

    private Timer timer;
    private double totalSeconds;
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;

    private double[] positionArray = new double[2];
    /**
    *    Constructor for ball
    */

    public Ball( double xPos, double yPos, double xSpeed, double ySpeed ) {
      xPosition = xPos;
      yPosition = yPos;
      xVelocity = xSpeed;
      yVelocity = ySpeed;
    }

    /**
    *   Method to calculate the final x position of the ball
    *   @return double-precision value of the position of the ball
    */

    public double getXVelocity() {
      if (xVelocity < 0) {
        xVelocity = xVelocity - (xVelocity * 0.01);
      } else {
        xVelocity = xVelocity + (xVelocity * 0.01);
      }
      return xVelocity;
    }

    public double getYVelocity() {
      if (yVelocity > 0) {
        yVelocity = yVelocity - (yVelocity * 0.01);
      } else {
        yVelocity = yVelocity + (yVelocity * 0.01);
      }
      return yVelocity;
    }

    public double getXPosition(){
      double xFinal = xPosition + getXVelocity();
      return xFinal;
    }

    public double getYPosition(){
      double yFinal = yPosition + getYVelocity();
      return yFinal;
    }

    public double[] getPosition() {
      positionArray[0] = xPosition + getXVelocity();
  		positionArray[1] = yPosition + getYVelocity();
      return positionArray;
    }

    /**

    *   Method to return a String representation of this position
    *   @return String value of the current position
    */

    public String positionToString() {
      return "(" + getXPosition() + "," + getYPosition() + ")";
    }

    public String velocityToString() {
      return "(" + getXVelocity() + "," + getYVelocity() + ")";
    }

   /**
   *  The main program starts here
   *
   *  Test to check methods
   */

   public static void main( String args[] ) {
     Timer timer1 = new Timer();
     Timer timer2 = new Timer();
     Timer timer3 = new Timer();

     System.out.println( "         Testing ball position at (-300, -300) velocity of (-10, 20) : " );
     Ball ball = new Ball(-300, -300, -10, 20 );
     System.out.println( "TIME: " + timer1.timeToString() );
     ball.getPosition();
     System.out.println("POSITION: " + ball.positionToString() );
     ball.getXVelocity();
     ball.getYVelocity();
     System.out.println("VELOCITY: " + ball.velocityToString() );

     timer1.tick();
     System.out.println( "TIME: " + timer1.timeToString() );
     ball.getPosition();
     System.out.println( "POSITION: " + ball.positionToString() );
     ball.getXVelocity();
     ball.getYVelocity();
     System.out.println( "VELOCITY: " + ball.velocityToString() );

     System.out.println( "         Testing ball position at (0, 0) velocity of (10, 2) : " );
     Ball ball2 = new Ball(0, 0, 10, 2 );
     System.out.println( "TIME: " + timer2.timeToString() );
     ball2.getPosition();
     System.out.println("POSITION: " + ball2.positionToString() );
     ball2.getXVelocity();
     ball2.getYVelocity();
     System.out.println("VELOCITY: " + ball2.velocityToString() );

     timer2.tick();
     System.out.println( "TIME: " + timer2.timeToString() );
     ball2.getPosition();
     System.out.println( "POSITION: " + ball2.positionToString() );
     ball2.getXVelocity();
     ball2.getYVelocity();
     System.out.println( "VELOCITY: " + ball2.velocityToString() );

     System.out.println( "         Testing ball position at (25, 10) velocity of (-5, 10) : " );
     Ball ball3 = new Ball(25, 10, -5, 10 );
     System.out.println( "TIME: " + timer3.timeToString() );
     ball3.getPosition();
     System.out.println("POSITION: " + ball3.positionToString() );
     ball3.getXVelocity();
     ball3.getYVelocity();
     System.out.println("VELOCITY: " + ball3.velocityToString() );

     timer3.tick();
     System.out.println( "TIME: " + timer3.timeToString() );
     ball3.getPosition();
     System.out.println( "POSITION: " + ball3.positionToString() );
     ball3.getXVelocity();
     ball3.getYVelocity();
     System.out.println( "VELOCITY: " + ball3.velocityToString() );
   }

 }
