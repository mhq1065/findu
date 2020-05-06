package org.bigdatahealth.findu.service;


import org.bigdatahealth.findu.pojo.User;

import java.io.IOException;

public interface UserService {


    String login(String code, String rawData) throws IOException;

    User getUserInfo(Long token);

    void updateUserInfo(User user);
}
