package DAO;

import java.util.HashMap;
import java.util.LinkedList;

import Model.LRUCache;

public class CacheDAO {
	private static CacheDAO instance = null;
	private LRUCache cache = null;
	private CacheDAO()
	{
		
		
	}
	public static CacheDAO getInstance()
	{
	  if(instance==null)
	  {
		  instance = new CacheDAO();
	  }
	  return instance;
	}
	public LRUCache createCache(int size)
	{
		cache = new LRUCache(size);
		return cache;
	}
	public Boolean get(Object obj)
	{
		HashMap<Object,Object> cacheStore = cache.getCacheStore();
        return cacheStore.get(obj)==null?false:true;
		
	}
	public Boolean put(Object key, Object value)
	{
		//Bring the node top head of L.L if already exist otherwise insert check for size limit
		//If insert new thing then insert in hashmap(unordered_map)
		try {
		HashMap<Object,Object> cacheStore = cache.getCacheStore();
		LinkedList<Object> dataStore = cache.getDataStore();
		if(cacheStore.containsKey(key))
		{
		   dataStore.remove(key);
		   dataStore.addFirst(key);
		}
		else {
			 int sizeLimitOfCache = cache.getSize();
			 System.out.println(cacheStore.size());
			 
			 if(sizeLimitOfCache>=cacheStore.size()&&cacheStore.size()>0)
			 {
				Object leastRecentObj = dataStore.getLast();
				cacheStore.remove(leastRecentObj);
				dataStore.pollLast();
			}
			 cacheStore.put(key, value);
			 dataStore.addFirst(key);
		}
		return true;
		}catch(Exception error)
		{
			System.out.print( error);
			return false;
		}
		
	}
	public Boolean delete(Object key)
	{
		try {
		HashMap<Object,Object> cacheStore = cache.getCacheStore();
		LinkedList<Object> dataStore = cache.getDataStore();
		dataStore.remove(key);
		cacheStore.remove(key);
		return true;
		}catch(Exception error)
		{
			System.out.printf("Error in cacheDao in delete fn", error);
			return false;
		}
		
	}
	public Boolean clear()
	{
		return cache.clear();
	}

}
