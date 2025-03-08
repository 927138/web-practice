package common.filter;

import java.util.Objects;
import java.util.UUID;

import common.DemoDB;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import repository.DemoUser;


@WebListener
public class DemeDBStorageContextListener implements ServletContextListener {
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("listener inject");
		
		if(Objects.nonNull(sce.getServletContext().getAttribute("storage"))) {
			System.out.println("sec call context Listener");
		}
		
		DemoDB storage = new DemoDB();
		
		
		for(int i=1; i<11; i++) {
			String uuid = UUID.randomUUID().toString();
			String id = String.valueOf(i);
			String pw = String.valueOf(i);
			String email = null;
			if(i%2 == 0) {
				email = i + "@test.com";
			}
			
			storage.addDemoUser(DemoUser.createUser(uuid, id, pw, email));
		}
		
		
		sce.getServletContext().setAttribute("storage", storage);
	}
	
	
	
}
