package jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class ListDemoTest {
    @Test
    void operateList() {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("连接测试Ping：" + jedis.ping());
        jedis.rpush("jedis:list", "1", "2", "3");
        // 遍历
        System.out.println("lrange：" + jedis.lrange("jedis:list", 0, -1));
        System.out.println("llen：" + jedis.llen("jedis:list"));
        System.out.println("lpop：" + jedis.lpop("jedis:list"));
        System.out.println("rpop：" + jedis.rpop("jedis:list"));
        // 弹出后的列表
        System.out.println("lrange：" + jedis.lrange("jedis:list", 0, -1));
        System.out.println("llen：" + jedis.llen("jedis:list"));
    }
}
