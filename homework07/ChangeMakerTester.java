/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  ChangeMakerTester.java
 * Purpose    :  Program to test the ChangeMaker program
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

public class ChangeMakerTester {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        // Add more!
        // A few examples:
        // test_Euros(); // 1,2,5,10,20,50
        // test_SwissFrancs(); // 5,10,20,50 (NO 1 CENT COIN!)
        // test_Keckels(); // 7,3,29,15,53 (Made-up currency with non-standard denominations)

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(usaDenominations, 99);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

}