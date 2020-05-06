package org.bigdatahealth.findu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bigdatahealth.findu.mapper.UserMapper;
import org.bigdatahealth.findu.pojo.User;
import org.bigdatahealth.findu.pojo.UserExample;
import org.bigdatahealth.findu.service.UserService;
import org.bigdatahealth.findu.utils.GetSessionKey;
import org.bigdatahealth.findu.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    // 注入用户dao
    @Autowired
    private UserMapper userMapper;


    public User findByOpenid(String openid) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<User> users = userMapper.selectByExample(userExample);
        return users.size()>0 ? users.get(0):null;
    }


    @Override
    public String login(String code, String rawData) throws IOException {

        JSONObject rawDataJson = JSON.parseObject( rawData );
        JSONObject SessionKeyOpenId = null;
        SessionKeyOpenId = GetSessionKey.getSessionKeyOrOpenId(code);
        if(SessionKeyOpenId != null){
            String openid = SessionKeyOpenId.getString("openid" );
            String sessionKey = SessionKeyOpenId.getString( "session_key" );
            User user = this.findByOpenid( openid );
            System.out.println(user);
            if(user==null) {
                //入库
                String nickName = rawDataJson.getString("nickName");
                String avatarUrl = rawDataJson.getString("avatarUrl");
                String gender = rawDataJson.getString("gender");
                String city = rawDataJson.getString("city");
                user = new User();
                user.setUserNick(nickName);
                if ("1".equals(gender)) {
                    user.setUserSex("m");
                } else if ("2".equals(gender)){
                    user.setUserSex("f");
                }else{
                    user.setUserSex("n");
                }
                user.setOpenid(openid);
                user.setSessionkey(sessionKey);
                user.setUserCity(city);
                // 0 表示未认证
                user.setAuthenticate(0);
                // 0 表示不是会员
                user.setMember(0);
                user.setUserPortrait(avatarUrl);

                /* 将用户保存到数据库 */
                userMapper.insert(user);
            }
            // 返回用户token
            String token = Token.createToken(user);
            return token;
        }
        return null;


    }

    /**
     *  获取用户信息
     * @param userId
     * @return
     */
    @Override
    public User getUserInfo(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if(user != null){
            user.setOpenid(null);
            user.setSessionkey(null);
        }
        return user;
    }

    /**
     *  更新用户信息
     * @param user
     */
    @Override
    public void updateUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
