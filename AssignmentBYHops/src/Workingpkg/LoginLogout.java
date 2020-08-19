package Workingpkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import model.User;

public class LoginLogout {

	List<User>    VALID_USER = Arrays.asList(new User("Neeraj007", "Password1"), 
			new User("Neeraj006", "Password2"),
			new User("Neeraj005", "Password3"),
			new User("Neeraj004", "Password4"),
			new User("Neeraj003", "Password5"),
			new User("Neeraj002", "Password6"),
			new User("Neeraj001", "Password6"));

	public List<User> loggedInUsersSession = new ArrayList();

	public Boolean performLogin(String userName, String password) throws Exception {
		Optional<User> usr = VALID_USER.stream()
				.filter((user) -> user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password))
				.findAny();

		if (!usr.isPresent()) {
			throw new Exception("Bad credential");
		}
		loggedInUsersSession.add(usr.get());
		return true;

	}

	public Boolean performLogout(String userName) throws Exception {
		Optional<User> usr=loggedInUsersSession.stream()
		.filter((user)->user.getUserName().equalsIgnoreCase(userName))
		.findFirst();
		if(!usr.isPresent()) {
			throw new Exception("Session already invalidated");
		}
		loggedInUsersSession.remove(usr.get());
		return true;
		
	}
}
