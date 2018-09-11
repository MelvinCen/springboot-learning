package cn.melvin.dao;

import cn.melvin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询所有用户
    public List<User> queryUsers(){
        String sql = "select * from t_user;";
        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(User.class));
    }
    //根据用户id查询用户
    public User getUser(Long id){
        String sql = "select * from t_user where userId = ?;";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(User.class));
    }
    //添加用户
    public int addUser(User user){
        String sql = "insert into t_user(userName,password,phone) values (?,?,?);";
        return jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getPhone());
    }
    //更新用户信息
    public int editUser(User user){
        String sql = "update t_user set userName = ?, password = ?, phone = ? where userId = ?";
        return jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getPhone(),user.getUserId());
    }
    //根据用户id删除用户
    public int delUser(Long id){
        String sql = "delete from t_user where userId = ?;";
        return jdbcTemplate.update(sql,id);
    }
}
