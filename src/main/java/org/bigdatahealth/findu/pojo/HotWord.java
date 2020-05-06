package org.bigdatahealth.findu.pojo;

public class HotWord {
    private Long hotwordId;

    private String hotwordContent;

    private Long hotwordCount;

    public Long getHotwordId() {
        return hotwordId;
    }

    public void setHotwordId(Long hotwordId) {
        this.hotwordId = hotwordId;
    }

    public String getHotwordContent() {
        return hotwordContent;
    }

    public void setHotwordContent(String hotwordContent) {
        this.hotwordContent = hotwordContent == null ? null : hotwordContent.trim();
    }

    public Long getHotwordCount() {
        return hotwordCount;
    }

    public void setHotwordCount(Long hotwordCount) {
        this.hotwordCount = hotwordCount;
    }
}