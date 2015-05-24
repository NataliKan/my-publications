package by.kanchanin.publications.services.impl;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.UserAccountDao;
import by.kanchanin.publications.services.UserService;
import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.datamodel.UserAccount_;
import by.kanchanin.publications.datamodel.enums.UserRole;

@Service
public class UserServiceImpl implements UserService{
	
	private static final String VALIDATION_ERROR = "This method should be called for 'not saved yet'23 с profile only. Use UPDATE instead";
	@Inject
    private UserAccountDao accountDao;

    @Override
    public void createNewUser(UserAccount account) {
    /*    Validate.isTrue(account.getId() == null, "This method should be called for 'not saved yet' account only. Use UPDATE instead");
        accountDao.insert(account);*/

        Validate.isTrue(account.getId() == null, VALIDATION_ERROR);
        accountDao.insert(account);
    }

    @Override
    public UserAccount get(Long id) {
        return accountDao.getById(id);
    }

    @Override
    public void updateAccount(UserAccount account) {
    	accountDao.update(account);
    }

    @Override
    public void removeUser(Long id) {

        accountDao.delete(id);

    }

	@Override
	public UserAccount getAccountByEmail(String userName) {
		final List<UserAccount> allByFieldRestriction = accountDao.getAllByFieldRestriction(UserAccount_.email, userName);
		return !allByFieldRestriction.isEmpty() ? allByFieldRestriction.get(0) : null;
	}

	@Override
	public List<UserRole> getRoles(Long userId) {
		// FIXME replace with call to DB
				return Arrays.asList(UserRole.administrator);
	}

}
