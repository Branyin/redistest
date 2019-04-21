import ai.grakn.redismock.RedisServer;
import com.service.test.RedisConfig;
import com.service.test.ServiceForUnitTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by earringyin on 2019/4/21.
 */
@SpringBootTest(classes = {ServiceForUnitTest.class, RedisConfig.class})
@RunWith(SpringRunner.class)
public class MockRedis {
    @Autowired
    ServiceForUnitTest serviceForUnitTest;



    RedisServer redisServer;

    @Before
    public void setRedisTemplate(){
        try {


            redisServer = new RedisServer(6379);
            redisServer.start();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test(){
        serviceForUnitTest.testRedisTemplate();
    }


    @After
    public void stopRedis(){
        try {
            redisServer.stop();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
