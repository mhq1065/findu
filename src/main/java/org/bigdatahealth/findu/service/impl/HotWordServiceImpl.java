package org.bigdatahealth.findu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.bigdatahealth.findu.mapper.HotWordMapper;
import org.bigdatahealth.findu.pojo.HotWord;
import org.bigdatahealth.findu.pojo.HotWordExample;
import org.bigdatahealth.findu.service.HotWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotWordServiceImpl implements HotWordService {

    @Autowired
    private HotWordMapper hotWordMapper;


    @Override
    public List<HotWord> getHotWords(Integer size) {
        if(size == null){
            size = 10;
        }
        HotWordExample hotWordExample = new HotWordExample();
        hotWordExample.setOrderByClause("hotword_count DESC");
        // 分页
        PageHelper.startPage(1,size);
        Page<HotWord> hotWords = (Page<HotWord>) hotWordMapper.selectByExample(hotWordExample);
        if(hotWords != null){
            return hotWords.getResult();
        }
        return null;


    }
}
