package wenda.Service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wenda.Service.LoginService;
import wenda.entity.User;
import wenda.mapper.UserDao;
@Service
public class Login implements LoginService {
    @Resource
    UserDao userDao;
    @Override
    public User LoginService(String u, String p) {
        User user=userDao.findByUser(u,p);
        return user;
    }
}
