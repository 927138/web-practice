package common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DemoRepository {
	private Map<String, DemoUser> storage = Collections.synchronizedMap(new HashMap<String, DemoUser>());
	
	public DemoUser findById(String uuid) {
		DemoUser user = null;
		
		user = storage.get(uuid);
		
		return user;
	}
	
	
	public void createUser(DemoUser user) {
		
		if(Objects.isNull(user))
			throw new IllegalArgumentException("Demo");
		
	}
}
