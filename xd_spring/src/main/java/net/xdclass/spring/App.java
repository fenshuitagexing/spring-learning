package net.xdclass.spring;

import net.xdclass.spring.dao.VideoOrder;
import net.xdclass.spring.domain.Video;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Video video = (Video) applicationContext.getBean("videoId");
        System.out.println(video.getTitle());

        VideoOrder videoOrder = (VideoOrder) applicationContext.getBean("videoOrderId");
        System.out.println(videoOrder.getOrderNumber());
        System.out.println(videoOrder.getVideo().getTitle());


    }
}
