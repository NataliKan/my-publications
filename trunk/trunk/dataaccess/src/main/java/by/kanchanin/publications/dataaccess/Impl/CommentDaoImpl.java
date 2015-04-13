package by.kanchanin.publications.dataaccess.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.SingularAttribute;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.CommentDao;
import by.kanchanin.publications.datamodel.Comment;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Long, Comment> implements CommentDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentDaoImpl.class);

	private EntityManager em;
	private final Class<Comment> commentClass;

    protected CommentDaoImpl() {
        super(Comment.class);
    }

	@Override
	public List<Comment> getAllByFieldRestriction(
			SingularAttribute<? super Comment, ?> attribute, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Comment update(Comment comment) {
		comment = em.merge(comment);
		em.flush();
		return comment;
	}
	
	

}
