package by.kanchanin.publications.dataaccess.Impl;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.UserAccountDao;
import by.kanchanin.publications.datamodel.UserAccount;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<Long, UserAccount> implements UserAccountDao {

    protected UserAccountDaoImpl() {
        super(UserAccount.class);
    }


}
