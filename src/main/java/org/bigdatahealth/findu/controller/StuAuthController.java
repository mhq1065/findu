package org.bigdatahealth.findu.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigdatahealth.findu.pojo.Result;
import org.bigdatahealth.findu.pojo.StudentAuth;
import org.bigdatahealth.findu.service.StuAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 *   处理学生认证的控制器
 */
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class StuAuthController {


    @Autowired
    private StuAuthService stuAuthService;


    @RequestMapping("/student")
    public Result stuAuthentication(HttpServletRequest request,StudentAuth auth){

        Long userId = (Long) request.getAttribute("userId");
        auth.setUserId(userId);
        System.out.println(auth);
        Result result;
        try {
            stuAuthService.auth(auth);
            result = new Result(0,"success");
        }catch (Exception e){
            result = new Result(-1,"fail");
            log.error("error message:",e);
        }
        return result;
    }


}
