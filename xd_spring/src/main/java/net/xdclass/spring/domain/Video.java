package net.xdclass.spring.domain;

import java.util.List;
import java.util.Map;

public class Video {

    private int id;
    private String title;

    // Testing the injection of List and Map
    private List<String> chapterList;
    private Map<Integer, String> videoMap;

    public void init() {
        System.out.println("Invoke init() of Video class");
    }

    public void destroy() {
        System.out.println("Invoke destroy() of Video class");
    }

    public List<String> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<String> chapterList) {
        this.chapterList = chapterList;
    }

    public Map<Integer, String> getVideoMap() {
        return videoMap;
    }

    public void setVideoMap(Map<Integer, String> videoMap) {
        this.videoMap = videoMap;
    }

    public Video() {
        System.out.println("Invoke the no-arg constructor of Video");
    }

    public Video(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title=" + title +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
