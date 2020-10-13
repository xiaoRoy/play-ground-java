package com.learn.playground.codelab;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class CurrencyTransformation {

    public static String transferFromAmountToText(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(amount);
    }

    public static String transferFromAmountToTextIgnoreFraction(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        formatter.setRoundingMode(RoundingMode.DOWN);
        formatter.setMaximumFractionDigits(0);
        return formatter.format(amount);
    }

    public static double transferFromTextToAmount(String text) {
        double result;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        try {
            result = formatter.parse(text).doubleValue();
        } catch (ParseException exception) {
            result = 0.0d;
        }
        return result;
    }
}
