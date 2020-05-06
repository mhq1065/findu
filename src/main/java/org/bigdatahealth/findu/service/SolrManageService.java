package org.bigdatahealth.findu.service;



import org.bigdatahealth.findu.pojo.TeacherInformation;

import java.util.List;

public interface SolrManageService {

    void addTeacherToSolr(List<TeacherInformation> list);
}
