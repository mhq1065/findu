package org.bigdatahealth.findu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.bigdatahealth.findu.pojo.StudentAuth;
import org.bigdatahealth.findu.pojo.StudentAuthExample;

public interface StudentAuthMapper {
    int countByExample(StudentAuthExample example);

    int deleteByExample(StudentAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentAuth record);

    int insertSelective(StudentAuth record);

    List<StudentAuth> selectByExample(StudentAuthExample example);

    StudentAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentAuth record, @Param("example") StudentAuthExample example);

    int updateByExample(@Param("record") StudentAuth record, @Param("example") StudentAuthExample example);

    int updateByPrimaryKeySelective(StudentAuth record);

    int updateByPrimaryKey(StudentAuth record);
}