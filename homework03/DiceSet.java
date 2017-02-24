/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Anthony Modica
 *  Date          :  2017-02-23
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbadice4, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2017-02-23  Anthony Modica  First Draft
 *  @version 1.1.0  2017-02-23  Anthony Modica  Second Draft
 

 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] dArray;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
     if (sides < 4 || count < 1 ) {
       throw new IllegalArgumentException();
     }
     dArray = new Die[count];
     for (int i = 0; i < count; i++) {
       dArray[i] = new Die(sides);
     }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     int sum = 0;
     for (int i = 0; i < dArray.length; i++) {
       sum += dArray[i].getValue();
     }
     return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     int sum = 0;
     for ( int i = 0; i < dArray.length; i++ ) {
       dArray[i].roll();
     }
   }
  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     if (dieIndex > dArray.length) {
       throw new IllegalArgumentException("Error, Index is out of range");
     }
     return dArray[dieIndex].roll();
  }
  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
     if (dieIndex > dArray.length) {
       throw new IllegalArgumentException("Error, Index is out of range");
     }
     return dArray[dieIndex].getValue();
  }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
     String result = "";
     for (int i = 0; i < dArray.length; i++) {
        result += "[" + dArray[i].getValue() + "]";
     }
     return result;
  }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
     String result = "";
     for (int i = 0; i < ds.dArray.length; i++) {
        result += "[" + ds.dArray[i].getValue() + "]";
     }
     return result;
  }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
     if (dArray.length == ds.dArray.length) {
        for (int i = 0; i < dArray.length; i++) {
           if (ds.dArray[i].getValue() == dArray[i].getValue()) {
              return true;
           }
        }
     }

     return false;
  }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
     DiceSet dice1 = new DiceSet (5,6);
     DiceSet dice2 = new DiceSet (5,8);
     DiceSet dice3 = new DiceSet (6,10);
     DiceSet dice4 = new DiceSet (6,4);

     dice1.roll();
     dice2.roll();
     dice3.roll();
     dice4.roll();

     System.out.println("dice1: " + dice1);
     System.out.println("Sum of dice1 set: " + dice1.sum());
     dice1.rollIndividual(0);
     System.out.println("Rolling individual dice1.. " + dice1);
     System.out.println("Identical values of dice1 and dice2 ? " + dice1.isIdentical(dice2));
     System.out.println( "String of dice1:" + dice1.toString());

     System.out.println("dice2: " + dice2 );
     System.out.println("Sum of dice set: " + dice2.sum());
     dice2.rollIndividual(1);
     System.out.println("Rolling individual dice.. " + dice2);
     System.out.println("Identical values of dice2 and dice3 ? " + dice2.isIdentical(dice2));
     System.out.println( "String of dice2:" + dice2.toString());

     System.out.println("dice3: " + dice3);
     System.out.println("Sum of dice set: " + dice3.sum());
     dice3.rollIndividual(4);
     System.out.println("Rolling individual dice.. " + dice3);
     System.out.println("Identical values of dice3 and dice4 ? " + dice3.isIdentical(dice4));
     System.out.println( "String of dice3:" + dice3.toString());

     System.out.println("dice4: " + dice4);
     System.out.println("Sum of dice set: " + dice4.sum());
     dice4.rollIndividual(2);
     System.out.println("Rolling individual dice.. " + dice4);
     System.out.println("Identical values of dice4 and dice2 ? " + dice4.isIdentical(dice2));
     System.out.println( "String of dice4:" + dice4.toString());
   }
 }
