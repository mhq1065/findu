package org.bigdatahealth.findu.service.impl;


import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.bigdatahealth.findu.mapper.AnnouncementImageMapper;
import org.bigdatahealth.findu.mapper.AnnouncementMapper;
import org.bigdatahealth.findu.mapper.UserMapper;
import org.bigdatahealth.findu.pojo.*;
import org.bigdatahealth.findu.service.AnnouncementService;
import org.bigdatahealth.findu.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.bigdatahealth.findu.Constant.FILE_SERVER_URL;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AnnouncementImageMapper announcementImageMapper;


    @Override
    public void insertAnnouncement(Announcement announcement, String[] imagesPath) {
        // 判断用户是否认证
        User user = userMapper.selectByPrimaryKey(announcement.getUserId());
        // 认证是老师
        if(user == null){
            throw new RuntimeException("用户获取失败");
        }
        if(user.getAuthenticate() == 1){
            announcementMapper.insert(announcement);
            // 插入图片
            Long proId = announcement.getProId();
            if(imagesPath != null && imagesPath.length>0){
                for (String imagePath : imagesPath) {
                    AnnouncementImage announcementImage = new AnnouncementImage();
                    announcementImage.setAnnouncementId(proId);
                    announcementImage.setImagePath(imagePath);
                    announcementImageMapper.insert(announcementImage);
                }
            }

        }else{
            throw new RuntimeException("权限不够");
        }
    }

    @Override
    public List<Announcement> getAnnouncements(Integer start, Integer size, String keyword) {

        if(start == null || size == null){
            return null;
        }

        AnnouncementExample announcementExample = new AnnouncementExample();
        announcementExample.setOrderByClause("pro_id desc limit "+start+","+size);
        if(!StringUtils.isEmpty(keyword)){
            AnnouncementExample.Criteria criteria = announcementExample.createCriteria();
            criteria.andProNameLike("%"+keyword+"%");
            AnnouncementExample.Criteria criteria2 = announcementExample.createCriteria();
            criteria2.andProProfileLike("%"+keyword+"%");
            announcementExample.or(criteria2);
        }
        List<Announcement> announcements = announcementMapper.selectByExample(announcementExample);
        if(announcements != null){
            for (Announcement announcement : announcements) {
                AnnouncementImageExample announcementImageExample = new AnnouncementImageExample();
                AnnouncementImageExample.Criteria criteria = announcementImageExample.createCriteria();
                criteria.andAnnouncementIdEqualTo(announcement.getProId());
                List<AnnouncementImage> images = announcementImageMapper.selectByExample(announcementImageExample);
                announcement.setImages(images);
            }
            return announcements;
        }
        return null;
    }

    @Override
    public Announcement getOneAnnouncement(Long id) {
        if(id == null){
            return null;
        }
        Announcement announcement = announcementMapper.selectByPrimaryKey(id);
        if(announcement != null){
            AnnouncementImageExample announcementImageExample = new AnnouncementImageExample();
            AnnouncementImageExample.Criteria criteria = announcementImageExample.createCriteria();
            criteria.andAnnouncementIdEqualTo(announcement.getProId());
            List<AnnouncementImage> imageList = announcementImageMapper.selectByExample(announcementImageExample);
            announcement.setImages(imageList);
            return announcement;
        }
        return null;
    }

    @Override
    public void updateAnnouncement(Announcement announcement, String[] imagesPath) {
        announcementMapper.updateByPrimaryKeySelective(announcement);
        // 插入图片
        Long proId = announcement.getProId();
        if(imagesPath != null && imagesPath.length>0){
            for (String imagePath : imagesPath) {
                AnnouncementImage announcementImage = new AnnouncementImage();
                announcementImage.setAnnouncementId(proId);
                announcementImage.setImagePath(imagePath);
                announcementImageMapper.insert(announcementImage);
            }
        }
    }

    @Autowired
    private FastDFSClient fastDFSClient;

    @Override
    public void deleteImage(Long announcementId, String imagePath) {
        if(announcementId == null || StringUtils.isEmpty(imagePath)){
            throw new RuntimeException("param is null");
        }

        // 先从服务器删除图片
        String path = imagePath.substring(FILE_SERVER_URL.length());
        boolean flag = fastDFSClient.delete_file(path);
        if (flag) {
         // 从数据库删除映射
            AnnouncementImageExample imageExample = new AnnouncementImageExample();
            AnnouncementImageExample.Criteria criteria = imageExample.createCriteria();
            criteria.andAnnouncementIdEqualTo(announcementId);
            criteria.andImagePathEqualTo(imagePath);
            announcementImageMapper.deleteByExample(imageExample);
        }
    }

    @Override
    public List<Announcement> getAnnouncement(Long userId) {

        if(userId == null){
            return null;
        }

        AnnouncementExample announcementExample = new AnnouncementExample();
        AnnouncementExample.Criteria criteria = announcementExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Announcement> announcements = announcementMapper.selectByExample(announcementExample);
        if(announcements != null){
            for (Announcement announcement : announcements) {
                AnnouncementImageExample announcementImageExample = new AnnouncementImageExample();
                AnnouncementImageExample.Criteria criteria2 = announcementImageExample.createCriteria();
                criteria2.andAnnouncementIdEqualTo(announcement.getProId());
                List<AnnouncementImage> imageList = announcementImageMapper.selectByExample(announcementImageExample);
                announcement.setImages(imageList);
            }
            return announcements;
        }
        return null;
    }

    @Override
    public void deleteAnnouncement(Long proId) {
        if(proId == null){
            throw new RuntimeException("proId is null,delete failed");
        }

        AnnouncementImageExample imageExample = new AnnouncementImageExample();
        AnnouncementImageExample.Criteria criteria = imageExample.createCriteria();
        criteria.andAnnouncementIdEqualTo(proId);
        List<AnnouncementImage> images = announcementImageMapper.selectByExample(imageExample);
        if (images != null){
            for (AnnouncementImage image : images) {
                fastDFSClient.delete_file(image.getImagePath());
            }
        }
        announcementImageMapper.deleteByExample(imageExample);
        // 删除招募令
        announcementMapper.deleteByPrimaryKey(proId);
    }

    @Override
    public void updateState(Long announcementId, Integer state) {
        if(announcementId == null || state == null){
            throw new RuntimeException("update state failed,param is null");
        }
        Announcement announcement = new Announcement();
        announcement.setProId(announcementId);
        announcement.setState(state);
        announcementMapper.updateByPrimaryKeySelective(announcement);
    }
}
