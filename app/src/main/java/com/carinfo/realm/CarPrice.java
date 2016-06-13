package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarPrice extends RealmObject {
    private int baseInvoice;
    private int baseMSRP;
    private int deliveryCharges;
    private int usedPrivateParty;
    private int usedTmvRetail;
    private int usedTradeIn;

    public boolean isEstimateTmv() {
        return estimateTmv;
    }

    public void setEstimateTmv(boolean estimateTmv) {
        this.estimateTmv = estimateTmv;
    }

    public int getUsedTradeIn() {
        return usedTradeIn;
    }

    public void setUsedTradeIn(int usedTradeIn) {
        this.usedTradeIn = usedTradeIn;
    }

    public int getUsedTmvRetail() {
        return usedTmvRetail;
    }

    public void setUsedTmvRetail(int usedTmvRetail) {
        this.usedTmvRetail = usedTmvRetail;
    }

    public int getUsedPrivateParty() {
        return usedPrivateParty;
    }

    public void setUsedPrivateParty(int usedPrivateParty) {
        this.usedPrivateParty = usedPrivateParty;
    }

    public int getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(int deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public int getBaseMSRP() {
        return baseMSRP;
    }

    public void setBaseMSRP(int baseMSRP) {
        this.baseMSRP = baseMSRP;
    }

    public int getBaseInvoice() {
        return baseInvoice;
    }

    public void setBaseInvoice(int baseInvoice) {
        this.baseInvoice = baseInvoice;
    }

    private boolean estimateTmv;
}
