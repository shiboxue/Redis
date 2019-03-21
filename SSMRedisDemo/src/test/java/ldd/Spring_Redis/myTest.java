package ldd.Spring_Redis;
 

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Title: myTest  
 * @Description: 测试redis  
 * @author shiboxue  
 * @date 2019年3月21日
 */
public class myTest {
 
	@SuppressWarnings("rawtypes")
	RedisTemplate redisTemplate = null;
	
	/**
	  * 
	  *@name  before  
	  *@description 加载配置文件，并返回对象redisTemplate
	  *@time 2019年3月21日 
	  *@param 
	  *@return void
	  *@throws 
	  *@author shiboxue
	  *@history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	@SuppressWarnings("resource")
	@Before
	public void before(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		redisTemplate = ctx.getBean(RedisTemplate.class);
	}
	
	/**
	  * 
	  *@name  Test01  
	  *@description 测试redis 
	  *@time 2019年3月21日 
	  *@param 
	  *@return void
	  *@throws 
	  *@author shiboxue
	  *@history 修订历史（历次修订内容、修订人、修订时间等）
	 */	
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
	/**	   
	  *@name  Test02  
	  *@description 简单测试redis
	  *@time 2019年3月21日 
	  *@param 
	  *@return void
	  *@throws 
	  *@author shiboxue
	  *@history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void Test02(){					
		redisTemplate.opsForValue().set("shiboxue", "123");
		String role1 = redisTemplate.opsForValue().get("shiboxue").toString();				
		System.out.println(role1.toString());
	}
	
	/**
	 * 	
	 *@name  Test03  
	 *@description 获取redis其中的一个值
	 *@time 2019年3月21日 
	 *@param 
	 *@return void
	 *@throws 
	 *@author shiboxue
	 *@history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	@Test
	public void Test03(){					
		String role1 = redisTemplate.opsForValue().get("shiboxue").toString();				
		System.out.println(role1.toString());	
	}
	
	/**
	 * 	
	 *@name  Test04  
	 *@description 
	 *@time 2019年3月21日上午10:18:55
	 *@param 
	 *@return void
	 *@throws 
	 *@author shiboxue
	 *@history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	@Test
	public void Test04(){
		//查询redis key的过期时间，重启时值为-1
		//Long expire = redisTemplate.getExpire("shiboxue");
		//System.out.println(expire);
		//删除key
		//redisTemplate.delete("shiboxue");
		//System.out.println(redisTemplate.hasKey("shiboxue"));
		//redis使用opsForSet，set无序唯一，add值为新增的个数
		//Long add = redisTemplate.opsForSet().add("red_123", "1","2","3");
		//System.out.println(add);
		//System.out.println(redisTemplate.opsForSet().members("red_123"));
		//redis使用opsForHash
		//redisTemplate.opsForHash().put("hashValue","map1","map1-1"); 
		//System.out.println(redisTemplate.opsForHash().get("hashValue", "map1"));
		//redisTemplate.opsForHash().put("hashValue","map2","map2-2");  
		//System.out.println(redisTemplate.opsForHash().get("hashValue", "map2"));
		//redis使用opsForList,range -1代表全查
		/*redisTemplate.opsForList().leftPush("list","a");  
		redisTemplate.opsForList().leftPush("list","b");  
		redisTemplate.opsForList().leftPush("list","c"); */
		//redisTemplate.delete("list");
		//redisTemplate.opsForList().leftPushIfPresent("list1","a"); //已存在的集合中加值 
		//redisTemplate.opsForList().leftPushIfPresent("list1","b");  
		//redisTemplate.opsForList().leftPushIfPresent("list1","c"); 
		//System.out.println(redisTemplate.opsForList().range("list1", 0, -1));
		
	}
	
 
}