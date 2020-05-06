package org.bigdatahealth.findu.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.bigdatahealth.findu.utils.Token;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 *  拦截用户请求  验证token
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            // 拦截
           return processRes(response,"no token");
        }
        Long userId = Token.getUserId(token);
        if (userId == null) {
            // 拦截
            return processRes(response,"authentication failed");
        }
        request.setAttribute("userId",userId);
        return true;
    }


    public boolean processRes(HttpServletResponse response,String msg){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null ;
        try{
            JSONObject res = new JSONObject();
            res.put("success","false");
            res.put("msg",msg);
            out = response.getWriter();
            out.append(res.toString());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
