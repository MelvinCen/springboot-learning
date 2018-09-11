package cn.melvin;

import cn.melvin.dao.UserMapper;
import cn.melvin.domain.User;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class springbootMybatisPluginApplicationTests {

    public static final Logger LOG = LoggerFactory.getLogger(springbootMybatisPluginApplicationTests.class.getSimpleName());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserData(){
        LOG.error("error日志");
        final User user1 = new User("u1", "p1");
        final User user2 = new User("u1", "p2");
        final User user3 = new User("u3", "p3");
        userMapper.insertSelective(user1);
        LOG.info("[user1回写主键] - [{}]", user1.getId());
        userMapper.insertSelective(user2);
        LOG.info("[user2回写主键] - [{}]", user2.getId());
        userMapper.insertSelective(user3);
        LOG.info("[user3回写主键] - [{}]", user3.getId());
        final int count = userMapper.countByUsername("u1");
        LOG.info("[调用自己写的SQL] - [{}]", count);

        // TODO 模拟分页
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));

        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                userMapper.selectAll();
            }
        });
        LOG.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

        PageHelper.startPage(1,10).setOrderBy("id desc");
        PageInfo<User> userPageInfo = new PageInfo<>(userMapper.selectAll());
        LOG.info("[普通写法] - [{}]", userPageInfo);

    }

}
