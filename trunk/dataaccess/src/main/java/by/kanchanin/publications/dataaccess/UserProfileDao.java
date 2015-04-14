package by.kanchanin.publications.dataaccess;

import by.kanchanin.publications.datamodel.UserProfile;

public interface UserProfileDao extends AbstractDao<Long, UserProfile>{
	
	 Long getCount();

}
