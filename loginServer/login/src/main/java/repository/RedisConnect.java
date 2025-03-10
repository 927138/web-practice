package repository;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisConnect {
	
	public RedisConnect() {
		Jedis jedis = new Jedis("localhost", 15412);
		
		System.out.println("success connected redis-server");
		
		Set<String> list = jedis.keys("*");
		for(int i=0; i<list.size(); i++) {
		       System.out.println("List of stored keys:: "+list.size());
		     }
	}
}
