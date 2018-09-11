package cn.melvin;

import cn.melvin.dao.UserMapper;
import cn.melvin.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class springbootMybatisApplicationTests {

    public static final Logger LOG = LoggerFactory.getLogger(springbootMybatisApplicationTests.class.getSimpleName());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserData(){
        final int row1 = userMapper.insert(new User("u1", "p1"));
        LOG.info("[添加结果] - [{}]", row1);
        final int row2 = userMapper.insert(new User("u2", "p2"));
        LOG.info("[添加结果] - [{}]", row2);
        final int row3 = userMapper.insert(new User("u1", "p3"));
        LOG.info("[添加结果] - [{}]", row3);
        final List<User> u1 = userMapper.findByUsername("u1");
        LOG.info("[根据用户名查询] - [{}]", u1);

    }

}
