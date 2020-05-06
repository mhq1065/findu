package org.bigdatahealth.findu.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.bigdatahealth.findu.mapper.HotWordMapper;
import org.bigdatahealth.findu.mapper.TeacherInformationMapper;
import org.bigdatahealth.findu.pojo.HotWord;
import org.bigdatahealth.findu.pojo.HotWordExample;
import org.bigdatahealth.findu.pojo.TeacherInformation;
import org.bigdatahealth.findu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherInformationMapper teacherInformationMapper;

    @Autowired
    private HotWordMapper hotWordMapper;

    @Autowired
    private SolrClient solrClient;

    @Override
    public List<TeacherInformation> getTeachers(Integer start, Integer size, String keyword) {

        //第二种方式
        SolrQuery solrQuery  = new SolrQuery();
        if(StringUtils.isEmpty(keyword)){
            solrQuery.setQuery("*:*");
        }else{
            solrQuery.setQuery(keyword);
            // 词频
            HotWordExample hotWordExample = new HotWordExample();
            HotWordExample.Criteria criteria = hotWordExample.createCriteria();
            criteria.andHotwordContentLike("%"+keyword+"%");
            List<HotWord> hotWords = hotWordMapper.selectByExample(hotWordExample);
            if(hotWords == null || hotWords.size()==0){
                // 插入词频
                HotWord hotWord = new HotWord();
                hotWord.setHotwordContent(keyword);
                hotWord.setHotwordCount(1L);
            }else{
                // 更新词频
                for (HotWord hotWord : hotWords) {
                    hotWord.setHotwordCount(hotWord.getHotwordCount()+1);
                    hotWordMapper.updateByPrimaryKeySelective(hotWord);
                }
            }
        }
        solrQuery.addField("*");
        solrQuery.set("df","teacher_keywords");
        //设置查询的开始
        solrQuery.setStart(start);
        //设置查询的条数
        solrQuery.setRows(size);
        //设置高亮
        solrQuery.setHighlight(true);
        //设置高亮的字段
        solrQuery.addHighlightField("profession");
        //设置高亮的样式
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.setHighlightSimplePost("</font>");
        System.out.println(solrQuery.toQueryString());
        QueryResponse response = null;
        try {
            response = solrClient.query(solrQuery);
//            //返回高亮显示结果
//            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
//            System.out.println(highlighting);
            //response.getResults();查询返回的结果
            System.out.println(response.getResults());
            List<TeacherInformation> beans = response.getBeans(TeacherInformation.class);
            System.out.println(beans);
            return beans;
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SolrDocumentList test(String keyword) throws IOException, SolrServerException {
        //第二种方式
        SolrQuery solrQuery  = new SolrQuery();


        solrQuery.addField("*");
//        solrQuery.add("q","id:4567");

        solrQuery.setSort("id", SolrQuery.ORDER.asc);
        solrQuery.set("df","teacher_keywords");
        //设置查询的条数
        solrQuery.setRows(50);
        //设置查询的开始
        solrQuery.setStart(0);
        //设置高亮
        solrQuery.setHighlight(true);
        //设置高亮的字段
        solrQuery.addHighlightField("username");
        //设置高亮的样式
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.setHighlightSimplePost("</font>");
        System.out.println(solrQuery);
        QueryResponse response = solrClient.query(solrQuery);
        //返回高亮显示结果
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        System.out.println(highlighting);
        //response.getResults();查询返回的结果
        SolrDocumentList documentList = response.getResults();
        for (SolrDocument solrDocument : documentList) {
            System.out.println("solrDocument==============" +solrDocument);
        }
        return documentList;
    }



}
