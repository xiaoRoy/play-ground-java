package com.learn.basic.comparison;

import java.util.Objects;

public abstract class Comparison {

    private static final Comparison LESS = new InactiveComparison(-1);
    private static final Comparison GREATER = new InactiveComparison(1);

    Comparison() {
        //hide it
    }

    public static Comparison start() {
        return ACTIVE;
    }

    private static final Comparison ACTIVE = new Comparison() {
        @Override
        public Comparison compare(Comparable one, Comparable another) {
            Objects.equals(1, 12);
            return classify(one.compareTo(another));
        }

        @Override
        public int result() {
            return 0;
        }

        Comparison classify(int result) {
            return (result < 0) ? LESS : (result > 0) ? GREATER : ACTIVE;
        }
    };


    public abstract Comparison compare(Comparable<?> one, Comparable<?> another);

    public abstract int result();
}
