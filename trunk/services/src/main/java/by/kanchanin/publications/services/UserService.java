package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.datamodel.UserProfile;

public interface UserService {
	
	@Transactional
    void createNewUser(UserProfile profile, UserAccount account);

    @Transactional
    UserProfile get(Long id);

    @Transactional
    void updateProfile(UserProfile profile);

    @Transactional
    void removeUser(Long id);

}
