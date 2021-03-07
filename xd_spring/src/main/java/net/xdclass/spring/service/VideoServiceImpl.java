package net.xdclass.spring.service;

import net.xdclass.spring.domain.Video;

public class VideoServiceImpl implements VideoService{
    @Override
    public int save(Video video) {

        System.out.println("Save Video");
        return 1;
    }

    @Override
    public Video getById(int id) {

        System.out.println("Get Video Info");
        return new Video();
    }
}
