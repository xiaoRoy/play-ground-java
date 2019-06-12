package com.learn.playground.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IndexOfFieldTest {

    @Test
    public void test_indexOf() {
        List<IndexOfField.RegistryGift> registryGifts = new ArrayList<>();
        IndexOfField.RegistryGift registryGift = new IndexOfField.RegistryGift("a");
        registryGifts.add(registryGift);
        IndexOfField.RegistryGift cashFundRegistryGift = new IndexOfField.CashFundRegistryGift("aa", "ca");
        registryGifts.add(cashFundRegistryGift);
        int registryGiftIndex = registryGifts.indexOf(registryGift);
        Assert.assertEquals(0, registryGiftIndex);
        int cashFundRegistryGiftIndex = registryGifts.indexOf(cashFundRegistryGift);
        Assert.assertEquals(1, cashFundRegistryGiftIndex);

    }
}