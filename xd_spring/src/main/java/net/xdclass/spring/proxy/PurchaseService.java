package net.xdclass.spring.proxy;

public interface PurchaseService {

    String callBack(String orderNumber);


    int purchase(int userId, int productId);
}
