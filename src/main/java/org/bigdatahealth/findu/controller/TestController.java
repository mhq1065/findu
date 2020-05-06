package org.bigdatahealth.findu.controller;

import org.bigdatahealth.findu.Constant;
import org.bigdatahealth.findu.pojo.Result;
import org.bigdatahealth.findu.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private FastDFSClient fastDFSClient;

    @RequestMapping("/fileupload")
    @ResponseBody
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
        }
        return result;
    }

    @RequestMapping("/file")
    public String file(){
        return "file";
    }
}
