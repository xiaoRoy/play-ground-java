package com.learn.basic.exception;

import sun.jvm.hotspot.debugger.AddressException;

public class CheckedExceptionShowcase {



    /*
    * Checked exception should be specify checked exception
    * You should throws or try catch the Checked exception
    * */
    private void first() throws AddressEmptyException {
        throw new AddressEmptyException();
    }

    private void second() {
        throw new IllegalArgumentException();
    }
}
