package net.xdclass.spring.proxy;

public class PurchaseServiceImpl implements PurchaseService{
    @Override
    public String callBack(String orderNumber) {

        System.out.println("Invoke PurchaseServiceImpl callBack()");
        return orderNumber;
    }

    @Override
    public int purchase(int userId, int productId) {

        System.out.println("Invoke PurchaseServiceImpl purchase()");
        return 0;
    }
}
