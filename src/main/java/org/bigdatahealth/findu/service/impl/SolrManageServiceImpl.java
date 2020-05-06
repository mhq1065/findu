package org.bigdatahealth.findu.service.impl;


import org.bigdatahealth.findu.pojo.TeacherInformation;
import org.bigdatahealth.findu.service.SolrManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SolrManageServiceImpl implements SolrManageService {
    @Override
    public void addTeacherToSolr(List<TeacherInformation> list) {

    }

//    @Autowired
//    private SolrTemplate solrTemplate;
//
//    @Override
//    public void addTeacherToSolr(List<TeacherInformation> list) {
//        if(list != null){
//            if(solrTemplate!=null){
//                solrTemplate.saveBeans(list);
//                solrTemplate.commit();
//            }else{
//                System.out.println("null");
//            }
//        }
//    }
}
