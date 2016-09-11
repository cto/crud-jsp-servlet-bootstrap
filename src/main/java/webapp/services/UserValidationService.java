package webapp.services;

import java.util.HashMap;
import java.util.Map;

public class UserValidationService {

	private Map<String, String> userNameToPassword;
	
	private static UserValidationService instance;
	
	private UserValidationService(){
		fetchCredentials();
	}
	
	private void fetchCredentials(){
		userNameToPassword = new HashMap<>();
		userNameToPassword.put("cuong", "vananh");
	}
	
	public static UserValidationService getInstance(){
		if (null == instance){
			instance = new UserValidationService();
		}
		
		return instance;
	}
	
	public boolean isUserAllowed(String userName, String password)
	{
		return password.equals(userNameToPassword.get(userName));
	}
}
