package org.bigdatahealth.findu.service.impl;

import org.bigdatahealth.findu.mapper.TeacherAuthMapper;
import org.bigdatahealth.findu.mapper.UserMapper;
import org.bigdatahealth.findu.pojo.TeacherAuth;
import org.bigdatahealth.findu.pojo.User;
import org.bigdatahealth.findu.service.TeacherAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherAuthServiceImpl implements TeacherAuthService {

    @Autowired
    private TeacherAuthMapper teacherAuthMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public void auth(TeacherAuth auth) {
        // 代码待优化
        // 状态为未审核
        auth.setState(0);
        teacherAuthMapper.insert(auth);
        // 更新用户认证状态为审核中
        User user = new User();
        user.setUserId(auth.getUserId());
        // -1 表示正在审核中
        user.setAuthenticate(-1);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
