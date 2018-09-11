package cn.melvin.service;

import cn.melvin.dao.UserDao;
import cn.melvin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    //查询所有用户
    public List<User> queryUsers(){
        return userDao.queryUsers();
    }
    //根据用户id查询用户
    public User getUser(Long id){
        return userDao.getUser(id);
    }
    //添加用户
    public int addUser(User user){
        return userDao.addUser(user);
    }
    //更新用户信息
    public int editUser(User user){
        return userDao.editUser(user);
    }
    //根据用户id删除用户
    public int delUser(Long id){
        return userDao.delUser(id);
    }
}
