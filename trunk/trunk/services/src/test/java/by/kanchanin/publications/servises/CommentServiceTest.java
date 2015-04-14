package by.kanchanin.publications.servises;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import by.kanchanin.publications.AbstractServiceTest;
import by.kanchanin.publications.datamodel.Comment;
import by.kanchanin.publications.services.CommentService;


public class CommentServiceTest extends AbstractServiceTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceTest.class);

    @Inject
    private CommentService commentService;
    
    @Before
    public void cleanUpData() {
        LOGGER.info("Instance of ProductService is injected. Class is: {}", commentService.getClass().getName());
        commentService.removeComment(null);
    }
	
    @Test
    public void basicCRUDTest() {
    	Comment comment = createComment();
        commentService.saveOrUpdate(comment);

        Comment CommentFromDb = commentService.get(comment.getId());
        Assert.assertNotNull(CommentFromDb);
        

        
        commentService.saveOrUpdate(CommentFromDb);
        Comment commentFromDbUpdated = commentService.get(comment.getId());

        commentService.removeComent(commentFromDbUpdated);
        Assert.assertNull(commentService.get(comment.getId()));
    }


}
