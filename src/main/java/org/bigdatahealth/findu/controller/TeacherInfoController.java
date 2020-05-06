package org.bigdatahealth.findu.controller;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.bigdatahealth.findu.mapper.TeacherInformationMapper;
import org.bigdatahealth.findu.pojo.TeacherInformation;
import org.bigdatahealth.findu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TeacherInfoController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherInformationMapper teacherInformationMapper;

//    @Autowired
//    private SolrTemplate solrTemplate;

    @RequestMapping("/teachersinfo")
    public List<TeacherInformation> teachers(@RequestParam Integer start, @RequestParam Integer size, String keyword){

        List<TeacherInformation> teachers = teacherService.getTeachers(start,size,keyword);
        return teachers;

    }


    @RequestMapping("/teachers")
    public List<TeacherInformation> list(){
        List<TeacherInformation> teacherInformationList = teacherInformationMapper.selectByExample(null);
        System.out.println(teacherInformationList);
        return teacherInformationList;
    }

    @Autowired
    private SolrClient solrClient;

    @RequestMapping("/clean")
    public void clean() throws IOException, SolrServerException {

        SolrQuery query = new SolrQuery("*:*");
        solrClient.deleteByQuery("*:*");
//        solrClient.deleteByQuery(query);
        solrClient.commit();
    }
    //
    @RequestMapping("/add")
    public void add() throws IOException, SolrServerException {
        List<TeacherInformation> teacherInformations = teacherInformationMapper.selectByExample(null);
        System.out.println(teacherInformations.size());
        solrClient.addBeans(teacherInformations);
        solrClient.commit();
    }
}
