/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  GinormousInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  Anthony Modica
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 import java.util.Arrays;
 import java.lang.StringBuffer;


 public class GinormousInt {
 public static final GinormousInt ZERO     = new GinormousInt(  "0" );      /// Constant for "zero"
 public static final GinormousInt ONE      = new GinormousInt(  "1" );      /// Constant for "one"
 public static final GinormousInt TEN      = new GinormousInt( "10" );      /// Constant for "ten"

  // public static final GinormousInt MAX_INT  = new GinormousInt( new Integer( Integer.MAX_VALUE ).toString() );
  // public static final GinormousInt MIN_INT  = new GinormousInt( new Integer( Integer.MIN_VALUE ).toString() );
  // public static final GinormousInt MAX_LONG = new GinormousInt( new Long( Long.MAX_VALUE ).toString() );
  // public static final GinormousInt MIN_LONG = new GinormousInt( new Long( Long.MIN_VALUE ).toString() );

   private String sBigInt;
   private String reversed = "";
   private int [] intArray;
   private int currentIntLength;
   private int ginoSign;

   private int ginoSize;
   int signMag = 0;
   private int compare;
   private String sReverse;
   private String intString = "";
   private int [] result;

   public GinormousInt( String value ) {
     int index = 0;
     double parseValue = Double.parseDouble(value);
     if ( parseValue < 0) {
       signMag = 1;
       intArray = new int [value.length() - 1];
       for (int i = 1; i < value.length(); i ++) {
         intArray[index] = Character.getNumericValue(value.charAt(i));
         index++;
       }
     } else {
       intArray = new int [value.length()];
       for (int i = 0; i < value.length(); i ++) {
         intArray[index] = Character.getNumericValue(value.charAt(i));
         index++;
       }
     }
   }

   public String toString() {
     sBigInt = "";
     if( signMag == 1 ) {
       sBigInt = "-";
     }
     for( int i = 1; i < intArray.length; i++) {
       sBigInt = sBigInt + Integer.toString( intArray[i] );
     }
     return sBigInt;
   }

   public static String toString( int[] args ) {
     String sGino = "";
     for (int i = 0; i < args.length; i++) {
       sGino = sGino + Integer.toString( args[i]);
     }
     return sGino;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check the sign of the GinormousInt
   *  @param  value     GinormousInt to compare to this
   *  @return boolean  that is true if the value is negative and false if the value is positive
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  public boolean checkSign() {
    if (signMag == 1) {
      return true;
    }
    return false;
  }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a GinormousInt passed as argument is equal to this GinormousInt
   *  @param  value     GinormousInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
   *        also using the java String "equals()" method -- THAT was easy, too..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public boolean equals( GinormousInt x ) {
     if (x instanceof GinormousInt) {
       GinormousInt g = (GinormousInt) x;
       if (g.ginoSize != this.ginoSize) {
         return false;
       }
       return this.compareTo(g) == 0;
     }
     return false;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a GinormousInt passed as argument to this GinormousInt
   *  @param  value  GinormousInt to add to this
   *  @return int   that is one of neg/0/pos if this GinormousInt precedes/equals/follows the argument
   *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method
   *        THAT was easy.....
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo(GinormousInt value){
     if (checkSign() == false && value.checkSign() == true) {
       compare = 1;
     } else {
       return -1;
     }

     if( value.toString().length() == toString().length() ) {
       for( int i = 0; i < toString().length(); i++ ) {
         if( toString().charAt(i) > value.toString().charAt(i) ) {
           compare = 1;
         } else if( toString().charAt(i) < value.toString().charAt(i) ){
           compare = -1;
         } else {
           compare = 0;
         }
       }
     } else if( value.toString().length() > toString().length() ) {
       compare = -1;
     } else {
       compare = 1;
     }
     return compare;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this GinormousInt
   *  @return GinormousInt that is the reverse of the value of this GinormousInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public GinormousInt reverser(){
     StringBuffer sReverse = new StringBuffer(toString());
     reversed = sReverse.reverse().toString();
     return new GinormousInt(reversed);
   }
   public GinormousInt changeSign() {
     ginoSign = intArray[intArray.length - 1] = intArray[intArray.length - 1] * -1;
     return this;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a GinormousInt passed as argument to this GinormousInt using int array
   *  @param  value         GinormousInt to add to this
   *  @return GinormousInt that is the sum of the value of this GinormousInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt addInt( GinormousInt value ) {
     throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Method to subtract the value of a GinormousIntk passed as argument to this GinormousInt using bytes
  *  @param  gint         GinormousInt to subtract from this
  *  @return GinormousInt that is the difference of the value of this GinormousInt and the one passed in
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

  public GinormousInt subtractInt( GinormousInt value ) {
    throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a GinormousInt passed as argument to this GinormousInt
   *  @param  value         GinormousInt to multiply by this
   *  @return GinormousInt that is the product of the value of this GinormousInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public GinormousInt multiply( GinormousInt value ) {
     throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this GinormousInt by the GinormousInt passed as argument
   *  @param  value         GinormousInt to divide this by
   *  @return GinormousInt that is the dividend of this GinormousInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt divide( GinormousInt value ) {
     throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

   public static void main( String[] args ) {
     System.out.println( "\n  Hello, world, from the GinormousInt program!!\n" );
     System.out.println( "\n   You should run your tests from the GinormousIntTester...\n" );
     GinormousInt x = new GinormousInt("-10");
     GinormousInt y = new GinormousInt("10");
     System.out.println(x.reverser("10"));
     System.out.println(y.compareTo(x));
     System.out.println(y.addInt(x));




   }
 }
