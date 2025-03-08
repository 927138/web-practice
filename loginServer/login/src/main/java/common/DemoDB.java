package common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import repository.DemoUser;

public class DemoDB implements Repository {
	private final Map<String, DemoUser> storage = Collections.synchronizedMap(new HashMap<String, DemoUser>());
	
	
	public void addDemoUser(DemoUser user) {
		storage.put(user.getUserId(), user);
	}
	
	public void deleteDemoUser(String userId) {
		storage.remove(userId);
	}
	
	public void updateDemoUser(DemoUser user) {
		storage.replace(user.getUserId(), user);
	}
	
	public DemoUser getDemoUser(String userId) {
		return storage.get(userId);
	}
	
	public Map<String, DemoUser> allList(){
		return storage;
	}
} 
