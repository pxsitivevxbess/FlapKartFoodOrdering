package InMemoryCache;

import Service.CacheService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 10;
		CacheService inMemoryCache = CacheService.getInstance();
		inMemoryCache.init(cacheSize);
		Boolean putOutput = inMemoryCache.put(1,  3);
		Object getOutput  = inMemoryCache.get(1);
		System.out.println(putOutput);
		System.out.println(getOutput);

	}

}
