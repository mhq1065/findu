package org.bigdatahealth.findu.service;

import org.bigdatahealth.findu.pojo.Announcement;

import java.util.List;

public interface AnnouncementService {

    void insertAnnouncement(Announcement announcement, String[] imagesPath);

    List<Announcement> getAnnouncements(Integer start, Integer size, String keyword);

    Announcement getOneAnnouncement(Long id);

    void updateAnnouncement(Announcement announcement, String[] imagesPath);

    void deleteImage(Long announcementId, String imagePath);

    List<Announcement> getAnnouncement(Long userId);

    void deleteAnnouncement(Long proId);

    void updateState(Long announcementId, Integer state);
}
