package Service;

import DAO.CacheDAO;
import Model.LRUCache;

//CacheService is singleton class
public class CacheService {
	private static CacheService instance = null;
	private CacheDAO cacheDao = CacheDAO.getInstance();
	private CacheService()
	{
		
	}
	public static CacheService getInstance()
	{
		if(instance==null)
		{
			instance = new CacheService();
		}
		return instance;
	}
	
	
	public LRUCache init(int size)
	{
		return cacheDao.createCache(size);
	}
	public Object get(Object obj)
	{
		return cacheDao.get(obj);
	}
	public Boolean put(Object key, Object val)
	{
		return cacheDao.put(key, val);
	}
	public Boolean delete(Object key)
	{
		return cacheDao.delete(key);
	}
	public Boolean clear()
	{
		return cacheDao.clear();
	}

}
