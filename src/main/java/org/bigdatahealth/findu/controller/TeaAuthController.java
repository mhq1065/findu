package org.bigdatahealth.findu.controller;


import lombok.extern.slf4j.Slf4j;
import org.bigdatahealth.findu.pojo.Result;
import org.bigdatahealth.findu.pojo.StudentAuth;
import org.bigdatahealth.findu.pojo.TeacherAuth;
import org.bigdatahealth.findu.service.StuAuthService;
import org.bigdatahealth.findu.service.TeacherAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  处理教师认证的控制器
 */

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class TeaAuthController {


    @Autowired
    private TeacherAuthService teacherAuthService;


    /**
     *  代码重复待优化
     * @param request
     * @param auth
     * @return
     */
    @RequestMapping("/teacher")
    public Result teacherAuthentication(HttpServletRequest request, TeacherAuth auth){
        Long userId = (Long) request.getAttribute("userId");
        auth.setUserId(userId);
        System.out.println(auth);
        Result result;
        try {
            teacherAuthService.auth(auth);
            result = new Result(0,"success");
        }catch (Exception e){
            result = new Result(-1,"fail");
            log.error("error message:",e);
        }
        return result;
    }

}
