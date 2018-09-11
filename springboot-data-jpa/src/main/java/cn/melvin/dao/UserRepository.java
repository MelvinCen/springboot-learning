package cn.melvin.dao;

import cn.melvin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    List<User> findAllByUsername(String username);
}
