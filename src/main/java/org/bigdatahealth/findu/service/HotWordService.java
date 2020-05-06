package org.bigdatahealth.findu.service;

import org.bigdatahealth.findu.pojo.HotWord;

import java.util.List;

public interface HotWordService {

    List<HotWord> getHotWords(Integer size);
}
