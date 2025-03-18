package repository;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnect {
	
	public RedisConnect() {
		
		JedisPoolConfig jedisConfig = new JedisPoolConfig();
		JedisPool pool = new JedisPool(jedisConfig, "localhost", 15412);
		// jedis 자원 사용 이후 close() 가필요함.
		Jedis jedis = pool.getResource();
		
		// key-value type
		jedis.set("test", "pro");
		System.out.println(jedis.get("test"));
		
		jedis.del("test");
		System.out.println(jedis.get("test"));
		
		try {
			jedis.set("test", "pro");
			jedis.expire("test", 5);
			Thread.sleep(4000);
			
			System.out.println(jedis.get("test"));
			Thread.sleep(2000);
			System.out.println(jedis.get("test"));
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		if(jedis != null) {
			jedis.close();
		}
		
		pool.close();
	}
}
