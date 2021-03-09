package net.xdclass.spring.service;

import net.xdclass.spring.config.PropertiesConfig;
import net.xdclass.spring.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 默认名称是类名的小写
@Component("videoServiceImpl")
public class VideoServiceImpl implements VideoService{
    @Override
    public int save(Video video) {

        System.out.println("Save Video");
        return 1;
    }

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Override
    public Video getById(int id) {

        System.out.println("Get Video Info");

        System.out.println(propertiesConfig.getHost());

        return new Video();
    }
}
