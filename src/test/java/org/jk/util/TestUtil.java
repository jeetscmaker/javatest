package org.jk.util;

import org.junit.Assert;
import org.junit.Test;

public class TestUtil {

    @Test
    public void test_isNotEmpty() {
        Assert.assertTrue(Util.isNotEmpty("John"));
        Assert.assertFalse(Util.isNotEmpty(""));
    }

    @Test
    public void test_amountInEuro(){
        double amount = 56.5;
        String currency = "GBP";
        double amtExpected = (1.26 / 1.12) * amount;
        double amtActual = Util.amountInEuro(amount, currency);
        Assert.assertEquals(amtExpected, amtActual, 0.1);
    }
}
