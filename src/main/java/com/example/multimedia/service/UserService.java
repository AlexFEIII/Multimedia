package com.example.multimedia.service;

import com.example.multimedia.domain.MulUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    /*
    * 上传头像
    * */
    String uploadImage(MultipartFile file);

    /*
    * 注册
    * */
    String register(String username,String password,String nickname,String code);

    /*
    * 修改密码、头像
    * */
    String changePassword(String pass);
    String changeHeadimage(MultipartFile headimage);

    //修改用户昵称和邮箱
    String changeNick(String nickname,String email);

    //修改用户基础信息
    String changeUserInfor(int sex,String personality,String address,String qq,String job,String weburl);

    /*
    * 返回全部用户
    * */
    Page<MulUser> getAllUser(int pageNum, int size, Sort.Direction direction, String key);

    /*
    * 设置用户角色和权限
    * */
    String setRolePower(long userid,String role,String power);

    /*
    * 判断是否已经登陆
    * */
    MulUser isLogin();

    //获取用户名
    MulUser getUser();

    //取得一个用户
    MulUser getOne(long id);

    //发送验证码
    String getCode(String nickname,String phoneNum);
}
