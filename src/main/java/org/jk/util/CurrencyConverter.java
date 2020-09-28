package org.jk.util;

public class CurrencyConverter {
    private static final Double GBP_TO_USD = 1.26;
    private static final Double CHF_TO_USD = 1.04;
    private static final Double EURO_TO_USD = 1.12;

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
                amount = (1 / EURO_TO_USD) * am;
                break;
            case "GBP":
                amount = (GBP_TO_USD / EURO_TO_USD) * am;
                break;
            case "CHF":
                amount = (CHF_TO_USD / EURO_TO_USD) * am;
                break;
            /* considering that the default amount is EURO. */
            default:
                amount = am;
        }
        return amount;
    }
}
