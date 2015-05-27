package by.kanchanin.publications.servises;

import javax.inject.Inject;

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

	private static final Object ommentFromDb = null;

    @Inject
    private CommentService commentService;
    
    @Before
    public void cleanUpData() {
        LOGGER.info("Instance of ProductService is injected. Class is: {}", commentService.getClass().getName());
        commentService.deleteAll();
    }
	
    @Test
    public void basicCRUDTest() {
    	Comment comment = createComment();
        commentService.saveOrUpdate(comment);

        Comment commentFromDb = commentService.get(comment.getId());
        Assert.assertNotNull(ommentFromDb);
        Assert.assertEquals(commentFromDb.getPeriodical(), comment.getPeriodical());
		Assert.assertEquals(commentFromDb.getUserAccount().getId(), comment.getUserAccount()
				.getId());

		commentFromDb.setComment("newComment");
		commentService.saveOrUpdate(commentFromDb);
		Comment commentFromDbUpdated = commentService.get(comment.getId());
		Assert.assertEquals(commentFromDb.getComment(),
				commentFromDbUpdated.getComment());
		Assert.assertNotEquals(commentFromDbUpdated.getComment(),
				comment.getComment());

		commentService.delete(commentFromDbUpdated);
		Assert.assertNull(commentService.get(comment.getId()));
	}
    
    
        


}
    
