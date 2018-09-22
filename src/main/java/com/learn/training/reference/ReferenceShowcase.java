package com.learn.training.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ReferenceShowcase {

    private static final int FIVE_MB = 1024 * 1024 * 5;

    public static void main(String[] args) {


        new ReferenceShowcase().softReference();
        while (true);
    }


    /*
     * JVM arguments
     * -Xms20m -Xmx20m
     * */
    private void strongReference() {
        List<byte[]> temp = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            byte[] bytes = new byte[FIVE_MB];
            temp.add(bytes);
        }
    }

    private List<SoftReference<byte[]>> softReference() {
        List<SoftReference<byte[]>> softReferenceList = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            byte[] bytes = new byte[FIVE_MB];
            SoftReference<byte[]> softReference = new SoftReference<>(bytes);
            softReferenceList.add(softReference);
        }
        ////todo unit test
        softReferenceList.forEach(softReference -> System.out.println(softReference.get()));
        return softReferenceList;
    }

    private List<WeakReference<byte[]>> weakReference() {
        List<WeakReference<byte[]>> weakReferenceList = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            byte[] bytes = new byte[FIVE_MB];
            WeakReference<byte[]> softReference = new WeakReference<>(bytes);
            weakReferenceList.add(softReference);
        }
        ////todo unit test
        weakReferenceList.forEach(weakReference -> System.out.println(weakReference.get()));
        return weakReferenceList;
    }

    private PhantomReference<?> phantomReference(){
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), referenceQueue);
        return phantomReference;
    }
}
