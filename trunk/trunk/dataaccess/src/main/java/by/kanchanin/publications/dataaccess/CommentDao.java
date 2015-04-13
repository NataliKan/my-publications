package by.kanchanin.publications.dataaccess;

import by.kanchanin.publications.datamodel.Comment;


public interface CommentDao extends AbstractDao<Long, Comment>{
	
	void updateComment(Long id, String comment);

}
