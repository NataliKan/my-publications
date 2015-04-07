package by.kanchanin.publications.services.impl;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.UserAccountDao;
import by.kanchanin.publications.dataaccess.UserProfileDao;
import by.kanchanin.publications.services.UserService;
import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.datamodel.UserProfile;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
    private UserAccountDao accountDao;
    @Inject
    private UserProfileDao profileDao;

    
    public void createNewUser(UserProfile profile, UserAccount account) {
    /*    Validate.isTrue(account.getId() == null, "This method should be called for 'not saved yet' account only. Use UPDATE instead");
        accountDao.insert(account);*/

        Validate.isTrue(profile.getId() == null, "This method should be called for 'not saved yet' profile only. Use UPDATE instead");
        profile.setUserAccount(account);
        profileDao.insert(profile);
    }

    
    public UserProfile get(Long id) {
        return profileDao.getById(id);
    }

    
    public void updateProfile(UserProfile profile) {
        profileDao.update(profile);
    }

    
    public void removeUser(Long id) {

        profileDao.delete(id);
        accountDao.delete(id);

    }

}
