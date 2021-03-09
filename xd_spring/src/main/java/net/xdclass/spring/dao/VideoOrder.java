package net.xdclass.spring.dao;

import net.xdclass.spring.domain.Video;

public class VideoOrder {

    private int id;
    private String orderNumber;
    private Video video;

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
        this.video = video;
    }
}
