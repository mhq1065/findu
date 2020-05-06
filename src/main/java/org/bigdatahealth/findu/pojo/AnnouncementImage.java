package org.bigdatahealth.findu.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AnnouncementImage {
    private Long imageId;

    private String imagePath;

    private Long announcementId;

    @Override
    public String toString() {
        return "AnnouncementImage{" +
                "imageId=" + imageId +
                ", imagePath='" + imagePath + '\'' +
                ", announcementId=" + announcementId +
                '}';
    }
}