package net.xdclass.spring.proxy;

public class ProxyTest {

    public static void main(String[] args) {

//        PurchaseService purchaseService = new StaticProxyPurchaseServiceImpl(new PurchaseServiceImpl());
//        purchaseService.purchase(685, 26596859);
        
        JdkProxy jdkProxy = new JdkProxy();
        PurchaseService purchaseServiceProxy = (PurchaseService) jdkProxy.newProxyInstance(new PurchaseServiceImpl());
        purchaseServiceProxy.callBack("feoiwfjewoiejfe");

        CglibProxy cglibProxy = new CglibProxy();
        PurchaseService purchaseService = (PurchaseService) cglibProxy.newProxyInstance(new PurchaseServiceImpl());
        purchaseService.callBack("feoiwfjewoiejfe");
    }
}