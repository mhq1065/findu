package org.bigdatahealth.findu.service.impl;

import org.bigdatahealth.findu.mapper.AnnouncementMapper;
import org.bigdatahealth.findu.mapper.FavoriteMapper;
import org.bigdatahealth.findu.mapper.TeacherInformationMapper;
import org.bigdatahealth.findu.pojo.Announcement;
import org.bigdatahealth.findu.pojo.Favorite;
import org.bigdatahealth.findu.pojo.FavoriteExample;
import org.bigdatahealth.findu.pojo.TeacherInformation;
import org.bigdatahealth.findu.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private TeacherInformationMapper teacherInformationMapper;

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public void insertFavorite(Favorite favorite) {
        favoriteMapper.insert(favorite);
    }

    @Override
    public Map<String, List> getAllFavorites(Long userId,Integer type) {

        FavoriteExample favoriteExample = new FavoriteExample();
        FavoriteExample.Criteria criteria = favoriteExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if(type != null){
            criteria.andTypeEqualTo(type);
        }
        List<Favorite> favorites = favoriteMapper.selectByExample(favoriteExample);
        Map<String,List> data = new HashMap<>();
        List<TeacherInformation> teacherInformationList = new ArrayList<>();
        List<Announcement> announcementList = new ArrayList<>();
        for (Favorite favorite : favorites) {
            // 老师信息
            if(favorite.getType()==0){
                TeacherInformation teacherInformation = teacherInformationMapper.selectByPrimaryKey(favorite.getOtherId());
                teacherInformationList.add(teacherInformation);
            }else if(favorite.getType() == 1){
                // 招募令信息
                Announcement announcement = announcementMapper.selectByPrimaryKey(favorite.getOtherId());
                announcementList.add(announcement);
            }
        }
        data.put("teachers",teacherInformationList);
        data.put("announcements",announcementList);
        return data;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteFavorite(Favorite favorite) {
        if(favorite == null){
            throw new RuntimeException("delete failed, favorite is null");
        }

        FavoriteExample favoriteExample = new FavoriteExample();
        FavoriteExample.Criteria criteria = favoriteExample.createCriteria();
        criteria.andUserIdEqualTo(favorite.getUserId());
        criteria.andTypeEqualTo(favorite.getType());
        criteria.andOtherIdEqualTo(favorite.getOtherId());
        favoriteMapper.deleteByExample(favoriteExample);
    }

    public Map<String, List> getAllFavorites(List<Favorite> favorites){
        Map<String,List> data = new HashMap<>();
        List<TeacherInformation> teacherInformationList = new ArrayList<>();
        List<Announcement> announcementList = new ArrayList<>();
        for (Favorite favorite : favorites) {
            // 老师信息
            if(favorite.getType()==0){
                TeacherInformation teacherInformation = teacherInformationMapper.selectByPrimaryKey(favorite.getOtherId());
                teacherInformationList.add(teacherInformation);
            }else if(favorite.getType() == 1){
                // 招募令信息
                Announcement announcement = announcementMapper.selectByPrimaryKey(favorite.getOtherId());
                announcementList.add(announcement);
            }
        }
        data.put("teachers",teacherInformationList);
        data.put("announcements",announcementList);
        return data;
    }
}
