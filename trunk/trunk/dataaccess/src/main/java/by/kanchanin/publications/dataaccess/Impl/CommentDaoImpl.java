package by.kanchanin.publications.dataaccess.Impl;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.CommentDao;
import by.kanchanin.publications.datamodel.Comment;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Long, Comment> implements CommentDao {

    protected CommentDaoImpl() {
        super(Comment.class);
    }

	@Override
	public List<Comment> getAllByFieldRestriction(
			SingularAttribute<? super Comment, ?> attribute, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
