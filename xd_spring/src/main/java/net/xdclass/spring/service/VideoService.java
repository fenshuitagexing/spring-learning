package net.xdclass.spring.service;

import net.xdclass.spring.domain.Video;

public interface VideoService {

    int save(Video video);

    Video getById(int id);
}
