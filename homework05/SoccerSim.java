/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
  *  Purpose       :  Provides a SoccerSim defining methods for the SoccerSim class
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
 *  @version 2.0.0  2017-03-28  Anthony Modica     First Draft
 *  @version 2.1.0  2017-03-29  Anthony Modica     Second Draft
 *  @version 2.2.0  2017-03-30  Anthony Modica     Third Draft
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class SoccerSim {

  public double numBalls;
  public double timeSlice;

  public Ball[] ballArray;
  public Timer timer;
  public double[] collision;
  public double xDistance;
  public double yDistance;
  public double xPOLE;
  public double yPOLE;
  public double distance;
  public double POLE;


  public static final double DEFAULT_X_POLE = 50;
  public static final double DEFAULT_Y_POLE = -10;

  public static Ball[] handleArguments(String[] args) {
    Ball[] ballArray = new Ball[(int) args.length/4 ];
    for (int i = 0; i <= ballArray.length - 1 ; i++) {
      double xPos = Double.parseDouble(args[(i*4)]);
      double yPos = Double.parseDouble(args[(i*4)+1]);
      double xVel = Double.parseDouble(args[(i*4)+2]);
      double yVel = Double.parseDouble(args[(i*4)+3]);
      ballArray[i] = new Ball(xPos,yPos,xVel,yVel);
    }
    return ballArray;
  }

  public SoccerSim() {
    numBalls = 0;
    timeSlice = 0;
    ballArray = null;
  }

  public void newBall( String args[] ) {

    if( 2 > args.length ) {
      System.out.println( "   You must enter at least 4 arguments\n ");
      System.exit( 1 );
    }

    if( 4 <= args.length ) {
      numBalls = Math.floor( args.length / 4 );
      ballArray = new Ball[(int)numBalls];
      timer = new Timer(1);
      System.out.println( timer.toString() );
      int j = 0;
      for( int i = 0; i < args.length - 1; i += 4 ) {
        double xPosition1 = Double.parseDouble( args[0 + i] );
        double yPosition1 = Double.parseDouble( args[1 + i] );
        double xVelocity1 = Double.parseDouble( args[2 + i] );
        double yVelocity1 = Double.parseDouble( args[3 + i] );
        ballArray[j] = new Ball( xPosition1, yPosition1, xVelocity1, yVelocity1 );
        ballArray[j].getPosition();
        ballArray[j].getXPosition();
        ballArray[j].getYPosition();
        System.out.println( j + ballArray[j].positionToString() + ballArray[j].velocityToString() );
        j++;
      }
    }
  }

  public double poleX() {
    return DEFAULT_X_POLE;
  }

  public double poleY() {
    return DEFAULT_Y_POLE;
  }

  public void bArray(){
    for (int i = 0; i<numBalls; i++){
      ballArray[i].getPosition();
      ballArray[i].getXVelocity();
      ballArray[i].getYVelocity();
    }
  }

  public boolean collisionDetection(){
    for (int i = 0; i<= numBalls-2; i++){
      for (int j = 1 + i; j<= numBalls-1; j++){
        double ballX = ballArray[0].getPosition()[0] - ballArray[1].getPosition()[0];
        double distX = Math.pow(ballX ,2);
        double ballY = ballArray[0].getPosition()[1] - ballArray[1].getPosition()[1];
        double distY = Math.pow(ballY,2);
        distance = Math.sqrt(distX + distY);
        if (distance <=((9)/12)){
          System.out.println("COLLISION");
          return true;
        }
        return false;
      }
    }
    return false;
  }


  public static void main( String args[] ){
    Timer timer = new Timer(1);
    SoccerSim soccer = new SoccerSim();

    while (soccer.collisionDetection()){
      soccer.bArray();
      timer.tick();
      if (soccer.collisionDetection() == true){
        break;
      }
      continue;
    }
  }
}
