package cn.melvin.dao;

import cn.melvin.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名统计（TODO 假设它是一个很复杂的SQL）
     * @param username
     * @return  统计结果
     */
    int countByUsername(String username);
}
