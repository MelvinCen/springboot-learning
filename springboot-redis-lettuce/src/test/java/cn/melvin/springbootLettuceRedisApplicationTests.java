package cn.melvin;


import cn.melvin.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class springbootLettuceRedisApplicationTests {

    public static final Logger LOG = LoggerFactory.getLogger(springbootLettuceRedisApplicationTests.class.getSimpleName());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void get(){
        //TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0,1000).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        stringRedisTemplate.opsForValue().increment("kk",1);
                    }
                });
            }
        });

        stringRedisTemplate.opsForValue().set("kk","v1");
        String k1 = stringRedisTemplate.opsForValue().get("kk");
        LOG.info("[字符缓存结果] - [{}]", k1);

        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "battcn:user:1";
        redisCacheTemplate.opsForValue().set(key,new User(1L,"u1","pa"));
        // TODO 对应 String（字符串）
        final User user = (User) redisCacheTemplate.opsForValue().get(key);
        LOG.info("[对象缓存结果] - [{}]", user);
    }

}
