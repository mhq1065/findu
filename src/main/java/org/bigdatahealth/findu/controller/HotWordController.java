package org.bigdatahealth.findu.controller;

import org.bigdatahealth.findu.pojo.HotWord;
import org.bigdatahealth.findu.service.HotWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotWordController {

    @Autowired
    private HotWordService hotWordService;

        @RequestMapping("/getHotWords")
    public List<HotWord> getHotWords(Integer size){
        List<HotWord> hotWords = hotWordService.getHotWords(size);
        return hotWords;
    }

}
