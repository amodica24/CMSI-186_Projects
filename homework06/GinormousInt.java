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

   /// Some constants for other intrinsic data types
   ///  these can help speed up the math if they fit into the proper memory space

  // public static final GinormousInt MAX_INT  = new GinormousInt( new Integer( Integer.MAX_VALUE ).toString() );
  // public static final GinormousInt MIN_INT  = new GinormousInt( new Integer( Integer.MIN_VALUE ).toString() );
  // public static final GinormousInt MAX_LONG = new GinormousInt( new Long( Long.MAX_VALUE ).toString() );
  // public static final GinormousInt MIN_LONG = new GinormousInt( new Long( Long.MIN_VALUE ).toString() );

   private String sBigInt;
   private String reversed = "";
   private int [] intArray;
   private int ginoSign;

   private int ginoSize;
   int signMag = 0;
   private int comparison;
   private String sReverse;
   private String intString = "";
   private int [] result;
   private int tempInt = 0;
   private int carry = 0;
   private int index = 0;

   public GinormousInt( String value ) {
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
     for( int i = 0; i < intArray.length; i++) {
       sBigInt = sBigInt + Integer.toString( intArray[i] );
     }
     return sBigInt;
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

   public boolean equals(Object x) {
     if (sBigInt.length() == x.toString().length()){
       for (int i = 0; i < x.toString().length(); i++) {
         if (sBigInt.charAt(i) == x.toString().charAt(i)) {
           return true;
         }
         return false;
       }
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
     if (value.checkSign() == false && checkSign() == false){
       if (intArray.length > value.intArray.length) {
         return 1;
       } else if (intArray.length < value.intArray.length) {
         return -1;
       } else if (intArray.length == value.intArray.length) {
         for (int i = 0; i < intArray.length; i++) {
           if (intArray[i] > value.intArray[i]) {
             return 1;
           } else if (intArray[i] == value.intArray[i]){
             return 0;
           } else if (intArray[i] < value.intArray[i]) {
             return -1;
           }
         }
       }
     } else if (value.checkSign() == true && checkSign() == true) {
       if (intArray.length < value.intArray.length) {
         return 1;
       } else if (intArray.length > value.intArray.length) {
         return -1;
       } else if (intArray.length == value.intArray.length) {
         for (int i = 1; i < intArray.length + 1; i++) {
           if (intArray[i] < value.intArray[i]) {
             return 1;
           } else if (intArray[i] > value.intArray[i]) {
             return -1;
           } else if (intArray[i] == value.intArray[i]) {
             return 0;
           }
         }
       }
     }
     return -1;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a GinormousInt passed as argument to this GinormousInt using int array
   *  @param  value         GinormousInt to add to this
   *  @return GinormousInt that is the sum of the value of this GinormousInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt addInt( GinormousInt value ) {
     int newSize = Math.max(ginoSize, value.ginoSize);
     int [] digits = new int[newSize];

     for (int i = 0; i < newSize - 1; i++) {

       if (i < ginoSize ) {
         tempInt += intArray[i];
       }

       if (i < value.ginoSize) {
         tempInt += value.intArray[i];
       }

       tempInt += carry;

       digits[i] = tempInt % 10;
       carry = tempInt / 10;
     }

     if (carry == 1){
       digits[newSize - 1] = 1;
     } else {
       digits[newSize - 1] = 0;
     }

     return new GinormousInt(Arrays.toString(digits));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Method to subtract the value of a GinormousIntk passed as argument to this GinormousInt using bytes
  *  @param  value         GinormousInt to subtract from this
  *  @return GinormousInt that is the difference of the value of this GinormousInt and the one passed in
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

  public GinormousInt subtractInt( GinormousInt value ) {
    int [] digits = new int[ginoSize];
    for (int i = 0; i < ginoSize; i++) {
      int tempInt = intArray[i];
      if (i < value.ginoSize) {
      tempInt -= value.intArray[i];
      }
      tempInt -= carry;
      carry = 0;
      if (tempInt < 0) {
        tempInt = tempInt + 10;
        carry = 1;
      }
      digits[i] = tempInt;
    }
    return new GinormousInt(Arrays.toString(digits));
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
 }
