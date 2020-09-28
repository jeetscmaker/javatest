package org.jk.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCurrencyConverter {
    private static final Double GBP_TO_USD = 1.26;
    private static final Double CHF_TO_USD = 1.04;
    private static final Double EURO_TO_USD = 1.12;

    @Test
    public void test_amountInEuro(){
        double amount = 56.5;

        double amtExpectedFromGBPtoEuro = (GBP_TO_USD / EURO_TO_USD) * amount;
        double amtActualFromGBPtoEuro = CurrencyConverter.amountInEuro(amount, "GBP");

        double amtExpectedFromCHFtoEuro = (CHF_TO_USD / EURO_TO_USD) * amount;
        double amtActualFromCHFtoEuro = CurrencyConverter.amountInEuro(amount, "CHF");

        double amtExpectedFromUSDtoEuro = (1 / EURO_TO_USD) * amount;
        double amtActualFromUSDtoEuro = CurrencyConverter.amountInEuro(amount, "USD");
    //   if given amount is in Euros
        double amtExpected = amount;
        double amtActual = CurrencyConverter.amountInEuro(amount, "EURO");
        assertEquals(amtExpectedFromGBPtoEuro, amtActualFromGBPtoEuro, 0.1);
        assertEquals(amtExpectedFromCHFtoEuro, amtActualFromCHFtoEuro, 0.1);
        assertEquals(amtExpectedFromUSDtoEuro, amtActualFromUSDtoEuro, 0.1);
        assertEquals(amtExpected, amtActual, 0.1);
    }
}
