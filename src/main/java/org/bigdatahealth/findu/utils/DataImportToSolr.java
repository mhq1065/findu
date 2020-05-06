package org.bigdatahealth.findu.utils;


import org.bigdatahealth.findu.mapper.TeacherInformationMapper;
import org.bigdatahealth.findu.pojo.TeacherInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataImportToSolr {

    @Autowired
    private static TeacherInformationMapper teacherInformationMapper;

    @Autowired
    private static SolrTemplate solrTemplate;

    public static void importToSolr(){
        if (teacherInformationMapper != null) {
            List<TeacherInformation> teacherInformations = teacherInformationMapper.selectByExample(null);
            if (teacherInformations != null) {
                solrTemplate.saveBeans("collection1",teacherInformations);
                solrTemplate.commit("collection1");
            }
        }else {
            System.out.println("null");
        }

    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
        DataImportToSolr dataImportToSolr = (DataImportToSolr) applicationContext.getBean("dataImportToSolr");
        dataImportToSolr.importToSolr();

    }


}
