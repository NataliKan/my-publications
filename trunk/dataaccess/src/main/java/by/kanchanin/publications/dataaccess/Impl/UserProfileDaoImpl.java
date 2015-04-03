package by.kanchanin.publications.dataaccess.Impl;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.UserProfileDao;
import by.kanchanin.publications.datamodel.UserProfile;

@Repository
public class UserProfileDaoImpl extends AbstractDaoImpl<Long, UserProfile> implements UserProfileDao {

    protected UserProfileDaoImpl() {
        super(UserProfile.class);
    }


}
