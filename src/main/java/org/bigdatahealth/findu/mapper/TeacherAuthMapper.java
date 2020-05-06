package org.bigdatahealth.findu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.bigdatahealth.findu.pojo.TeacherAuth;
import org.bigdatahealth.findu.pojo.TeacherAuthExample;

public interface TeacherAuthMapper {
    int countByExample(TeacherAuthExample example);

    int deleteByExample(TeacherAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherAuth record);

    int insertSelective(TeacherAuth record);

    List<TeacherAuth> selectByExampleWithBLOBs(TeacherAuthExample example);

    List<TeacherAuth> selectByExample(TeacherAuthExample example);

    TeacherAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherAuth record, @Param("example") TeacherAuthExample example);

    int updateByExampleWithBLOBs(@Param("record") TeacherAuth record, @Param("example") TeacherAuthExample example);

    int updateByExample(@Param("record") TeacherAuth record, @Param("example") TeacherAuthExample example);

    int updateByPrimaryKeySelective(TeacherAuth record);

    int updateByPrimaryKeyWithBLOBs(TeacherAuth record);

    int updateByPrimaryKey(TeacherAuth record);
}