package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.Comment;


public interface CommentService {
	
	@Transactional
    void createNewComment(Comment comment);

    @Transactional
    Comment get(Long id);

    @Transactional
    void saveOrUpdate(Comment comment);

    @Transactional
    void removeComment(Long id);

}
