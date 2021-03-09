package net.xdclass.spring;

import net.xdclass.spring.config.AnnotationConfig;
import net.xdclass.spring.domain.VideoDpl;
import net.xdclass.spring.domain.VideoOrder;
import net.xdclass.spring.domain.Video;
import net.xdclass.spring.service.VideoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

//        // Test for Configuration through annotations
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//
//        // 扫描指定的包及其子包
//        context.scan("net.xdclass");
//
//        // 完成
//        context.refresh();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        VideoService videoService = (VideoService) context.getBean("videoServiceImpl");
        videoService.getById(2);
        //videoService.save(new Video());

        VideoOrder videoOrder = (VideoOrder) context.getBean("videoOrder");


        // Test for Configuration through XML files

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Video video = (Video) applicationContext.getBean("videoId");
//        System.out.println("Video: " + video.getTitle());
//
//        VideoOrder videoOrder = (VideoOrder) applicationContext.getBean("videoOrderId");
//        System.out.println(videoOrder.getOrderNumber());
//        System.out.println("VideoOrder: " + videoOrder.getVideo().getTitle());
//
//        //testInjectionOfCollection(applicationContext);
//
//        //testDuplication(applicationContext);
//
//        ((ClassPathXmlApplicationContext)applicationContext).registerShutdownHook();
//
//        testAop(applicationContext);
    }

    private static void testAop(ApplicationContext applicationContext) {
        VideoService videoService = (VideoService) applicationContext.getBean("videoService");
        videoService.save(new Video());
        videoService.getById(33);
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
