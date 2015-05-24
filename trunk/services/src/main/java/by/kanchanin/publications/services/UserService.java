package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.datamodel.enums.UserRole;

public interface UserService {
	
	@Transactional
    void createNewUser(UserAccount account);

    @Transactional
    UserAccount get(Long id);
   

    @Transactional
    void updateAccount(UserAccount account);

    @Transactional
    void removeUser(Long id);
    
    UserAccount getAccountByEmail(String userName);

    List<UserRole> getRoles(Long userId);



}
