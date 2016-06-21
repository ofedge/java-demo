package springmessage;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springmessage.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RedisTest {
    
    @Resource(name="redisTemplate")
    private RedisTemplate<String, String> templates;
    
    @Test
    public void setTest() {
        templates.boundListOps("test").leftPop();
    }
}
