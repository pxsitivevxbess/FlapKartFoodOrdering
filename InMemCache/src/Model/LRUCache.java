package Model;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

	private int size;
	private LinkedList<Object> dataStore;
	private HashMap<Object, Object> cacheStore; //Unordered_map
	public LRUCache(int size)
	{
		this.size = size;
		this.dataStore = new LinkedList<>();
		this.cacheStore = new HashMap<>();
	}
	public boolean clear()
	{
		try {
			this.dataStore = new LinkedList<>();
			this.cacheStore = new HashMap<>();
			return true;
			
		}catch(Exception error) {
			System.out.println(error);
		}
		return false;
	}
	public LinkedList<Object> getDataStore() {
		return dataStore;
	}
	public void setDataStore(LinkedList<Object> dataStore) {
		this.dataStore = dataStore;
	}
	public HashMap<Object, Object> getCacheStore() {
		return cacheStore;
	}
	public void setCacheStore(HashMap<Object, Object> cacheStore) {
		this.cacheStore = cacheStore;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
