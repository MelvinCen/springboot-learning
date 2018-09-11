package cn.melvin.controller;

import cn.melvin.domain.User;
import cn.melvin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class SpringJdbcController {

    @Autowired
    UserService userService;

    //查询所有用户
    @GetMapping
    public List<User> queryUsers(){
        return userService.queryUsers();
    }

    //根据用户id查询用户
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    //添加用户
    @PostMapping("/adduser")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    //更新用户信息
    @PostMapping("/updateuser")
    public int editUser(@RequestBody User user){
        return userService.editUser(user);
    }
    //根据用户id删除用户
    @PostMapping("/deluser")
    public int delUser(@RequestParam(value = "id") Long id){
        return userService.delUser(id);
    }
}
