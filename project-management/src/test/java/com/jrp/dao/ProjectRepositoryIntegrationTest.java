package com.jrp.dao;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrp.pma.ProjectManagementApplication;

@ContextConfiguration(classes=ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath: schema.sql", "classpath:data.sql"}),
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts= {"classpath:data.sql"})})
public class ProjectRepositoryIntegrationTest {
	
}
