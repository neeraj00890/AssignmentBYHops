package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Workingpkg.LoginLogout;
public class LoginLogoutTest {

	
	private LoginLogout  loginLogout;
	
	
	
	/*
	 * 
	 * Perform Login Test Case
	 */
	
	@Before
	public void beforeSetUp() {
		loginLogout= new LoginLogout();
	}
	
	@Test
	public void LoginTestWithCorrectUserNameAndPassword() throws Exception {
		assertTrue(loginLogout.performLogin("Neeraj006", "Password2"));
	}
	@Test(expected=Exception.class)
	public void LoginTestWithWrongUserNameAndPassword() throws Exception {
		loginLogout.performLogin("Neera", "Password2");
		
	}
	@Test()
	public void LoginTestForTestingUserNameCaseSenstivity() throws Exception {
		assertTrue(loginLogout.performLogin("Neeraj006", "Password2"));
		assertTrue(loginLogout.performLogin("NEERAJ006", "Password2"));
		
	}
	@Test(expected=Exception.class)
	public void LoginTestForTestingPasswordCaseSenstivity() throws Exception {
		loginLogout.performLogin("Neeraj006", "PASSSWORD2");	
	}
	
	@Test()
	public void LoginTestifUserisAddedinSession() throws Exception {
		loginLogout.performLogin("Neeraj006", "Password2")	;
		assertTrue(loginLogout.loggedInUsersSession.size()>0);
	}
	@Test()
	public void LoginTestifUserisNotAddedinSessionOnWrongCredential()  {
		loginLogout=new LoginLogout();
		try {
		loginLogout.performLogin("Neeraj0", "Password2")	;
		}
		catch(Exception e) {
			// add try catch just to continue code execuation
		}
		assertTrue(loginLogout.loggedInUsersSession.size()==0);
	}
	
	
	
	/*
	 * 
	 * Perform Logout Test Case
	 * 
	 */
	
	@Test
	public void performLogoutTest() throws Exception {
		assertTrue(loginLogout.performLogin("Neeraj006", "Password2"));  //Putting User in Session
		assertTrue(loginLogout.performLogout("Neeraj006"));
		
	}
	
	@Test(expected=Exception.class)
	public void performLogoutIfUserSessionExpired() throws Exception {
		assertTrue(loginLogout.performLogout("Neeraj006"));
	}
	
	@Test
	public void performLogoutUserShouldGetRemovedFromSessionOnLogout() throws Exception {
		loginLogout=new LoginLogout();
		assertTrue(loginLogout.performLogin("Neeraj006", "Password2"));    //Insteasd of Calling we  can use PowerMocitoFrameWork
		assertTrue(loginLogout.performLogout("Neeraj006"));
		assertTrue(loginLogout.loggedInUsersSession.size()==0);
	}
	
	
	
}

