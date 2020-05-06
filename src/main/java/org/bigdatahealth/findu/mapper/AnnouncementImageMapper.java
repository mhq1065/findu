package org.bigdatahealth.findu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.bigdatahealth.findu.pojo.AnnouncementImage;
import org.bigdatahealth.findu.pojo.AnnouncementImageExample;

public interface AnnouncementImageMapper {
    int countByExample(AnnouncementImageExample example);

    int deleteByExample(AnnouncementImageExample example);

    int deleteByPrimaryKey(Long imageId);

    int insert(AnnouncementImage record);

    int insertSelective(AnnouncementImage record);

    List<AnnouncementImage> selectByExample(AnnouncementImageExample example);

    AnnouncementImage selectByPrimaryKey(Long imageId);

    int updateByExampleSelective(@Param("record") AnnouncementImage record, @Param("example") AnnouncementImageExample example);

    int updateByExample(@Param("record") AnnouncementImage record, @Param("example") AnnouncementImageExample example);

    int updateByPrimaryKeySelective(AnnouncementImage record);

    int updateByPrimaryKey(AnnouncementImage record);
}