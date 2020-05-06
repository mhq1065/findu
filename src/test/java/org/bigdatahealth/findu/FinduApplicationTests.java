package org.bigdatahealth.findu;

import org.bigdatahealth.findu.mapper.AnnouncementMapper;
import org.bigdatahealth.findu.mapper.UserMapper;
import org.bigdatahealth.findu.pojo.Announcement;
import org.bigdatahealth.findu.pojo.User;
import org.bigdatahealth.findu.utils.FastDFSClient;
import org.bigdatahealth.findu.utils.Token;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.bigdatahealth.findu.Constant.FILE_SERVER_URL;

@SpringBootTest(classes = FinduApplication.class)
@RunWith(SpringRunner.class)
class FinduApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("---------");
    }


    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
       /* String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJTZXJ2aWNlIiwiZXhwIjoxNTgxNDE2NjgzLCJ1c2VySWQiOjQsImlhdCI6MTU4MDU1MjY4M30.X90Wy51O6eciVoJoxr88CgZWvXX4Vt57ywJQceQkP4A";
        Long userId = Token.getUserId(token);
        System.out.println(userId);*/

       Long userId = 4L;
        User user = new User();
        user.setUserId(userId);
        String token = Token.createToken(user);
        System.out.println(token);
        System.out.println(Token.getUserId(token));


    }


    @Autowired
    private AnnouncementMapper announcementMapper;


    @Test
    public void test2(){
//        List<Announcement> announcements = announcementMapper.selectAll(0, 2,"");
//        System.out.println(announcements);
    }

    @Autowired
    private FastDFSClient fastDFSClient;


    @Test
    public void test3(){
        String imagePath = "http://drzhaoxi.org:8087/group1/M00/00/00/wKgApl5t_hCANFMcAACsjF4IUO4917.jpg";
        String path = imagePath.substring(FILE_SERVER_URL.length());
        System.out.println(path);
        fastDFSClient.delete_file(path);
    }

}
