package net.xdclass.spring;

import net.xdclass.spring.domain.VideoDpl;
import net.xdclass.spring.domain.VideoOrder;
import net.xdclass.spring.domain.Video;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Video video = (Video) applicationContext.getBean("videoId");
        System.out.println("Video: " + video.getTitle());

        VideoOrder videoOrder = (VideoOrder) applicationContext.getBean("videoOrderId");
        System.out.println(videoOrder.getOrderNumber());
        System.out.println("VideoOrder: " + videoOrder.getVideo().getTitle());

        //testInjectionOfCollection(applicationContext);

        //testDuplication(applicationContext);

        ((ClassPathXmlApplicationContext)applicationContext).registerShutdownHook();
    }

    private static void testInjectionOfCollection(ApplicationContext applicationContext) {
        Video video = (Video) applicationContext.getBean("videoId");
        System.out.println(video.getChapterList());
        System.out.println(video.getVideoMap().entrySet());
    }

    private static void testDuplication(ApplicationContext applicationContext) {
        VideoDpl videoDpl = (VideoDpl) applicationContext.getBean("videoDplId");
        System.out.println(videoDpl.getSummary());
    }
}
