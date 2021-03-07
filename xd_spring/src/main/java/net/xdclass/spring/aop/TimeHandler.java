package net.xdclass.spring.aop;

import java.time.LocalDateTime;

//  crosscutting concern 横切关注点
public class TimeHandler {

    public void printBefore() {
        System.out.println("printBefore: " + LocalDateTime.now());
    }

    public void printAfter() {
        System.out.println("printAfter: " + LocalDateTime.now());
    }
}
