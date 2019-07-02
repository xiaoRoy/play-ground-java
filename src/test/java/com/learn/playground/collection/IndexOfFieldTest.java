package com.learn.playground.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

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

    @Test
    public void test_indexOf_equals() {
        List<IndexOfField.RegistryGift> registryGifts = new ArrayList<>();
        IndexOfField.RegistryGift registryGiftSpy = Mockito.spy(new IndexOfField.RegistryGift("a"));
        registryGifts.add(registryGiftSpy);
        IndexOfField.CashFundRegistryGift cashFundRegistryGiftSpy = Mockito.spy(new IndexOfField.CashFundRegistryGift("aa", "ca"));
        registryGifts.add(cashFundRegistryGiftSpy);

        registryGifts.indexOf(registryGiftSpy);
        Mockito.verify(registryGiftSpy).equals(Mockito.any());

        registryGifts.indexOf(cashFundRegistryGiftSpy);
        Mockito.verify(cashFundRegistryGiftSpy).equals(Mockito.any());
    }
}