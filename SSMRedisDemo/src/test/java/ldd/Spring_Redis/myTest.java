package ldd.Spring_Redis;
 

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
 
public class myTest {
 
	@SuppressWarnings("rawtypes")
	RedisTemplate redisTemplate = null;
	
	@SuppressWarnings("resource")
	@Before
	public void before(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		redisTemplate = ctx.getBean(RedisTemplate.class);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void Test01() {
		Map map = new HashMap();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");		
		//存储到到内存中的不是map而是string，进行了序列化
		redisTemplate.opsForValue().set("map", map);
		Map role1 = (Map) redisTemplate.opsForValue().get("map");
		//上面两步不能保证每次使用RedisTemplate是操作同一个对Redis的连接		
		System.out.println(role1.toString());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void Test02(){					
		redisTemplate.opsForValue().set("shiboxue", "123");
		String role1 = redisTemplate.opsForValue().get("shiboxue").toString();
				
		System.out.println(role1.toString());
	}
	
	@Test
	public void Test03(){					
		String role1 = redisTemplate.opsForValue().get("shiboxue").toString();				
		System.out.println(role1.toString());	
	}
	
 
}