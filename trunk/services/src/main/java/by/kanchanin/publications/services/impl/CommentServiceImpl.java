package by.kanchanin.publications.services.impl;


import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.CommentDao;
import by.kanchanin.publications.services.CommentService;
import by.kanchanin.publications.datamodel.Comment;
import by.kanchanin.publications.datamodel.Comment_;
import by.kanchanin.publications.datamodel.Periodical;

@Service
public class CommentServiceImpl implements CommentService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);
	
	@Inject
    private CommentDao commentDao;
	
	public  void createNewComment(Comment comment) {
        Validate.isTrue(comment.getId() == null, "This method should be called for 'not saved yet' profile only. Use UPDATE instead");
        commentDao.insert(comment);
    }
	
	public Comment get(Long id) {
		return commentDao.getById(id);
	}
	
	public void saveOrUpdate(Comment comment) {
		 if (comment.getId() == null) {
	            LOGGER.debug("Save new: {}", comment);
	            commentDao.insert(comment);
	        } else {
	            LOGGER.debug("Update: {}", comment);
	            commentDao.update(comment);
	        }
	}
	

	
	@Override
	public List<Comment> getAllByPeriodical(Periodical periodical) {
		return commentDao.getAllByFieldRestriction(Comment_.periodical, periodical, Comment_.periodical,
				Comment_.userAccount);
	}

	@Override
	public void delete(Comment comment) {
		commentDao.delete(comment);
		
	}

	@Override
	public void deleteAll() {
		LOGGER.debug("Remove all");
		commentDao.deleteAll();
	}
		
	}


