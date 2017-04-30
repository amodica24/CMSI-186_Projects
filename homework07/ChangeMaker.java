/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  ChangeMaker.java
 * Purpose    :  Program to represent the optimal nunber if coins.
 * @author    :  Anthony Modica
 * Date       :  2017-04-29
 * Description:
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  Anthony Modica Initial draft
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ChangeMaker {
  // Javadoc*.java

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }

            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

   /**
    * A method to find the optimal number, or least number of coins for the given amount.
    * @param    denominations   array   containing each argument starting with args[0]
    * @param    amount          int     the amount of cents
    * @return                   array
    */

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
      Tuple[][] table = new Tuple[denominations.length][amount + 1];
      int count = denominations.length;
      int [] e = new int[count];

      for(int i = 0; i < denominations.length; i ++) {
        for (int j = 0; j < amount + 1; j++){
          if (j < denominations[i] ) {
            if (j == 0) {
              for (int k = 0; k < denominations.length; k++){
                e[k] = 0;
              }
              table[i][j] = new Tuple(e);
            } else {
              table[i][j] = Tuple.IMPOSSIBLE;
            }
          } else {
            for (int k = 0; k < denominations.length; k++){
              e[k] = 0;
            }
            e[i] = 1;
            table[i][j] = new Tuple(e);

            if (table[i][j - denominations[i]].equals(Tuple.IMPOSSIBLE)) {
              table[i][j] = Tuple.IMPOSSIBLE;
            } else {
              table[i][j] = table[i][j].add(table[i][ j - denominations[i] ] );
            }
            if (i != 0){
              if (denominations[i] <= j ){
                if (table[i - 1 ][j] != Tuple.IMPOSSIBLE){
                  if ( (table[i][j].total()  < (table[i][j - 1]).total()) ) {
                    table[i][j] = table[i][j];
                  } else {
                    table[i][j] = table[i][j - 1];
                  }

                } else {
                  table[i][j] = Tuple.IMPOSSIBLE;
                }
              } else {
                table[i][j] = Tuple.IMPOSSIBLE;
              }
            }
          }
          System.out.println(table[i][j]);
        }
      }
      return table[denominations.length-1][amount];
    }

    private static void printUsage() {
        System.out.println("Usage: java ChangeMaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }
}
