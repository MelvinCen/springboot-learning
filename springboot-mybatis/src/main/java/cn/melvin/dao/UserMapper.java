package cn.melvin.dao;

import cn.melvin.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_user where username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    int insert(User user);
}
