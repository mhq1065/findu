package org.bigdatahealth.findu.pojo;


import lombok.Getter;
import lombok.Setter;
@Setter@Getter
public class User {

    private Long userId;

    private String userNick;

    private String userSex;

    private Integer userAge;

    private String userCity;

    private String userPortrait;

    private String openid;

    private String sessionkey;

    // 1 认证老师  2  认证学生  0 未认证
    private Integer authenticate;

    private String userSignature;

    private String userPhone;

    private String userEmail;

    private Integer member;


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userCity='" + userCity + '\'' +
                ", userPortrait='" + userPortrait + '\'' +
                ", openid='" + openid + '\'' +
                ", sessionkey='" + sessionkey + '\'' +
                ", authenticate=" + authenticate +
                ", userSignature='" + userSignature + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", member=" + member +
                '}';
    }
}