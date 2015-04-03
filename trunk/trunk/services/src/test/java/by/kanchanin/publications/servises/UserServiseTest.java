package by.kanchanin.publications.servises;

import java.util.Arrays;

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
	    public void crudTest() {

	        final UserProfile profile = createUserProfile();
	        final UserAccount account = createUserAccount();
	        userService.createNewUser(profile, account);

	        final UserProfile createdUser = userService.get(profile.getId());
	        Assert.assertNotNull(createdUser);
	        // TODO check equals

}
