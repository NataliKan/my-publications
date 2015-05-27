package by.kanchanin.publications.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.Comment;
import by.kanchanin.publications.datamodel.Periodical;


public interface CommentService {
	
	@Transactional
    void createNewComment(Comment comment);

    @Transactional
    Comment get(Long id);

    @Transactional
    void saveOrUpdate(Comment comment);

    
    List<Comment> getAllByPeriodical(Periodical periodical);

	void delete(Comment comment);

	void deleteAll();
    


}
