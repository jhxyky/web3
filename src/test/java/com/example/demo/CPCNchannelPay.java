package com.example.demo;
public class CPCNchannelPay extends AbstractBasePay{

    @Override
    void channlPay() {
        System.out.println("中金支付");
    }

    boolean isCheckAuth() {
        return false;
    }
}

