package by.kanchanin.publications.servises;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.inject.Inject;


import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.datamodel.UserProfile;
import by.kanchanin.publications.AbstractServiceTest;
import by.kanchanin.publications.services.UserService;

public class UserServiseTest extends AbstractServiceTest{
	
	 @Inject
	    private UserService userService;

	    @Test
	    public void createUserTest() {

	        final UserProfile profile = createUserProfile();
	        final UserAccount account = createUserAccount();
	        userService.createNewUser(profile, account);

	        final UserProfile createdUser = userService.get(profile.getId());
	        Assert.assertNotNull(createdUser);
	        
	        Assert.assertTrue(createdUser.getCreated().compareTo(profile.getCreated()) == 0);

	        userService.removeUser(profile.getId());
	        Assert.assertNull(userService.get(profile.getId()));

}

	    @Test
	    public void uniqueConstraintsTest() {
	        final UserProfile profile = createUserProfile();
	        final String email = randomString("email");
	        final UserAccount account = createUserAccount();
	        account.setEmail(email);
	        profile.setUserAccount(account);
	        userService.createNewUser(profile, account);

	        final UserProfile duplicateProfile = createUserProfile();
	        final UserAccount duplicateAccount = createUserAccount();
	        duplicateAccount.setEmail(email);
	        duplicateProfile.setUserAccount(duplicateAccount);
	        try {
	            userService.createNewUser(duplicateProfile, duplicateAccount);
	            Assert.fail("Not unique login can't be saved.");
	        } catch (final PersistenceException e) {
	            // expected
	        }

	        // should be saved now
	        duplicateAccount.setEmail(randomString("email"));
	        userService.createNewUser(duplicateProfile, duplicateAccount);
	    }

	    @Test
	    public void equalityTest() {
	        UserProfile userProfile = createUserProfile();
	        userService.createNewUser(userProfile, createUserAccount());

	        UserProfile userProfile1 = userService.get(userProfile.getId());
	        UserProfile userProfile2 = userService.get(userProfile.getId());

	        HashSet<UserProfile> hashSet = new HashSet<UserProfile>();
	        hashSet.add(userProfile1);
	        System.out.println("Hashset contains user1: " + hashSet.contains(userProfile1));
	        System.out.println("Hashset contains user2: " + hashSet.contains(userProfile2));

	        Map<Long, Object> map = new HashMap<Long, Object>();
	        map.put(userProfile1.getId(), new Object());
	        System.out.println("Hashmap contains key1: " + map.containsKey(userProfile1));
	        System.out.println("Hashmap contains key2: " + map.containsKey(userProfile2));

	    }
		
}