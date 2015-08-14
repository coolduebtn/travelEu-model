package com.travel.repo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.travel.model.City;
import com.travel.model.Country;
import com.travel.model.Attraction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration
@Transactional
public abstract class AbstractRepositoryIntegrationTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Before
	public void before() {

		deleteTable(Attraction.class);
		deleteTable(City.class);
		deleteTable(Country.class);

	}

	private void deleteTable(Class clazz) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query createQuery = currentSession.createQuery("delete from "
				+ clazz.getName());
		createQuery.executeUpdate();
		currentSession.flush();
	}

}
