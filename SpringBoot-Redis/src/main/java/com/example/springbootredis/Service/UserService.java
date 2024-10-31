package com.example.springbootredis.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootredis.entity.User;
import com.example.springbootredis.vo.UserInfoVO;
import com.example.springbootredis.vo.UserLoginVO;

public interface UserService extends IService<User> {
    UserLoginVO loginByPhone(String phone,String code);
 boolean checkUserEnabled(Long userId);

    UserInfoVO userInfo(Long userId);
}
