package org.bigdatahealth.findu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.bigdatahealth.findu.pojo.TeacherInformation;
import org.bigdatahealth.findu.pojo.TeacherInformationExample;

public interface TeacherInformationMapper {
    int countByExample(TeacherInformationExample example);

    int deleteByExample(TeacherInformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherInformation record);

    int insertSelective(TeacherInformation record);

    List<TeacherInformation> selectByExample(TeacherInformationExample example);

    TeacherInformation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherInformation record, @Param("example") TeacherInformationExample example);

    int updateByExample(@Param("record") TeacherInformation record, @Param("example") TeacherInformationExample example);

    int updateByPrimaryKeySelective(TeacherInformation record);

    int updateByPrimaryKey(TeacherInformation record);
}