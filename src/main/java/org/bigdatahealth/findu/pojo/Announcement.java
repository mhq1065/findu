package org.bigdatahealth.findu.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Announcement {
    private Long proId;

    private String proName;

    private String proProfile;

    private Date proStart;

    private String proDuration;

    private Date enrollDeadline;

    private String enrollRequirements;

    private String recruitPlace;

    private String recruitType;

    private String researchArea;

    private String proReward;

    private String erollWay;

    private Long userId;

    private Integer state;

    private List<AnnouncementImage> images;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProProfile() {
        return proProfile;
    }

    public void setProProfile(String proProfile) {
        this.proProfile = proProfile == null ? null : proProfile.trim();
    }

    public Date getProStart() {
        return proStart;
    }

    public void setProStart(Date proStart) {
        this.proStart = proStart;
    }

    public String getProDuration() {
        return proDuration;
    }

    public void setProDuration(String proDuration) {
        this.proDuration = proDuration == null ? null : proDuration.trim();
    }

    public Date getEnrollDeadline() {
        return enrollDeadline;
    }

    public void setEnrollDeadline(Date enrollDeadline) {
        this.enrollDeadline = enrollDeadline;
    }

    public String getEnrollRequirements() {
        return enrollRequirements;
    }

    public void setEnrollRequirements(String enrollRequirements) {
        this.enrollRequirements = enrollRequirements == null ? null : enrollRequirements.trim();
    }

    public String getRecruitPlace() {
        return recruitPlace;
    }

    public void setRecruitPlace(String recruitPlace) {
        this.recruitPlace = recruitPlace == null ? null : recruitPlace.trim();
    }

    public String getRecruitType() {
        return recruitType;
    }

    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType == null ? null : recruitType.trim();
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea == null ? null : researchArea.trim();
    }

    public String getProReward() {
        return proReward;
    }

    public void setProReward(String proReward) {
        this.proReward = proReward == null ? null : proReward.trim();
    }

    public String getErollWay() {
        return erollWay;
    }

    public void setErollWay(String erollWay) {
        this.erollWay = erollWay == null ? null : erollWay.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}