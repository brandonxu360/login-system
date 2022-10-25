/*
 * Author: Brandon Xu
 * Date: 10/25/22
 * Description: IDandPasswords
 */

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	IDandPasswords() {
		loginInfo.put("Bro", "pizza");
		loginInfo.put("Brometheus", "PASSWORD");
		loginInfo.put("Timbo", "fat pig");
		
	}
	
	public void add(String key, String val) {
		loginInfo.put(key, val);
	}
	
	protected HashMap getLoginInfo() {
		return loginInfo;
	}
}
