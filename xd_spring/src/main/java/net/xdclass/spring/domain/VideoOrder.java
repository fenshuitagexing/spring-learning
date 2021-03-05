package net.xdclass.spring.domain;

import net.xdclass.spring.domain.Video;

public class VideoOrder {

    private int id;
    private String orderNumber;
    private Video video;

    public VideoOrder() {
        System.out.println("Invoke the no-arg constructor of VideoOrder");
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", video=" + video +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        System.out.println("Invoke setVideo() of VideoOrder");
        this.video = video;
    }
}
