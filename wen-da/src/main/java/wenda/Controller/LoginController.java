package wenda.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wenda.Service.LoginService;
import wenda.common.ResponseResult;
import wenda.entity.User;
import wenda.mapper.UserDao;

@RestController
@AllArgsConstructor
@RequestMapping("/shouye")
public class LoginController {
    private final LoginService loginService;
    private final UserDao userDao;
    @PostMapping  ("/login")
    public ResponseResult login(@RequestBody User u){
        User user = loginService.LoginService(u.getUsername(), u.getPassword());
        if (user!=null){
            return ResponseResult.builder()
                    .code(200)
                    .msg("成功")
                    .data(user)
                    .build();
        }else return ResponseResult.builder()
                .code(404)
                .msg("失败")
                .data(null)
                .build();
    }
   @PostMapping("/Register")
    public ResponseResult register(@RequestBody User u){
        int u1=userDao.insert(u);
        return ResponseResult.builder()
                .code(200)
                .msg("成功")
                .data(u1)
                .build();
   }
}
