package by.kanchanin.publications.dataaccess.Impl;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.CommentDao;
import by.kanchanin.publications.datamodel.Comment;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Long, Comment> implements CommentDao {

    protected CommentDaoImpl() {
        super(Comment.class);
    }

}
