package org.bigdatahealth.findu.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.bigdatahealth.findu.mapper.StudentAuthMapper;
import org.bigdatahealth.findu.mapper.UserMapper;
import org.bigdatahealth.findu.pojo.StudentAuth;
import org.bigdatahealth.findu.pojo.User;
import org.bigdatahealth.findu.service.StuAuthService;
import org.bigdatahealth.findu.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StuAuthServiceImpl implements StuAuthService {

    @Autowired
    private StudentAuthMapper studentAuthMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void auth(StudentAuth auth){
        // 状态为未审核
        auth.setState(0);
        studentAuthMapper.insert(auth);
        // 更新用户认证状态为审核中
        User user = new User();
        user.setUserId(auth.getUserId());
        // -1 表示正在审核中
        user.setAuthenticate(-1);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
