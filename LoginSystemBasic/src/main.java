/*
 * Author: Brandon Xu
 * Date: 10/25/22
 * Description: Main: creates instances of the login page and hashmap of login info
 */


public class main {

	public static void main(String[] args) {
		
		//create instance of IDandPasswords class to hold the hashmap of usernames and passwords
		IDandPasswords idandPasswords = new IDandPasswords();
		
		//create instance of the login page
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
		

	}

}
