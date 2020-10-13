package com.learn.playground.codelab;

import org.junit.Assert;
import org.junit.Test;

public class TestCurrencyTransformation {

    @Test
    public void test_transferFromAmountToText() {
        String result = CurrencyTransformation.transferFromAmountToText(32.55d);
        Assert.assertEquals("$32.55", result);
    }

    @Test
    public void test_transferFromAmountToText_threeDigits() {
        String result = CurrencyTransformation.transferFromAmountToText(32.554d);
        Assert.assertEquals("$32.55", result);
    }

    @Test
    public void test_transferFromAmountToTextIgnoreFraction() {
        String result = CurrencyTransformation.transferFromAmountToTextIgnoreFraction(44.454d);
        Assert.assertEquals("$44", result);
    }

    @Test
    public void test_transferFromTextToAmount() {
        double result = CurrencyTransformation.transferFromTextToAmount("$34.12");
        Assert.assertEquals(34.12d, result, 0.0d);
    }

    @Test
    public void test_transferFromTextToAmount_withParseException() {
        double result = CurrencyTransformation.transferFromTextToAmount("$abc");
        Assert.assertEquals(0.0d, result, 0.0d);
    }
}
