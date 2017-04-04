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
 *  @version 2.3.0  2017-04-03  Anthony Modica     Fifth Draft
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Ball {

   /**
    *   Class field definitions
    */
    private static final double DEFAULT_TIME_SLICE_SECONDS = 1.0;

    private Timer timer;
    private double totalSeconds;
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;
    private double xFinal;
    private double yFinal;

    private double[] positionArray = new double[2];

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
      xVelocity = 1 - (xVelocity * 0.01);
      return xVelocity;
    }

    public double getYVelocity() {
      yVelocity = 1 - (yVelocity * 0.01);
      return yVelocity;
    }

    public double getXPosition(){
      xPosition += xVelocity;
      return xPosition;
    }

    public double getYPosition(){
      yPosition += yVelocity;
      return yPosition;
    }

    public double[] getPosition() {
      positionArray[0] = xPosition + getXVelocity();
      positionArray[1] = yPosition + getYVelocity();
      return positionArray;
    }

    public String positionToString() {
      return "(" + getXPosition() + "," + getYPosition() + ")";
    }

    public String velocityToString() {
      return "(" + getXVelocity() + "," + getYVelocity() + ")";
    }

   public static void main( String args[] ) {
     Timer timer1 = new Timer(1);
     Timer timer2 = new Timer(10);
     Timer timer3 = new Timer(5);
     Timer timer4 = new Timer(3);
     Timer timer5 = new Timer(1);
     Timer timer6 = new Timer(1);


     System.out.println( "         Testing ball position at (-300, -300) velocity of (-10, 20) : " );
     Ball ball1 = new Ball(-300, -300, -10, 20 );
     System.out.println( "TIME: " + timer1.timeToString() );
     ball1.getPosition();
     System.out.println("POSITION: " + ball1.positionToString() );
     ball1.getXVelocity();
     ball1.getYVelocity();
     System.out.println("VELOCITY: " + ball1.velocityToString() );

     timer1.tick();
     System.out.println( "TIME: " + timer1.timeToString() );
     ball1.getPosition();
     System.out.println( "POSITION: " + ball1.positionToString() );
     ball1.getXVelocity();
     ball1.getYVelocity();
     System.out.println( "VELOCITY: " + ball1.velocityToString() );

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

     System.out.println( "         Testing ball position at (25, 10) velocity of (-5, -10) : " );
     Ball ball3 = new Ball(25, 10, -5, -10 );
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


     System.out.println( "         Testing ball position at (-10, 40) velocity of (-3, 20) : " );
     Ball ball4 = new Ball(-10, 40, -3, 20 );
     System.out.println( "TIME: " + timer4.timeToString() );
     ball4.getPosition();
     System.out.println("POSITION: " + ball4.positionToString() );
     ball4.getXVelocity();
     ball4.getYVelocity();
     System.out.println("VELOCITY: " + ball4.velocityToString() );

     timer4.tick();
     System.out.println( "TIME: " + timer4.timeToString() );
     ball4.getPosition();
     System.out.println( "POSITION: " + ball4.positionToString() );
     ball4.getXVelocity();
     ball4.getYVelocity();
     System.out.println( "VELOCITY: " + ball4.velocityToString() );

     System.out.println( "         Testing ball position at (-30, -30) velocity of (-10, -15) : " );
     Ball ball5 = new Ball(-30, -30, -10, -15 );
     System.out.println( "TIME: " + timer5.timeToString() );
     ball5.getPosition();
     System.out.println("POSITION: " + ball5.positionToString() );
     ball5.getXVelocity();
     ball5.getYVelocity();
     System.out.println("VELOCITY: " + ball5.velocityToString() );

     timer5.tick();
     System.out.println( "TIME: " + timer5.timeToString() );
     ball5.getPosition();
     System.out.println( "POSITION: " + ball5.positionToString() );
     ball5.getXVelocity();
     ball5.getYVelocity();
     System.out.println( "VELOCITY: " + ball5.velocityToString() );

     System.out.println( "         Testing ball position at (30, 30) velocity of (10, 20) : " );
     Ball ball6 = new Ball(30, 30, 10, 20 );
     System.out.println( "TIME: " + timer6.timeToString() );
     ball6.getPosition();
     System.out.println("POSITION: " + ball6.positionToString() );
     ball6.getXVelocity();
     ball6.getYVelocity();
     System.out.println("VELOCITY: " + ball6.velocityToString() );

     timer6.tick();
     System.out.println( "TIME: " + timer6.timeToString() );
     ball6.getPosition();
     System.out.println( "POSITION: " + ball6.positionToString() );
     ball6.getXVelocity();
     ball6.getYVelocity();
     System.out.println( "VELOCITY: " + ball6.velocityToString() );
   }
 }
