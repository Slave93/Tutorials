package usingmyWS_SOAP;

import com.slavkoprogrammingworld.User;

import myws_soap.ManageUserService;
import myws_soap.ManageUsers;

public class Test {

	public static void main(String[] args) {
		ManageUserService mus = new ManageUserService();
		ManageUsers mu = mus.getManageUsersPort();
		for (User user : mu.getUsers()) {
			System.out.println(user.getName()+" has id "+ user.getId());
		}
	}

}
