package com.scholanova.projectdb.test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.scholanova.projectdb.models.Message;
import com.scholanova.projectdb.repositories.MessageRepositories;

@SpringJUnitConfig(MessageRepositories.class)
@JdbcTest
class MessageRepositoriesTest {
	
	@Autowired
	private MessageRepositories messageRepositories;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@AfterEach
	void cleanUp() {
		jdbcTemplate.update("TRUNCATE TABLE message RESTART IDENTITY");
	}
	
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	void testListAllBaseVide() {
		assertEquals(messageRepositories.listAll().size(), 0);
	}
	
	@Test
	void testListAllBase2insert() {
		messageRepositories.insert(new Message(0,"MSG 1"));
		messageRepositories.insert(new Message(0,"MSG 2"));
		
		assertEquals(messageRepositories.listAll().size(), 2);
	}
	
	
}
