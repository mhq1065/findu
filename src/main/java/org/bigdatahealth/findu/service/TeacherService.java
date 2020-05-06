package org.bigdatahealth.findu.service;


import org.bigdatahealth.findu.pojo.TeacherInformation;

import java.util.List;

public interface TeacherService {

    List<TeacherInformation> getTeachers(Integer start, Integer size, String keyword);
}
