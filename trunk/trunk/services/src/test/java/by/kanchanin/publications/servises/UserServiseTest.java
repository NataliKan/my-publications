package by.kanchanin.publications.servises;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.inject.Inject;


import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.AbstractServiceTest;
import by.kanchanin.publications.services.UserService;


public class UserServiseTest extends AbstractServiceTest{
	
	 @Inject
	    private UserService userService;

	    @Test
	    public void createUserTest() {

	        final UserAccount account = createUserAccount();
	        userService.createNewUser(account);

	        final UserAccount userFromDB = userService.get(account.getId());
	        Assert.assertNotNull(userFromDB);
	        Assert.assertEquals(userFromDB.getUserRole(), account.getUserRole());
			Assert.assertEquals(userFromDB.getEmail(), account.getEmail());
			Assert.assertEquals(userFromDB.getFirstName(),
					account.getFirstName());
			Assert.assertEquals(userFromDB.getLastName(), account.getLastName());
			Assert.assertEquals(userFromDB.getPassword(), account.getPassword());
	        
	        Assert.assertTrue(userFromDB.getCreated().compareTo(account.getCreated()) == 0);

	        userService.removeUser(account.getId());
	        Assert.assertNull(userService.get(account.getId()));

}

	    @Test
	    public void uniqueConstraintsTest() {
	        final UserAccount account = createUserAccount();
	        final String email = randomString("email");
	        account.setEmail(email);
	        userService.createNewUser(account);

	        final UserAccount duplicateAccount = createUserAccount();
	        duplicateAccount.setEmail(email);
	        try {
	            userService.createNewUser(duplicateAccount);
	            Assert.fail("Not unique login can't be saved.");
	        } catch (final PersistenceException e) {
	            // expected
	        }

	        // should be saved now
	        duplicateAccount.setEmail(randomString("email"));
	        userService.createNewUser(duplicateAccount);
	    }

	  //  @Test
	   // public void equalityTest() {
	   //     UserAccount userAccount = createUserAccount();

	   //     UserAccount userAccount1 = userService.get(userAccount.getId());
	   //     UserAccount userAccount2 = userService.get(userAccount.getId());

	   //     HashSet<UserAccount> hashSet = new HashSet<UserAccount>();
	    //    hashSet.add(userAccount1);
	    //    System.out.println("Hashset contains user1: " + hashSet.contains(userAccount1));
	    //    System.out.println("Hashset contains user2: " + hashSet.contains(userAccount2));

	     //   Map<Long, Object> map = new HashMap<Long, Object>();
	    //    map.put(userAccount1.getId(), new Object());
	     //   System.out.println("Hashmap contains key1: " + map.containsKey(userAccount1));
	     //   System.out.println("Hashmap contains key2: " + map.containsKey(userAccount2));

	//    }
	    
	    
		
}