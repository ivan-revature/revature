package com.revproj.junit5_maven.weblogic;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.InjectIntoMany;
import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.db.transaction.Runnable;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import de.akquinet.jbosscc.needle.junit.NeedleRule;
import com.revproj.junit5_maven.dao.BlogEntryDao;
import com.revproj.junit5_maven.dao.BlogEntryDaoBean;
import com.revproj.junit5_maven.injectionprovider.CurrentUserInjectionProvider;
import com.revproj.junit5_maven.model.BlogEntry;
import com.revproj.junit5_maven.testdata.BlogEntryTestdataBuilder;
import com.revproj.junit5_maven.weblogic.BlogEntryService;
import com.revproj.junit5_maven.weblogic.BlogEntryServiceBean;

public class BlogEntryServiceTest {

	@Rule
	public DatabaseRule databaseRule = new DatabaseRule();

	@Rule
	public NeedleRule needleRule = new NeedleRule(databaseRule,
			new CurrentUserInjectionProvider());

	@ObjectUnderTest(implementation = BlogEntryServiceBean.class)
	private BlogEntryService blogEntryService;

	@SuppressWarnings("unused")
	@InjectIntoMany
	@ObjectUnderTest(implementation = BlogEntryDaoBean.class)
	private BlogEntryDao blogEntryDao;

	@Test
	public void testPersistNewInstance() throws Exception {

		final Long id = databaseRule.getTransactionHelper()
				.executeInTransaction(new Runnable<Long>() {

					@Override
					public Long run(EntityManager entityManager)
							throws Exception {

						blogEntryService.newInstance();
						BlogEntry instance = blogEntryService.getInstance();
						entityManager.persist(instance.getAuthor());
						instance.setTitle("title");
						instance.setContent("content");
						blogEntryService.persistOrUpdate();

						return instance.getId();
					}

				});

		BlogEntry blogEntry = databaseRule.getTransactionHelper().loadObject(
				BlogEntry.class, id);

		Assert.assertNotNull(blogEntry);

	}

	@Test
	public void testGetInstanceById() throws Exception {
		BlogEntry blogEntry = new BlogEntryTestdataBuilder(
				databaseRule.getEntityManager()).buildAndSave();

		blogEntryService.setId(blogEntry.getId());

		BlogEntry instance = blogEntryService.getInstance();

		Assert.assertEquals(blogEntry.getId(), instance.getId());
	}

	@Test
	public void testDelete() throws Exception {
		BlogEntry blogEntry = new BlogEntryTestdataBuilder(
				databaseRule.getEntityManager()).buildAndSave();

		// init instance
		blogEntryService.setId(blogEntry.getId());
		blogEntryService.getInstance();

		blogEntryService.delete();

		BlogEntry loadObject = databaseRule.getTransactionHelper().loadObject(
				BlogEntry.class, blogEntry.getId());

		Assert.assertNull(loadObject);

	}

}
