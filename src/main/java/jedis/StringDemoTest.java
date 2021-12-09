package jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class StringDemoTest {
    @Test
    void operateString() {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("连接测试Ping：" + jedis.ping());
        System.out.println("keys：" + jedis.keys("*"));

        jedis.set("jedis:key", "666666");
        System.out.println("type(jedis:key)：" + jedis.type("jedis:key"));
        System.out.println("get(jedis:key)：" + jedis.get("jedis:key"));
        System.out.println("strlen(jedis:key)：" + jedis.strlen("jedis:key"));
        System.out.println("getrange(jedis:key)：" + jedis.getrange("jedis:key", 0, -1));
        // 追加字符串
        System.out.println("append(jedis:key)" + jedis.append("jedis:key", "88888888"));
        System.out.println("新追加get(jedis:key)：" + jedis.get("jedis:key"));

        // 设置过期时间
        jedis.setex("expires", 5, "im expired after 5 seconds");
        System.out.println("get(expires)：" + jedis.get("expires"));
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("过期后get(expire)：" + jedis.get("expire"));

        jedis.close();
    }
}
