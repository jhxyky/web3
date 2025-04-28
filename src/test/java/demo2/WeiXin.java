package demo2;

public class WeiXin extends AbstractBasePay1{
    @Override
    void channlPay() {
        System.out.println("这里是微信");
    }

    boolean isCheckAuth() {
        return true;
    }

    public static void main(String[] args) {
        AbstractBasePay1 pay1 = new WeiXin();
        pay1.mobilePay();
    }

}
