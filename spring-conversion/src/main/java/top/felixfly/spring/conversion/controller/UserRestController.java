package top.felixfly.spring.conversion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.felixfly.spring.conversion.entity.User;

/**
 * 用户服务
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/6/3
 */
@RestController
public class UserRestController {

    @GetMapping("/echo")
    public User echo(User user){
        return user;
    }
}
