package org.bigdatahealth.findu.controller;


import lombok.extern.slf4j.Slf4j;
import org.bigdatahealth.findu.Constant;
import org.bigdatahealth.findu.pojo.Result;
import org.bigdatahealth.findu.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.HashMap;
import java.util.Map;

import static org.bigdatahealth.findu.Constant.FILE_SERVER_URL;


@RestController
@RequestMapping("/api/auth")
@Slf4j
public class ImageController {


    @Autowired
    private FastDFSClient fastDFSClient;

    @RequestMapping("/proof")
    public Result uploadFile(@RequestParam("file") MultipartFile file){
        Result result = new Result();
        try {
            String path = fastDFSClient.upload(file);
            String url = Constant.FILE_SERVER_URL+"/"+path;
            System.out.println(url);
            Map<String ,Object > data = new HashMap<>();
            result.setRetCode(0);
            result.setMessage("upload success");
            data.put("url",url);
            result.setData(data);
        } catch (Exception e) {
//            e.printStackTrace();
            result.setRetCode(-1);
            result.setMessage("upload failed");
            log.error("error message:",e);
        }
        return result;
    }



}
