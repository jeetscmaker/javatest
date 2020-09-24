package org.jk.util;

public class Util {
    public static Boolean isNotEmpty(String st) {
        return (st!=null && !st.equals(""));
    }

    /**
     * Convert the amount in Euros from the given currency.
     *
     * @param am       amount to be converted
     * @param currency the currency such as USD, GBP etc.
     * @return the converted amount in Euro
     */
    public static double amountInEuro(double am, String currency) {
        double amount;
        switch (currency) {
            case "USD":
                amount = (1 / 1.12) * am;
                break;
            case "GBP":
                amount = (1.26 / 1.12) * am;
                break;
            case "CHF":
                amount = (1.04 / 1.12) * am;
                break;
            /* considering that the default amount is EURO. */
            default:
                amount = am;
        }
        return amount;
    }
}
