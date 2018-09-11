package cn.melvin;

import cn.melvin.dao.UserRepository;
import cn.melvin.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class springbootJPAApplicationTests {

    public static final Logger LOG = LoggerFactory.getLogger(springbootJPAApplicationTests.class.getSimpleName());

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserData(){
        //添加用户信息
//        User user = userRepository.save(new User("PDD", "123"));
//        LOG.info("[添加成功] - [{}]", user);
        //根据用户名查询用户信息
//        List<User> all = userRepository.findAllByUsername("PD");
//        LOG.info("[条件查询] - [{}]", all);
        //分页查询用户
//        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
//        Page<User> users = userRepository.findAll(pageable);
//        LOG.info("[分页+排序+查询所有] - [{}]", users.getContent());
//        userRepository.findById(users.getContent().get(0).getId()).ifPresent(new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                LOG.info("[主键查询] - [{}]", user);
//            }
//        });
        //根据用户id更新用户信息
//        boolean existsById = userRepository.existsById(2L);
//        if (existsById) {
//            User edit = userRepository.save(new User(2L, "修改后的PDD", "修改后的123"));
//            LOG.info("[修改成功] - [{}]", edit);
//        } else {
//            LOG.info("不存在该用户");
//        }
        //根据用户id删除用户信息
        boolean existsById = userRepository.existsById(1L);
        if (existsById) {
            userRepository.deleteById(1L);
            boolean existsBy = userRepository.existsById(1L);
            if (existsBy) {
                LOG.info("删除失败");
            } else {
                LOG.info("[删除主键 {} 成功] - [{}]", 1L);
            }

        } else {
            LOG.info("您删除的用户不存在");
        }


    }

}
