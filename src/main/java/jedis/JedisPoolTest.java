package jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import java.util.Set;

public class JedisPoolTest {
    public static final int NUM = 20;
    public static final String ZSET_KEY = "zset1";
    //测试删除
    @Test
    public void testDel() {
        Jedis redis =null;
        try  {
            redis = JedisPoolBuilder.getJedis();
            long start = System.currentTimeMillis();
            redis.del(ZSET_KEY);
            long end = System.currentTimeMillis();
            System.out.println("删除 zset1  毫秒数:" + (end - start));
        } finally {
            //使用后一定关闭，还给连接池
            if (redis != null) {
                redis.close();
            }
        }
    }

    //测试创建zset
    @Test
    public void testSet() {
        testDel();
        try (Jedis redis = JedisPoolBuilder.getJedis()) {
            int loop = 0;
            long start = System.currentTimeMillis();
            while (loop < NUM) {
                redis.zadd(ZSET_KEY, loop, "field-" + loop);
                loop++;
            }
            long end = System.currentTimeMillis();
            System.out.println("设置zset :" + loop + "次, 毫秒数:" + (end - start));
        }
    }
    //测试查询zset
    @Test
    public void testGet() {
        try (Jedis redis = JedisPoolBuilder.getJedis()) {
            long start = System.currentTimeMillis();
            Set<String> set = redis.zrange(ZSET_KEY, 0, -1);
            long end = System.currentTimeMillis();
            System.out.println("顺序获取zset毫秒数:" + (end - start));
            System.out.println(set.toString());
        }

        try (Jedis redis = JedisPoolBuilder.getJedis()) {
            long start = System.currentTimeMillis();
            Set<String>   set = redis.zrevrange(ZSET_KEY, 0, -1);
            long end = System.currentTimeMillis();
            System.out.println("逆序获取 zset  毫秒数:" + (end - start));
            System.out.println(set.toString());
        }
    }
}
