package com.example.demo;

public class WeiXinPay extends AbstractBasePay{
    @Override
    void channlPay() {
        System.out.println("微信pay");
    }

    boolean isCheckAuth() {
        return false;
    }

    String test(){
        return "我是  weixin";
    }
}
