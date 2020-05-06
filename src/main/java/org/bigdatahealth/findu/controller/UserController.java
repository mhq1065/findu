package org.bigdatahealth.findu.controller;


import lombok.extern.slf4j.Slf4j;
import org.bigdatahealth.findu.pojo.Favorite;
import org.bigdatahealth.findu.pojo.Result;
import org.bigdatahealth.findu.pojo.User;
import org.bigdatahealth.findu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;


    /* 用户登录*/
    @PostMapping("/login")
    public Result login(@RequestParam String code, @RequestParam String rawData){
        Result result = new Result();
        if(code == null || rawData == null){
            result.setRetCode(-1);
            result.setMessage("login failed,code or rawData is null");
            return result;
        }
        try {
            String token = userService.login(code,rawData);
            if(token != null){
                result.setRetCode(0);
                result.setMessage("login success");
                Map map = new HashMap();
                map.put("token",token);
                result.setData(map);
            }else{
                result.setRetCode(-1);
                result.setMessage("login failed");
            }

        }catch (Exception e){
            result.setRetCode(-1);
            result.setMessage("login failed");
            log.error("error message:",e);
        }
        System.out.println(result);
        return result;
    }



    // 获取用户信息
    @GetMapping("userInfo")
    public Result getUserInfo(HttpServletRequest request){
        Long userId = (Long) request.getAttribute("userId");
        Result result;
        User user = userService.getUserInfo(userId);
        if (user == null) {
            result = new Result(1,"token expired");
        }else{
            result = new Result(0,"success");
            Map map = new HashMap();
            map.put("user",user);
            result.setData(map);
        }
        return result;
    }

    // 修改用户信息
    @PutMapping("/userInfo")
    public Result updateUser(User user){
        Result result;
        try {
            // 修改成功
            userService.updateUserInfo(user);
            result = new Result(0,"update success");

        }catch (Exception e){
            // 修改失败
            result = new Result(-1,"update failed");
            log.error("error message:",e);
        }
        return result;
    }





}
