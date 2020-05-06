package org.bigdatahealth.findu.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigdatahealth.findu.pojo.Favorite;
import org.bigdatahealth.findu.pojo.Result;
import org.bigdatahealth.findu.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // 收藏功能
    @PostMapping("/favorite")
    public Result favorite(HttpServletRequest request,  Favorite favorite){
        Long userId = (Long) request.getAttribute("userId");
        Result result;
        favorite.setUserId(userId);
        System.out.println(favorite);
        try{
            favoriteService.insertFavorite(favorite);
            result = new Result(0,"favorite success");
        }catch (Exception e){
            result = new Result(-1,"favorite failed");
            log.error("error message:",e);
//            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("/favorite")
    public Result delete(HttpServletRequest request,  Favorite favorite){
        Long userId = (Long) request.getAttribute("userId");
        Result result;
        favorite.setUserId(userId);
        System.out.println(favorite);
        try{
            favoriteService.deleteFavorite(favorite);
            result = new Result(0,"favorite delete success");
        }catch (Exception e){
            result = new Result(-1,"favorite delete failed");
            log.error("error message:",e);
//            e.printStackTrace();
        }
        return result;
    }

   /* // 取消收藏
    @DeleteMapping("/favorite")
    public Result delete(Long id){
        try {
            favoriteService.delete(id);
            return new Result(0,"删除成功");
        }catch (Exception e){
            log.error(e.toString());
            return new Result(-1,"删除失败");
        }
    }*/

    // 获取所有收藏内容
    @GetMapping("/favorites")
    public Result getFavorites(HttpServletRequest request,Integer type){
        Long userId = (Long) request.getAttribute("userId");
        Result result;
        try {
            Map<String, List>  res = favoriteService.getAllFavorites (userId,type);
            result = new Result(0,"success");
            result.setData(res);
        }catch (Exception e){
            result = new Result(-1,"failed");
            log.error("error message:",e);
//            e.printStackTrace();
        }
        return result;
    };

}
