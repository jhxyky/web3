package demo2;

public abstract class AbstractBasePay1 implements BasePay1{

    public final void mobilePay(){
        //是否检查
        if(isCheckAuth()){
            checkAuth();
        }
        channlPay();
    }

    abstract void channlPay();

    private void checkAuth() {
        System.out.println("父类执行检查");
    }

    boolean isCheckAuth() {
        return true;
    }


}
