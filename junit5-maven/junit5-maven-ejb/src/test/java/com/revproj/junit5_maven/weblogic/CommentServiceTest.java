package com.revproj.junit5_maven.weblogic;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.InjectIntoMany;
import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.db.transaction.Runnable;
import de.akquinet.jbosscc.needle.db.transaction.TransactionHelper;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import de.akquinet.jbosscc.needle.junit.NeedleRule;
import com.revproj.junit5_maven.dao.CommentDaoBean;
import com.revproj.junit5_maven.injectionprovider.CurrentUserInjectionProvider;
import com.revproj.junit5_maven.model.BlogEntry;
import com.revproj.junit5_maven.model.Comment;
import com.revproj.junit5_maven.testdata.BlogEntryTestdataBuilder;
import com.revproj.junit5_maven.weblogic.CommentServiceBean;

public class CommentServiceTest {

	@Rule
	public DatabaseRule databaseRule = new DatabaseRule();

	@Rule
	public NeedleRule needleRule = new NeedleRule(
			new CurrentUserInjectionProvider(), databaseRule);

	@ObjectUnderTest
	private CommentServiceBean commentService;

	@SuppressWarnings("unused")
	@InjectIntoMany
	@ObjectUnderTest
	private CommentDaoBean commentDao;

	private BlogEntry blogEntry = new BlogEntryTestdataBuilder(
			databaseRule.getEntityManager()).buildAndSave();

	@Test
	public void testCreateAndPersist() throws Exception {
		TransactionHelper transactionHelper = databaseRule
				.getTransactionHelper();

		Long id = transactionHelper.executeInTransaction(new Runnable<Long>() {

			@Override
			public Long run(EntityManager entityManager) throws Exception {
				Comment instance = commentService.getInstance();
				instance.setBlogEntry(blogEntry);
				entityManager.persist(instance.getAuthor());
				instance.setContent("comment");

				commentService.save();

				return instance.getId();
			}
		});

		Comment commentFromDb = databaseRule.getTransactionHelper().loadObject(
				Comment.class, id);

		Assert.assertNotNull(commentFromDb);

	}

}
