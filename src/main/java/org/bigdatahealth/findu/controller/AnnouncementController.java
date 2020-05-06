package org.bigdatahealth.findu.controller;


import lombok.extern.slf4j.Slf4j;
import org.bigdatahealth.findu.pojo.Announcement;
import org.bigdatahealth.findu.pojo.Result;
import org.bigdatahealth.findu.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class AnnouncementController {


    @Autowired
    private AnnouncementService announcementService;

    /**
     *  插入一条招募令
     * @param request
     * @param announcement
     * @param imagesPath
     * @return
     */
    @PostMapping("/announcement")
    public Result addAnnouncement(HttpServletRequest request,Announcement announcement, String[] imagesPath){
        Long userId = (Long) request.getAttribute("userId");
        Result result;
        announcement.setUserId(userId);
        try {
            announcementService.insertAnnouncement(announcement,imagesPath);
            result = new Result(0,"success");
        }catch (RuntimeException e){
            result = new Result(-1,"authentication failed");
        }
        System.out.println(result);
        return result;
    }

    /**
     * 获取所有招募令
     */
    @GetMapping("/announcement")
    public List<Announcement> getAnnouncements(@RequestParam Integer start, @RequestParam Integer size, String keyword){
        List<Announcement> res = null;
        try {
            res = announcementService.getAnnouncements(start,size,keyword);
        }catch (Exception e){

            log.error("error message:",e);
//            e.printStackTrace();
        }
        return res;
    }

    // 通过id 获取招募令
    @GetMapping("/announcementById")
    public Announcement getAnnouncement(Long id){
        System.out.println(id);
        return announcementService.getOneAnnouncement(id);
    }

    // 获取用户发布的招募令
    @GetMapping("/announcementByUserId")
    public Result getAnnouncements(HttpServletRequest request){
        Long userId = (Long) request.getAttribute("userId");
        List<Announcement> list = announcementService.getAnnouncement(userId);
        if(list != null){
            Result result = new Result(0,"success");
            HashMap<String, Object> data = new HashMap<>();
            data.put("announcements",list);
            result.setData(data);
            return result;
        }
        return new Result(-1,"failed");
    }


    // 修改招募令
    @PutMapping("/announcement")
    public Result updateAnnouncement(HttpServletRequest request,Announcement announcement, String[] imagesPath){
        Long userId = (Long) request.getAttribute("userId");
        Result result;
        announcement.setUserId(userId);
        try {
            announcementService.updateAnnouncement(announcement,imagesPath);
            result = new Result(0,"success");
        }catch (RuntimeException e){
            result = new Result(-1,"authentication failed");
        }
        System.out.println(result);
        return result;
    }

    // 删除招募令图片
    @DeleteMapping("/announcement/image")
    public Result deleteImage(Long announcementId,String imagePath){
        try{
            announcementService.deleteImage(announcementId,imagePath);
            return new Result(0,"success");
        }catch (Exception e){
            log.error(e.toString());
            return new Result(-1,"delete failed");
        }
    }


    // 删除招募令
    @DeleteMapping("/announcement")
    public Result deleteAnnouncement(Long proId){
        try{
            announcementService.deleteAnnouncement(proId);
            return new Result(0,"delete success");
        }catch (Exception e){
            log.error(e.toString());
            return new Result(-1,"delete failed");
        }
    }


    // 更改招募令状态
    @PutMapping("/announcement/state")
    public Result updateState(Long announcementId,Integer state){
        try {
            announcementService.updateState(announcementId,state);
            return new Result(0,"success");
        }catch (Exception e){
            log.error(e.toString());
            return new Result(-1,"failed,maybe parameter is null");
        }
    }

}
