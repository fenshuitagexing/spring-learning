package net.xdclass.spring.proxy;

public class StaticProxyPurchaseServiceImpl implements PurchaseService{

    private PurchaseService purchaseService;

    public StaticProxyPurchaseServiceImpl(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public String callBack(String orderNumber) {

        System.out.println("StaticProxyPurchaseServiceImpl callBack begin");
        String str = purchaseService.callBack(orderNumber);
        System.out.println("StaticProxyPurchaseServiceImpl callBack end");
        return str;
    }

    @Override
    public int purchase(int userId, int productId) {

        System.out.println("StaticProxyPurchaseServiceImpl purchase begin");
        int n = purchaseService.purchase(userId, productId);
        System.out.println("StaticProxyPurchaseServiceImpl purchase end");
        return n;
    }
}
