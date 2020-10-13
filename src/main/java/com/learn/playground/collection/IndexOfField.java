package com.learn.playground.collection;

import java.util.Objects;

public class IndexOfField {

    static class RegistryGift {
        final private String id;

        public RegistryGift(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object another) {
            System.out.println("RegistryGift.equals");
            if (this == another) return true;
            if (another == null || getClass() != another.getClass()) return false;
            RegistryGift that = (RegistryGift) another;
            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            System.out.println("RegistryGift.hashCode");
            return Objects.hash(id);
        }
    }

    static class CashFundRegistryGift extends RegistryGift{

        final private String cashFundId;

        public CashFundRegistryGift(String id, String cashFundId) {
            super(id);
            this.cashFundId = cashFundId;
        }

        @Override
        public boolean equals(Object another) {
            System.out.println("CashFundRegistryGift.equals");
            if (this == another) return true;
            if (another == null || getClass() != another.getClass()) return false;
            if (!super.equals(another)) return false;
            CashFundRegistryGift that = (CashFundRegistryGift) another;
            return Objects.equals(cashFundId, that.cashFundId);
        }

        @Override
        public int hashCode() {
            System.out.println("CashFundRegistryGift.hashCode");
            return Objects.hash(super.hashCode(), cashFundId);
        }

      /*  @Override
        public boolean equals(Object another) {
            if (this == another) return true;
            if (!(another instanceof CashFundRegistryGift)) return false;
            if (!super.equals(another)) return false;
            CashFundRegistryGift that = (CashFundRegistryGift) another;
            return Objects.equals(cashFundId, that.cashFundId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), cashFundId);
        }*/
    }
}
